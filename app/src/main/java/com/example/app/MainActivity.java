package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView mWebView;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        mWebView.setWebContentsDebuggingEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());

        // REMOTE RESOURCE
        // mWebView.loadUrl("https://control.pixysos.com");

        // LOCAL RESOURCE
        mWebView.loadUrl("file:///android_asset/index.html");
        //mWebView.loadDataWithBaseURL("file:///android_asset/", "index.html", "text/html", "utf-8", null);
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
