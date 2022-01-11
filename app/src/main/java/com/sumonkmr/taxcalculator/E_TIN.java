package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class E_TIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_tin);

        WebView webViewer = findViewById(R.id.webViewer);
        String url = "https://secure.incometax.gov.bd/TINHome";
        webViewer.loadUrl(url);
    }
}