package com.sumonkmr.taxcalculator;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SalaryTax extends FreedomFighterTax {

    LinearLayout mainCard_salary;
    TextView appName_salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_tax);

        //        Object of Handler
        Handler handler = new Handler();

//        HOOKS
        mainCard_salary = findViewById(R.id.mainCard_salary);
        appName_salary = findViewById(R.id.appName_salary);


        //        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);



//        Caling Animations

        appName_salary.setAnimation(zoom_in);
        mainCard_salary.setAnimation(fade_in);










    }//onCreate
}// class SalaryTax