package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.MobileAds;

import java.io.File;

public class Pdf_viewer extends SalaryTax {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer);

        MobileAds.initialize(this, initializationStatus -> {
        });
        adView = findViewById(R.id.adView);
        adView.loadAd(adRequest);


        PDFView pdfView = findViewById(R.id.pdf_viewer);
        pdfView.fromAsset("nirdeshika_2021_2022.pdf").load();

    }
}