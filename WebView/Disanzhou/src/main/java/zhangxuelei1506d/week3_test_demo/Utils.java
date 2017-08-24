package zhangxuelei1506d.week3_test_demo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * date 2017/8/20
 * author:张学雷(Administrator)
 * functinn:
 */

public class Utils {



    public static boolean WifiIscontent(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null) {
            return true;

        }

        return false;
    }
}
