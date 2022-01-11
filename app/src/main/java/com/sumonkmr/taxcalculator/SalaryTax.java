package com.sumonkmr.taxcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SalaryTax extends FreedomFighterTax {

    LinearLayout mainCard_salary;
    soup.neumorphism.NeumorphImageButton calcButton_salary, calcButton_salary_disabled;
    TextView title_salary, taxFreeResult, taxableResult,total_annul_display ;
    EditText basic_salary,bonus,past_salary,house_rent,medical_allowance,surgery_cost,travel_cost,festival_bonus,servant_allowance,holiday_allowance,honorary_gift,over_time;
    String  basic_salary_s,bonus_s,past_salary_s,house_rent_s,medical_allowance_s,surgery_cost_s,travel_cost_s,festival_bonus_s,servant_allowance_s,holiday_allowance_s,honorary_gift_s,over_time_s;
    String  basic_salary_as,bonus_as,past_salary_as,house_rent_as,medical_allowance_as,surgery_cost_as,travel_cost_as,festival_bonus_as,servant_allowance_as,holiday_allowance_as,honorary_gift_as,over_time_as;
    Double basic_salary_d,bonus_d,past_salary_d,house_rent_d,medical_allowance_d,surgery_cost_d,travel_cost_d,festival_bonus_d,servant_allowance_d,holiday_allowance_d,honorary_gift_d,over_time_d;
    double total_annual_display_d,taxFreeResult_d,taxableResult_d,fTowSum,fFourSum,fSixSum,fEightSum,fTenSum;
    String  total_annual_display_s,taxFreeResult_s,taxableResult_s;
    final String far = "%,.2f";
    int zero = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_tax);

        //        Object of Handler
        Handler handler = new Handler();

//        HOOKS
        mainCard_salary =(LinearLayout) findViewById(R.id.mainCard_salary);
        title_salary = findViewById(R.id.title_salary);
        basic_salary =(EditText) findViewById(R.id.basic_salary);
        bonus = (EditText)findViewById(R.id.bonus);
        past_salary =(EditText) findViewById(R.id.past_salary);
        house_rent =(EditText) findViewById(R.id.house_rent);
        medical_allowance =(EditText) findViewById(R.id.medical_allowance);
        surgery_cost =(EditText) findViewById(R.id.surgery_cost);
        travel_cost =(EditText) findViewById(R.id.travel_cost);
        festival_bonus =(EditText)findViewById(R.id.festival_bonus);
        servant_allowance =(EditText) findViewById(R.id.servant_allowance);
        holiday_allowance =(EditText) findViewById(R.id.holiday_allowance);
        honorary_gift = (EditText)findViewById(R.id.honorary_gift);
        over_time = (EditText)findViewById(R.id.over_time);
        taxFreeResult =(TextView) findViewById(R.id.taxFreeResult);
        taxableResult = (TextView)findViewById(R.id.taxableResult);
        total_annul_display =(TextView) findViewById(R.id.total_annul_display);
        calcButton_salary = findViewById(R.id.calcButton_salary);
        calcButton_salary_disabled = findViewById(R.id.calcButton_salary_disabled);






//        total_annual_display_s = String.format(far,total_annual_display_d);
//        taxFreeResult_s = String.format(far,taxFreeResult_d);
//        taxableResult_s = String.format(far,taxableResult_d);
//        basic_salary_s.length()<=0 || bonus_s.length()<=0 || past_salary_s.length()<=0 || house_rent_s.length()<=0 || medical_allowance_s.length()<=0 || surgery_cost_s.length()<=0 || travel_cost_s.length()<=0 || festival_bonus_s.length()<=0 || servant_allowance_s.length()<=0 || holiday_allowance_s.length()<=0 || honorary_gift_s.length() <=0 || over_time_s.length()<=0










        //        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);




        //        TextWatcher
        basic_salary.addTextChangedListener(textWatcher_ST);



//        Caling Animations

        title_salary.setAnimation(zoom_in);
        mainCard_salary.setAnimation(fade_in);


//        OnClickListeners

        calcButton_salary.setOnClickListener(view -> {
            if (!(basic_salary.getText().toString().length() == zero)){
                totalSalaryAmount();
            }else {
                Toast.makeText(SalaryTax.this, "Please Input A value", Toast.LENGTH_SHORT).show();
            }


        });













    }//onCreate

//    Methods

    //    VoiceAsist
    public void voiceBrief(String voice){
        int taxResult = sp.speak(voice,TextToSpeech.QUEUE_ADD,null);
    };//voiceAsist


//    TextWactcher
    TextWatcher textWatcher_ST = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



        //        for empty reqartions
//        if (basic_salary_s.length()<=0 || bonus_s.length()<=0 || past_salary_s.length()<=0 || house_rent_s.length()<=0 || medical_allowance_s.length()<=0 || surgery_cost_s.length()<=0 || travel_cost_s.length()<=0 || festival_bonus_s.length()<=0 || servant_allowance_s.length()<=0 || holiday_allowance_s.length()<=0 || honorary_gift_s.length() <=0 || over_time_s.length()<=0)
//        {
//            totalSalaryAmount();
//
//        }else {
//            Toast.makeText(SalaryTax.this, "Please fill all fields!!", Toast.LENGTH_SHORT).show();
//        }//        for empty reparations

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }//    TextWactcher
};


//    operation Method

    private void totalSalaryAmount(){

//                Convert to string && Double all variables
        basic_salary_s = (String) basic_salary.getText().toString();
        basic_salary_d =(Double) Double.parseDouble(basic_salary_s);

        bonus_s =(String) bonus.getText().toString();
        bonus_d = (Double)Double.parseDouble(bonus_s);
//
//        past_salary_s =(String) past_salary.getText().toString();
//        past_salary_d =(Double) Double.parseDouble(past_salary_s);
//
//        house_rent_s =(String) house_rent.getText().toString();
//        house_rent_d =(Double) Double.parseDouble(house_rent_s);
//
//        medical_allowance_s =(String) medical_allowance.getText().toString();
//        medical_allowance_d = (Double)Double.parseDouble(medical_allowance_s);
//
//        surgery_cost_s =(String) surgery_cost.getText().toString();
//        surgery_cost_d =(Double) Double.parseDouble(surgery_cost_s);
//
//        travel_cost_s =(String) travel_cost.getText().toString();
//        travel_cost_d =(Double) Double.parseDouble(travel_cost_s);
//
//        festival_bonus_s =(String) festival_bonus.getText().toString();
//        festival_bonus_d =(Double) Double.parseDouble(festival_bonus_s);
//
//        servant_allowance_s =(String) servant_allowance.getText().toString();
//        servant_allowance_d =(Double) Double.parseDouble(servant_allowance_s);
//
//        holiday_allowance_s =(String) holiday_allowance.getText().toString();
//        holiday_allowance_d =(Double) Double.parseDouble(holiday_allowance_s);
//
//        honorary_gift_s = (String)honorary_gift.getText().toString();
//        honorary_gift_d =(Double) Double.parseDouble(honorary_gift_s);
//
//        over_time_s = (String)over_time.getText().toString();
//        over_time_d = (Double)Double.parseDouble(over_time_s);








//        Operation
//        Logic#1

        

    }//salaryAmount Method

}// class SalaryTax