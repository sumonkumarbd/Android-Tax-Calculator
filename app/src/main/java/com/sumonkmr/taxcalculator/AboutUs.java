package com.sumonkmr.taxcalculator;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

public class AboutUs extends TaxZone {

    LinearLayout mainCard_govt;
    ImageView image_holder;
    View topVIew,left_view,right_view, view_about;
    TextView about_t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        MobileAds.initialize(this, initializationStatus -> {
        });
        adView = findViewById(R.id.adView);
        adView.loadAd(adRequest);


        mainCard_govt = findViewById(R.id.mainCard_govt);
        image_holder = findViewById(R.id.image_holder);
        topVIew = findViewById(R.id.topVIew);
        left_view = findViewById(R.id.left_view);
        right_view = findViewById(R.id.right_view);
        view_about = findViewById(R.id.view_about);
        about_t = findViewById(R.id.about_t);


//        mainCard_govt.setAnimation(fade_in);
        image_holder.setAnimation(fade_in);
        topVIew.setAnimation(right_to_left);
        view_about.setAnimation(left_to_right);
        left_view.setAnimation(up_from_bottom);
        right_view.setAnimation(bottom_from_up);
        about_t.setAnimation(up_from_bottom);


        //        dialog_BOx
        //Create the Dialog her
        dialog_about = new Dialog(this);
        dialog_about.setContentView(R.layout.dialog_about_page);
        dialog_about.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog_about.setCancelable(false); //Optional
        dialog_about.getWindow().getAttributes().windowAnimations =R.anim.fade_in; //Setting the animations to dialog

        Button about_dialog_button = dialog_about.findViewById(R.id.about_dialog_button);
        ImageView dialog_cancel_about = dialog_about.findViewById(R.id.dialog_cancel_about);

        Handler handler = new Handler();
        Runnable runnable = () -> dialog_about.show();
        handler.postDelayed(runnable,5000);

        about_dialog_button.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/dev?id=6877143126125387449"));
            startActivity(intent);
        });

        dialog_cancel_about.setOnClickListener(view -> {
            dialog_about.dismiss();
        });

        mainCard_govt.setOnClickListener(view -> {
            handler.postDelayed(runnable,2000);
        });



    }

}