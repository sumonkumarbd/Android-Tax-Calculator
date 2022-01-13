package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Payments extends Main {

    androidx.constraintlayout.widget.ConstraintLayout mainCard_payments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payments);

        mainCard_payments = findViewById(R.id.mainCard_payments);

        mainCard_payments.setAnimation(up_from_bottom);

        WebView webViewer = findViewById(R.id.payments_webVIew);
        String url = "https://nbr.sblesheba.com/";
        webViewer.loadUrl(url);
    }
}