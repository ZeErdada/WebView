package com.example.administrator.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;

/**
 * 1、搭建环境
 * 2、布局文件里使用webView控件
 * 3、加载网页
 * 4、解决跳转浏览器的操作
 */
public class MainActivity extends AppCompatActivity {

    private WebView www_wb;
    private EditText path_et;
    private ProgressBar webView_pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        www_wb = (WebView) findViewById(R.id.www_wb);
        path_et = (EditText) findViewById(R.id.path_et);
        webView_pb = (ProgressBar) findViewById(R.id.webView_pb);
//        //如果直接加载，在一些机型上会跳转到浏览器上，因此我们还要做一些特殊操作
//        webView.loadUrl("http://www.qq.com");

        //使用webview对象，初始化一些操作
        webViewInit();
        //webviewsettngs对象进行webView一些初始化的设置
        webViewSettingInit();
    }

    private void webViewSettingInit() {
        //加载某一个网址，跳转到浏览器加载，进行点击事件监听
        www_wb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        //ui改变时进行的各种监听
        www_wb.setWebChromeClient(new WebChromeClient(){
            //newProgress网页加载的进度，当是100时，加载成功
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //显示进度条
                webView_pb.setVisibility(View.VISIBLE);
                //对进度条设置进度条数
                webView_pb.setProgress(newProgress);
                if (newProgress == 100){
                    //进度条消失
                    webView_pb.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    private void webViewInit() {
        WebSettings settings = www_wb.getSettings();
        //使用webView的设置对象，使webView支持js
        settings.setJavaScriptEnabled(true);
        //是webView根据手机自动适配
        settings.setSupportZoom(true);
        //webView只加载文字不加载图片，为用户节省流量
        settings.setBlockNetworkImage(true);
    }
    public  void  load(View view){
       www_wb.loadUrl("http://www.qq.com");
    }
    public  void  advance(View view){

    }
    public  void  back(View view){

    }
    public  void  refresh(View view){

    }

}
