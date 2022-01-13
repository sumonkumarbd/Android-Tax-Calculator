package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class TaxZone extends Main {
    androidx.constraintlayout.widget.ConstraintLayout mainCard_taxzone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax_zone);

        mainCard_taxzone = findViewById(R.id.mainCard_taxzone);

        mainCard_taxzone.setAnimation(up_from_bottom);




        WebView webView_return = findViewById(R.id.taxZone_webView);
        String taxZone_web = "https://nbr.gov.bd/useful-link/eng/";
        webView_return.loadUrl(String.valueOf(taxZone_web));
    }
}