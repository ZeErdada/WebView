package zhangxuelei1506d.week3_test_demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * date 2017/8/20
 * author:张学雷(Administrator)
 * functinn:
 */

public class myBaseAdapter extends BaseAdapter{
     private List<nyBean.ApkBean> list;
         private Context context;

    public myBaseAdapter(List<nyBean.ApkBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
         public int getCount() {
             return list.size();
         }

         @Override
         public Object getItem(int position) {
             return null;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             viewHolder holder=null;
             if (convertView==null){
                 holder=new viewHolder();
                 convertView=convertView.inflate(context,R.layout.item,null);
                 holder.name= (TextView) convertView.findViewById(R.id.name);
                 holder.categoryName= (TextView) convertView.findViewById(R.id.categoryName);
                 holder.iconUrl= (ImageView) convertView.findViewById(R.id.iconUrl);

                 convertView.setTag(holder);

             }else{
                 holder= (viewHolder) convertView.getTag();
             }
             holder.categoryName.setText(list.get(position).categoryName);
             holder.name.setText(list.get(position).name);

             ImageOptions options = new ImageOptions.Builder()
                     //设置图片的大小
                     .setSize(300, 300)
                     // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                     .setCrop(true)
                     // 加载中或错误图片的ScaleType
                     //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                     .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                     //设置加载过程中的图片
                     .setLoadingDrawableId(R.mipmap.ic_launcher)
                     //设置加载失败后的图片
                     .setFailureDrawableId(R.mipmap.ic_launcher)
                     //设置使用缓存
                     .setUseMemCache(true)
                     //设置支持gif
                     .setIgnoreGif(false).setCircular(true).build();
             //设置显示圆形图片
             // .setCircular(true).build();
             x.image().bind(holder.iconUrl, list.get(position).iconUrl);


             return convertView;
         }
         class viewHolder{
             TextView name;
             TextView categoryName;
             ImageView iconUrl;

         }

}
