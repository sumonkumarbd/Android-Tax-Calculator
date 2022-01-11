package com.sumonkmr.taxcalculator;

import android.os.Bundle;
import android.webkit.WebView;

public class Govt_Website extends E_TIN {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.govt_website);
        WebView webView_return = findViewById(R.id.govt_site);
        String govt_site_url = "https://nbr.portal.gov.bd/";
        webView_return.loadUrl(govt_site_url);


    }
}