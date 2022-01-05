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
    String  basic_salary_s,bonus_s,past_salary_s,house_rent_s,medical_allowance_s,surgery_cost_s,travel_cost_s,festival_bonus_s,servant_allowance_s,holiday_allowance_s,honorary_gift_s,over_time_s;
    double basic_salary_f,bonus_f,past_salary_f,house_rent_f,medical_allowance_f,surgery_cost_f,travel_cost_f,festival_bonus_f,servant_allowance_f,holiday_allowance_f,honorary_gift_f,over_time_f;

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

        //        convert to string
        basic_salary_s = String.valueOf(basic_salary);
        bonus_s = String.valueOf(bonus);
        past_salary_s = String.valueOf(past_salary);
        house_rent_s = String.valueOf(house_rent);
        medical_allowance_s = String.valueOf(medical_allowance);
        surgery_cost_s = String.valueOf(surgery_cost);
        travel_cost_s = String.valueOf(travel_cost);
        festival_bonus_s = String.valueOf(festival_bonus);
        servant_allowance_s = String.valueOf(servant_allowance);
        holiday_allowance_s = String.valueOf(holiday_allowance);
        honorary_gift_s = String.valueOf(honorary_gift);
        over_time_s = String.valueOf(over_time);

//        convert to float
        basic_salary_f = Double.parseDouble(basic_salary_s);
        bonus_f = Double.parseDouble(bonus_s);
        past_salary_f = Double.parseDouble(past_salary_s);
        house_rent_f = Double.parseDouble(house_rent_s);
        medical_allowance_f = Double.parseDouble(medical_allowance_s);
        surgery_cost_f = Double.parseDouble(surgery_cost_s);
        travel_cost_f = Double.parseDouble(travel_cost_s);
        festival_bonus_f = Double.parseDouble(festival_bonus_s);
        servant_allowance_f = Double.parseDouble(servant_allowance_s);
        holiday_allowance_f = Double.parseDouble(holiday_allowance_s);
        honorary_gift_f = Double.parseDouble(honorary_gift_s);
        over_time_f = Double.parseDouble(over_time_s);


        //        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);



//        Caling Animations

        appName_salary.setAnimation(zoom_in);
        mainCard_salary.setAnimation(fade_in);










    }//onCreate

//    Methods
//    total_salary_income_annual
    private void total_salary_income_annual(){


    }//total_salary_income_annual



}// class SalaryTax