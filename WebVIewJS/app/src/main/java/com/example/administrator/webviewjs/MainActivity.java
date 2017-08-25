package com.example.administrator.webviewjs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * 1、布局
 * 2、网络权限
 * 3、控件初始化
 * 4、开启支持JS的操作
 */
public class MainActivity extends AppCompatActivity {
    private static final String HTML_URL = "http://huixinguiyu.cn/test.html";
    private WebView webView;
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.show_wb);
        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


        webView.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public  void  showToast(String contect){
                Toast.makeText(MainActivity.this,contect,Toast.LENGTH_SHORT).show();
            }
        },"Android");
    }

    //调用JS暴露的方法，格式固定：webView对象.loadurl（"javascript:js方法名（参数）"）；
    public  void  call(View view){
        webView.loadUrl("javascript:changeInputValue('哈哈哈，真大！')");
    }
    public  void  load(View view){
        webView.loadUrl(HTML_URL);
    }
}
