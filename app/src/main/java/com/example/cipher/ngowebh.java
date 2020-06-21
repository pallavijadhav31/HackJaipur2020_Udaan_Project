package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class ngowebh extends AppCompatActivity {
    WebView we;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngowebh);
        we=findViewById(R.id.we);
        we.getSettings().setLoadsImagesAutomatically(true);
        we.getSettings().setJavaScriptEnabled(true);
        we.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        we.loadUrl(getIntent().getStringExtra("key_url2h"));
    }
}
