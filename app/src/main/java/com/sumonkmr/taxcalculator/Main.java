package com.sumonkmr.taxcalculator;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import soup.neumorphism.NeumorphImageButton;

public class Main extends AppCompatActivity {


    Animation fade_in, zoom_in, left_to_right, right_to_left, right_to_left_slow, middle_to_top;
    Animation up_down_cont, up_from_bottom, up_from_bottom_slow, slide_in_left, slide_out_right, slide_out_left, slide_in_right,right_slidere_infinit;
    Button slabCalcButton;
    Dialog dialog;
    TextView text_morque;


    @SuppressLint({"UseCompatLoadingForDrawables", "ObsoleteSdkInt"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //        Animations
        fade_in = AnimationUtils.loadAnimation(Main.this,R.anim.fade_in);
        zoom_in = AnimationUtils.loadAnimation(Main.this,R.anim.zoom_in);
        left_to_right = AnimationUtils.loadAnimation(Main.this,R.anim.left_to_right);
        right_to_left = AnimationUtils.loadAnimation(Main.this,R.anim.right_to_left);
        right_to_left_slow = AnimationUtils.loadAnimation(Main.this,R.anim.right_to_left_slow);
        middle_to_top = AnimationUtils.loadAnimation(Main.this,R.anim.middle_to_top);
        up_down_cont = AnimationUtils.loadAnimation(Main.this,R.anim.up_down_cont);
        up_from_bottom = AnimationUtils.loadAnimation(Main.this,R.anim.up_from_bottom);
        up_from_bottom_slow = AnimationUtils.loadAnimation(Main.this,R.anim.up_from_bottom_slow);
        slide_in_left = AnimationUtils.loadAnimation(Main.this,R.anim.slide_in_left);
        slide_out_left = AnimationUtils.loadAnimation(Main.this,R.anim.slide_out_left);
        slide_in_right = AnimationUtils.loadAnimation(Main.this,R.anim.slide_in_right);
        slide_out_right = AnimationUtils.loadAnimation(Main.this,R.anim.slide_out_right);
        right_slidere_infinit = AnimationUtils.loadAnimation(Main.this,R.anim.right_slidere_infinit);
        slabCalcButton = findViewById(R.id.slabCalcButton);
        text_morque = findViewById(R.id.text_morque);


//        objs
        Handler handler = new Handler();
        Runnable runnable = () -> slabCalcButton.startAnimation(fade_in);
        handler.postDelayed(runnable,1000);


//        Actions
//        For Text Morque
        Runnable taxt = () ->text_morque.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morque.setSelected(true);
        handler.postDelayed(taxt,2000);



//        dialog_BOx
        //Create the Dialog her
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.coustom_dialogbox);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations =R.anim.slide_out_right; //Setting the animations to dialog









        Button male = dialog.findViewById(R.id.male);
        Button female = dialog.findViewById(R.id.female);
        Button disable_parson = dialog.findViewById(R.id.disable_parson);
        Button freedom_fighter = dialog.findViewById(R.id.freedom_fighter);
        NeumorphImageButton Cancel = dialog.findViewById(R.id.btn_cancel);


        male.setOnClickListener(v -> {

            Intent intent = new Intent(Main.this,SlabCalculator.class);
            startActivity(intent);
            dialog.dismiss();
        });



        female.setOnClickListener(v -> {

            Intent intent = new Intent(Main.this,FemaleTax.class);
            startActivity(intent);
            dialog.dismiss();
        });

        female.setOnClickListener(v -> {

            Intent intent = new Intent(Main.this,FemaleTax.class);
            startActivity(intent);
            dialog.dismiss();
        });

        disable_parson.setOnClickListener(v -> {

            Intent intent = new Intent(Main.this,DisableParsonTax.class);
            startActivity(intent);
            dialog.dismiss();
        });

        freedom_fighter.setOnClickListener(v -> {

            Intent intent = new Intent(Main.this,FreedomFighterTax.class);
            startActivity(intent);
            dialog.dismiss();
        });










        Cancel.setOnClickListener(v -> {

            Toast.makeText(Main.this, "বাতিল হয়েছে!!", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });


        slabCalcButton.setOnClickListener(v -> {

            dialog.show(); // Showing the dialog here
        });










    }//onCreate Bundle


//    Methods



}//main Finised