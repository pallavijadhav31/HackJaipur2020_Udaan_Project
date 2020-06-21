package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class ngoweb extends AppCompatActivity {
    WebView ngoweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoweb);
        ngoweb=findViewById(R.id.ngoweb);

        ngoweb.getSettings().setLoadsImagesAutomatically(true);
        ngoweb.getSettings().setJavaScriptEnabled(true);
        ngoweb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        ngoweb.loadUrl(getIntent().getStringExtra("key_url2"));
    }
}
