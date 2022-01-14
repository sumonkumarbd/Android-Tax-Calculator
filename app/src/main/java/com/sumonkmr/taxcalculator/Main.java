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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import soup.neumorphism.NeumorphImageButton;

public class Main extends AppCompatActivity {


    Animation fade_in, zoom_in, left_to_right, right_to_left, right_to_left_slow, middle_to_top, bottom_from_up;
    Animation up_down_cont, up_from_bottom, up_from_bottom_slow, slide_in_left, slide_out_right, slide_out_left, slide_in_right,right_slidere_infinit;
    LinearLayout slabCalcButton, first_row, insButton, e_tin, sec_row, salary_tax, thirdRow, address_book, govt_site;
    androidx.constraintlayout.widget.ConstraintLayout  mainCard;
    Dialog dialog , dialog_about;
    TextView appName, text_morque;


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
        bottom_from_up = AnimationUtils.loadAnimation(Main.this,R.anim.bottom_from_up);
        up_from_bottom_slow = AnimationUtils.loadAnimation(Main.this,R.anim.up_from_bottom_slow);
        slide_in_left = AnimationUtils.loadAnimation(Main.this,R.anim.slide_in_left);
        slide_out_left = AnimationUtils.loadAnimation(Main.this,R.anim.slide_out_left);
        slide_in_right = AnimationUtils.loadAnimation(Main.this,R.anim.slide_in_right);
        slide_out_right = AnimationUtils.loadAnimation(Main.this,R.anim.slide_out_right);
        right_slidere_infinit = AnimationUtils.loadAnimation(Main.this,R.anim.right_slidere_infinit);
        right_slidere_infinit = AnimationUtils.loadAnimation(Main.this,R.anim.right_slidere_infinit);
        slabCalcButton = findViewById(R.id.slabCalcButton);
        text_morque = findViewById(R.id.text_morque);
        mainCard = findViewById(R.id.mainCard);
        first_row = findViewById(R.id.first_row);
        insButton = findViewById(R.id.insButton);
        e_tin = findViewById(R.id.e_tin);
        govt_site = findViewById(R.id.govt_site);
        sec_row = findViewById(R.id.sec_row);
        salary_tax = findViewById(R.id.salary_tax);
        thirdRow = findViewById(R.id.thirdRow);
        address_book = findViewById(R.id.address_book);
        appName = findViewById(R.id.appName);
        insButton = findViewById(R.id.insButton);

//        calling animations
        appName.setAnimation(zoom_in);
        mainCard.setAnimation(fade_in);
        first_row.setAnimation(bottom_from_up);
        salary_tax.setAnimation(slide_in_left);
        slabCalcButton.setAnimation(slide_in_right);
        thirdRow.setAnimation(up_from_bottom);


//        objs
        Handler handler = new Handler();


//        Actions
//        For Text Morque
        Runnable taxt = () ->text_morque.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morque.setSelected(true);
        handler.postDelayed(taxt,2000);



//        dialog_BOx
        //Create the Dialog her
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.slab_tax_dialog);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations =R.anim.slide_out_right; //Setting the animations to dialog



            //onClick Events
        salary_tax.setOnClickListener(view -> {
            Intent salary_tax = new Intent(Main.this,SalaryTax.class);
            startActivity(salary_tax);
        });

        insButton.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this,Pdf_viewer.class);
            startActivity(intent);
        });

        e_tin.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this, Payments.class);
            startActivity(intent);
        });

        address_book.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this,TaxZone.class);
            startActivity(intent);
        });

        govt_site.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this, AboutUs.class);
            startActivity(intent);
        });





        LinearLayout male = dialog.findViewById(R.id.male);
        LinearLayout female = dialog.findViewById(R.id.female);
        LinearLayout disable_parson = dialog.findViewById(R.id.disable_parson);
        LinearLayout freedom_fighter = dialog.findViewById(R.id.freedom_fighter);
        ImageView Cancel = dialog.findViewById(R.id.btn_cancel);


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