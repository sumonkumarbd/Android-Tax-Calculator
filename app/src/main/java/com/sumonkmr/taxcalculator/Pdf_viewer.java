package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.MobileAds;

import java.io.File;

public class Pdf_viewer extends SalaryTax {

    androidx.constraintlayout.widget.ConstraintLayout mainCard_pdf;
    TextView ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer);

        MobileAds.initialize(this, initializationStatus -> {
        });
        adView = findViewById(R.id.adView);
        adView.loadAd(adRequest);



         mainCard_pdf = findViewById(R.id.mainCard_pdf);
         ins = findViewById(R.id.ins);
        PDFView pdfView = findViewById(R.id.pdf_viewer);
        pdfView.fromAsset("nirdeshika_2021_2022.pdf").load();

        mainCard_pdf.setAnimation(fade_in);
        ins.setAnimation(zoom_in);

    }
}