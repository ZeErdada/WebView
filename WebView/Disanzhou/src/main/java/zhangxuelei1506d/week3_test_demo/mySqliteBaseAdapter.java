package zhangxuelei1506d.week3_test_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;

/**
 * date 2017/8/20
 * author:张学雷(Administrator)
 * functinn:
 */

public class mySqliteBaseAdapter extends SQLiteOpenHelper{
    public mySqliteBaseAdapter(Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user(id integer primary key autoincrement,name text,categoryName text,iconUrl text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
