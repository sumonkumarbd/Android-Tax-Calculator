package com.sumonkmr.taxcalculator;


import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class FemaleTax extends SlabCalculator {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slab_calculator);






//       Hooks
        a1 = findViewById(R.id.a1);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d5 = findViewById(R.id.d5);
        d6 = findViewById(R.id.d6);
        taxResult = findViewById(R.id.taxResult);
        amountResult = findViewById(R.id.amountResult);
        inputVal = findViewById(R.id.inputVal);
        calcButton = findViewById(R.id.calcButton);
        calcButton_disabled = findViewById(R.id.calcButton_disabled);
        appName = findViewById(R.id.appName);
        season = findViewById(R.id.season);
        inputError = findViewById(R.id.inputError);
        text_morq = findViewById(R.id.text_morq);
        header_titles = findViewById(R.id.header_titles);
        resulBar = findViewById(R.id.resulBar);
        dataTable_header = findViewById(R.id.dataTable_header);
        bottomArea = findViewById(R.id.bottomArea);
        input_area = findViewById(R.id.input_area);
        header_title1 = findViewById(R.id.header_title1);
        header_title2 = findViewById(R.id.header_title2);
        header_title3 = findViewById(R.id.header_title3);
        header_title4 = findViewById(R.id.header_title4);
        totalAmount = findViewById(R.id.totalAmount);
        totalTax = findViewById(R.id.totalTax);


        super.a1.setText("প্রথম সাড়ে ৩ লক্ষ টাকা");
        super.a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);



//        Objects
//        Object of Main
        Main main = new Main();
        //        Object of Handler
        Handler handler = new Handler();
        Runnable msg = () -> {
            Toast.makeText(FemaleTax.this, "আপনার কোনো প্রতিবন্ধি সন্তান থাকলে সিলেক্ট করুন!!", Toast.LENGTH_LONG).show();
        };

        handler.postDelayed(msg,2000);

//                Actions
//        CAll Functions & Methods
//        ============================

        //        Dropdown
        //get the spinner from the xml.
        spinner = (Spinner)findViewById(R.id.spinner);
        //create a list of items for the spinner.
        items = new String[]{"নেই", "১ টি", "২ টি", "২ এর অধিক"};

//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, items);
//set the spinners adapter to the previously created one.
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //        values
                        ballance1 = 350000;
                        ballance2 = 450000;
                        ballance3 = 750000;
                        ballance4 = 1150000;
                        ballance5 = 1650000;
                        a1.setText("প্রথম সাড়ে ৩ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
                        break;
                    case 1:
                        //        values
                        ballance1 = 400000;
                        ballance2 = 500000;
                        ballance3 = 800000;
                        ballance4 = 1200000;
                        ballance5 = 1700000;
                        a1.setText("প্রথম ৪ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                        Toast.makeText(FemaleTax.this,"আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো।",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        //        values
                        ballance1 = 400000;
                        ballance2 = 500000;
                        ballance3 = 800000;
                        ballance4 = 1200000;
                        ballance5 = 1700000;
                        a1.setText("প্রথম ৪ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                        Toast.makeText(FemaleTax.this,"আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো। ",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        //        values
                        ballance1 = 400000;
                        ballance2 = 500000;
                        ballance3 = 800000;
                        ballance4 = 1200000;
                        ballance5 = 1700000;
                        a1.setText("প্রথম ৪ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                        Toast.makeText(FemaleTax.this," আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো।",Toast.LENGTH_LONG).show();
                        break;

                    default:
                        Toast.makeText(FemaleTax.this, "আপনার কোনো প্রতিবন্ধি সন্তান থাকলে সিলেক্ট করুন!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //        values
                ballance1 = 350000;
                ballance2 = 450000;
                ballance3 = 750000;
                ballance4 = 1150000;
                ballance5 = 1650000;
                a1.setText("প্রথম সাড়ে ৩ লক্ষ টাকা");
                a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);

            }
        });
//        Dropdown

//        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);


//        textToVoice
        textToVoice();

//        taxtWatcher
        inputVal.addTextChangedListener(textWatcher);




        Runnable r = () -> Toast.makeText(FemaleTax.this, "নিশ্চিত করুন এটি আপনার বার্ষিক আয়!!", Toast.LENGTH_LONG).show();


//        animations calling
        appName.startAnimation(zoom_in);
        season.startAnimation(zoom_in);
        header_titles.startAnimation(right_to_left);
        resulBar.startAnimation(left_to_right);
        dataTable_header.startAnimation(fade_in);
        input_area.startAnimation(right_to_left_slow);
        bottomArea.startAnimation(up_from_bottom_slow);
        header_title1.startAnimation(fade_in);
        header_title2.startAnimation(fade_in);
        header_title3.startAnimation(fade_in);
        header_title4.startAnimation(fade_in);
        totalAmount.startAnimation(fade_in);
        totalTax.startAnimation(fade_in);




//OnClick Litsenr
        calcButton.setOnClickListener(view -> {
            String uservalue = inputVal.getText().toString();
            if (uservalue.length() == 0){
                calcButton.setEnabled(false);
                calcButton_disabled.setVisibility(View.VISIBLE);
                inputError.setVisibility(View.VISIBLE);
                Toast.makeText(FemaleTax.this,"আপনার ট্যাক্সযোগ্য আয় ইনপুট দিন!",Toast.LENGTH_SHORT).show();
            }else {
                // calculator
                calculator();
            };


        });// ClacButton Listener

        // ClacButton_disabled Listener
        calcButton_disabled.setOnClickListener(view -> {
            Toast.makeText(FemaleTax.this, "নির্ভুল তথ্য পেতে সঠিক সংখ্যা প্রদান করুন!!", Toast.LENGTH_SHORT).show();
        });// ClacButton_disabled Listener


    }//    View.OnCreateSaveInstance
    //                Methods
//        ====================

}//MainActivities
