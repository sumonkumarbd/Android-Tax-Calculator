package com.sumonkmr.taxcalculator;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

public class SalaryTax extends FreedomFighterTax {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salary_tax);

        //        Object of Handler
        Handler handler = new Handler();

        //        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);











    }//onCreate
}// class SalaryTax