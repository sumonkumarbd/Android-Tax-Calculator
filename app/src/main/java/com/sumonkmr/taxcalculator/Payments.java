package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Payments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payments);

        WebView webViewer = findViewById(R.id.e_tin_webVIew);
        String url = "https://nbr.sblesheba.com/";
        webViewer.loadUrl(url);
    }
}