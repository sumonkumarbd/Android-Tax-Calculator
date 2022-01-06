package com.sumonkmr.taxcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SalaryTax extends FreedomFighterTax {

    LinearLayout mainCard_salary;
    soup.neumorphism.NeumorphImageButton calcButton_salary, calcButton_salary_disabled;
    TextView title_salary, taxFreeResult, taxableResult,total_annul_display ;
    EditText basic_salary,bonus,past_salary,house_rent,medical_allowance,surgery_cost,travel_cost,festival_bonus,servant_allowance,holiday_allowance,honorary_gift,over_time;
    String  basic_salary_s,bonus_s,past_salary_s,house_rent_s,medical_allowance_s,surgery_cost_s,travel_cost_s,festival_bonus_s,servant_allowance_s,holiday_allowance_s,honorary_gift_s,over_time_s;
    double basic_salary_d,bonus_d,past_salary_d,house_rent_d,medical_allowance_d,surgery_cost_d,travel_cost_d,festival_bonus_d,servant_allowance_d,holiday_allowance_d,honorary_gift_d,over_time_d;
    double total_annual_display_d,taxFreeResult_d,taxableResult_d;
    String  total_annual_display_s,taxFreeResult_s,taxableResult_s;
    final String far = "%,.2f";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_tax);

        //        Object of Handler
        Handler handler = new Handler();

//        HOOKS
        mainCard_salary = findViewById(R.id.mainCard_salary);
        title_salary = findViewById(R.id.title_salary);
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
        taxFreeResult = findViewById(R.id.taxFreeResult);
        taxableResult = findViewById(R.id.taxableResult);
        total_annul_display = findViewById(R.id.total_annul_display);
        calcButton_salary = findViewById(R.id.calcButton_salary);
        calcButton_salary_disabled = findViewById(R.id.calcButton_salary_disabled);




        //        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);



//        Caling Animations

        title_salary.setAnimation(zoom_in);
        mainCard_salary.setAnimation(fade_in);


//        OnClickListeners
        calcButton_salary.setOnClickListener(view -> {
            total_salary_income_annual();
        });












    }//onCreate

//    Methods
//    total_salary_income_annual
    @SuppressLint("DefaultLocale")
    private void total_salary_income_annual(){

        //        convert to string
        basic_salary_s = basic_salary.getText().toString();
        bonus_s = bonus.getText().toString();
        past_salary_s = past_salary.getText().toString();
        house_rent_s = house_rent.getText().toString();
        medical_allowance_s = medical_allowance.getText().toString();
        surgery_cost_s = surgery_cost.getText().toString();
        travel_cost_s = travel_cost.getText().toString();
        festival_bonus_s = festival_bonus.getText().toString();
        servant_allowance_s = servant_allowance.getText().toString();
        holiday_allowance_s = holiday_allowance.getText().toString();
        honorary_gift_s = honorary_gift.getText().toString();
        over_time_s = over_time.getText().toString();
//        total_annual_display_s = String.format(far,total_annual_display_d);
//        taxFreeResult_s = String.format(far,taxFreeResult_d);
//        taxableResult_s = String.format(far,taxableResult_d);

//        convert to float
        basic_salary_d = Double.parseDouble(basic_salary_s);
        bonus_d = Double.parseDouble(bonus_s);
        past_salary_d = Double.parseDouble(past_salary_s);
        house_rent_d = Double.parseDouble(house_rent_s);
        medical_allowance_d = Double.parseDouble(medical_allowance_s);
        surgery_cost_d = Double.parseDouble(surgery_cost_s);
        travel_cost_d = Double.parseDouble(travel_cost_s);
        festival_bonus_d = Double.parseDouble(festival_bonus_s);
        servant_allowance_d = Double.parseDouble(servant_allowance_s);
        holiday_allowance_d = Double.parseDouble(holiday_allowance_s);
        honorary_gift_d = Double.parseDouble(honorary_gift_s);
        over_time_d = Double.parseDouble(over_time_s);

//        Operation
        total_annual_display_d = basic_salary_d + bonus_d + past_salary_d + house_rent_d + medical_allowance_d + surgery_cost_d + travel_cost_d + servant_allowance_d + holiday_allowance_d + honorary_gift_d + over_time_d;
        total_annual_display_s = String.format(far,total_annual_display_d);
        String ad=total_annual_display_s.concat(" টাকা");

        total_annul_display.setText(ad);
        voiceBrief(ad);




    }//total_salary_income_annual

    //    VoiceAsist
    public void voiceBrief(String voice){
        int taxResult = sp.speak(voice,TextToSpeech.QUEUE_ADD,null);
    };//voiceAsist


}// class SalaryTax