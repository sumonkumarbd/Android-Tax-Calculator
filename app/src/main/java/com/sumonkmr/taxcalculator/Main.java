package com.sumonkmr.taxcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {


    Animation fade_in, zoom_in, left_to_right, right_to_left, right_to_left_slow, middle_to_top;
    Animation up_down_cont, up_from_bottom, up_from_bottom_slow, slide_in_left, slide_out_right, slide_out_left, slide_in_right,right_slidere_infinit;
    Button mainButton;
    TextView text_morque;


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
        mainButton = findViewById(R.id.mainButton);
        text_morque = findViewById(R.id.text_morque);


//        objs
        Handler handler = new Handler();
        Runnable runnable = () -> mainButton.startAnimation(zoom_in);
        handler.postDelayed(runnable,3000);


//        Actions
//        For Text Morque
        Runnable taxt = () ->text_morque.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morque.setSelected(true);
        handler.postDelayed(taxt,2000);


        mainButton.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this, SlabCalculator.class);
            startActivity(intent);
        });



    }//onCreate Bundle


//    Methods



}//main Finised