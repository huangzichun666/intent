package com.example.intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Test extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);
        init();
    }

    public void init() {
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("https://www.baidu.com/");
    }
}
