package zhangxuelei1506d.week3_test_demo;

import com.google.gson.Gson;

import java.util.List;

/**
 * date 2017/8/20
 * author:张学雷(Administrator)
 * functinn:
 */

public class nyBean {



    public int dataSize;
    public List<ApkBean> apk;



    public static class ApkBean {



        public String id;
        public String name;
        public String iconUrl;
        public String downloadUrl;
        public String packageName;
        public String versionName;
        public String versionCode;
        public String apkSize;
        public String downloadTimes;
        public String categoryName;
        public String from;
        public int markid;


    }
}
