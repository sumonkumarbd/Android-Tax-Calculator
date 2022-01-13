package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class TaxZone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax_zone);
        WebView webView_return = findViewById(R.id.taxZone_webView);
        String taxZone_web = "https://nbr.gov.bd/useful-link/eng/";
        webView_return.loadUrl(String.valueOf(taxZone_web));
    }
}