package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);
        init();
    }

    public void init(){
        webView=(WebView)findViewById(R.id.webView);
        Intent intent=getIntent();
        String url = (String)intent.getStringExtra("data");
        Log.d("huang", "url" + url);
        webView.loadUrl(url);
    }
}
