package zhangxuelei1506d.week3_test_demo;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    private String path = "http://huixinguiyu.cn/Assets/js/data.js";
    private ListView listView;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySqliteBaseAdapter database=new mySqliteBaseAdapter(this);
        db = database.getWritableDatabase();

        init();
        boolean networkConnected = Utils.WifiIscontent(this);

        if (networkConnected == true) {

            RequestParams params = new RequestParams(path);

            x.http().get(params, new Callback.CommonCallback<String>() {


                @Override
                public void onSuccess(String result) {


                    List<nyBean.ApkBean> list = new ArrayList<nyBean.ApkBean>();
                    Gson gson = new Gson();
                    nyBean bean = gson.fromJson(result, nyBean.class);

                    list = bean.apk;


                    myBaseAdapter adapter=new myBaseAdapter(list,MainActivity.this);
                    listView.setAdapter(adapter);

                      for (int i = 0; i < list.size(); i++) {

                          ContentValues values=new ContentValues();
                          values.put("name",list.get(i).name);
                          values.put("categoryName",list.get(i).categoryName);
                          values.put("iconUrl",list.get(i).iconUrl);
                          db.insert("user",null,values);



                              }


                }


                @Override
                public void onError(Throwable ex, boolean isOnCallback) {

                }

                @Override
                public void onCancelled(CancelledException cex) {


                }

                @Override
                public void onFinished() {

                }
            });


        } else

        {
            Toast.makeText(this, "当前网络已断开", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("警告");
            dialog.setMessage("当前网络没有连接要去链接一下么？");
            dialog.setNegativeButton("取消",null);
            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                }
            });
            dialog.create();
            dialog.show();


            List<nyBean.ApkBean> list2=new ArrayList<>();
            Cursor cursor = db.query("user", null, null, null, null, null, null);
            while (cursor.moveToNext()){

                nyBean.ApkBean dd=new nyBean.ApkBean();
                dd.name=cursor.getString(cursor.getColumnIndex("name"));
                dd.categoryName=cursor.getString(cursor.getColumnIndex("categoryName"));
                dd.iconUrl=cursor.getString(cursor.getColumnIndex("iconUrl"));
                list2.add(dd);

            }

            myBaseAdapter adapter=new myBaseAdapter(list2,MainActivity.this);
            listView.setAdapter(adapter);


        }


    }

    private void init() {
        listView = (ListView) findViewById(R.id.listview);
    }
}
