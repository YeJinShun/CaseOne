package com.example.dell.caseone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wv = (WebView) findViewById(R.id.wv);
        Intent intent = getIntent();
        String intent1 = intent.getStringExtra("intent");
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(intent1);
    }
}
