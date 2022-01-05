package com.sumonkmr.taxcalculator;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SalaryTax extends FreedomFighterTax {

    LinearLayout mainCard_salary;
    TextView appName_salary;
    EditText basic_salary,bonus,past_salary,house_rent,medical_allowance,surgery_cost,travel_cost,festival_bonus,servant_allowance,holiday_allowance,honorary_gift,over_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_tax);

        //        Object of Handler
        Handler handler = new Handler();

//        HOOKS
        mainCard_salary = findViewById(R.id.mainCard_salary);
        appName_salary = findViewById(R.id.appName_salary);
        basic_salary = findViewById(R.id.basic_salary);
        bonus = findViewById(R.id.bonus);
        past_salary = findViewById(R.id.past_salary);
        house_rent = findViewById(R.id.house_rent);
        medical_allowance = findViewById(R.id.medical_allowance);
        surgery_cost = findViewById(R.id.surgery_cost);
        travel_cost = findViewById(R.id.travel_cost);
        festival_bonus = findViewById(R.id.festival_bonus);
        servant_allowance = findViewById(R.id.servant_allowance);
        holiday_allowance = findViewById(R.id.holiday_allowance);
        honorary_gift = findViewById(R.id.honorary_gift);
        over_time = findViewById(R.id.over_time);


        //        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);



//        Caling Animations

        appName_salary.setAnimation(zoom_in);
        mainCard_salary.setAnimation(fade_in);










    }//onCreate
}// class SalaryTax