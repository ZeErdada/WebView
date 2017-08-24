package zhangxuelei1506d.week3_test_demo;

import android.app.Application;

import org.xutils.x;

/**
 * date 2017/8/20
 * author:张学雷(Administrator)
 * functinn:
 */

public class myApp extends Application{

    @Override
    public void onCreate() {
        x.Ext.init(this);
    }
}
