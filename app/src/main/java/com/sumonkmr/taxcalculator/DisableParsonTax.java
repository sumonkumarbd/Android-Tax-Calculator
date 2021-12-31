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


public class DisableParsonTax extends FemaleTax {


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






//        Objects
//        Object of Main
        Main main = new Main();
        //        Object of Handler
        Handler handler = new Handler();
        Runnable msg = () -> {
            Toast.makeText(DisableParsonTax.this, "আপনার কোনো প্রতিবন্ধি সন্তান থাকলে সিলেক্ট করুন!!", Toast.LENGTH_LONG).show();
        };

        handler.postDelayed(msg,2000);

//                Actions
//        CAll Functions & Methods
//        ============================
        calcButton.setEnabled(false);

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
                        ballance1 = 450000;
                        ballance2 = 550000;
                        ballance3 = 850000;
                        ballance4 = 1250000;
                        ballance5 = 1750000;
                        a1.setText("প্রথম সাড়ে ৪ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
                        break;
                    case 1:
                        //        values
                        ballance1 = 500000;
                        ballance2 = 600000;
                        ballance3 = 900000;
                        ballance4 = 1300000;
                        ballance5 = 1800000;
                        a1.setText("প্রথম ৫ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                        Toast.makeText(DisableParsonTax.this,"আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো।",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        //        values
                        ballance1 = 400000;
                        ballance2 = 500000;
                        ballance3 = 800000;
                        ballance4 = 1200000;
                        ballance5 = 1700000;
                        a1.setText("প্রথম ৫ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                        Toast.makeText(DisableParsonTax.this,"আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো। ",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        //        values
                        ballance1 = 400000;
                        ballance2 = 500000;
                        ballance3 = 800000;
                        ballance4 = 1200000;
                        ballance5 = 1700000;
                        a1.setText("প্রথম ৫ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                        Toast.makeText(DisableParsonTax.this," আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো।",Toast.LENGTH_LONG).show();
                        break;

                    default:
                        Toast.makeText(DisableParsonTax.this, "আপনার কোনো প্রতিবন্ধি সন্তান থাকলে সিলেক্ট করুন!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //        values
                ballance1 = 450000;
                ballance2 = 550000;
                ballance3 = 850000;
                ballance4 = 1250000;
                ballance5 = 1750000;
                a1.setText("প্রথম সাড়ে ৪ লক্ষ টাকা");
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




        Runnable r = () -> Toast.makeText(DisableParsonTax.this, "নিশ্চিত করুন এটি আপনার বার্ষিক আয়!!", Toast.LENGTH_LONG).show();


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




//      Litseners
        //OnClick Litsenr
        calcButton.setOnClickListener(view -> {
            String uservalue = inputVal.getText().toString();
            if (!uservalue.isEmpty()){
                // calculator
                calculator();
            }else {
                calcButton.setEnabled(false);
            };


        });// ClacButton Listener

        // ClacButton_disabled Listener
        calcButton_disabled.setOnClickListener(view -> {
            Toast.makeText(DisableParsonTax.this, "নির্ভুল তথ্য পেতে সঠিক সংখ্যা প্রদান করুন!!", Toast.LENGTH_SHORT).show();
        });// ClacButton_disabled Listener


    }//    View.OnCreateSaveInstance




    //                Methods
//        ====================
    @Override
    public void calculator(){
//                variables with Theory
//        ====================================
        String userInput = inputVal.getText().toString();
        double newUserInput = Double.parseDouble(userInput);
        String userValue = String.format("%,.2f",newUserInput);

        //Important Action for match this class with xml Layout





        String tk = " টাকা";
        String zero_tk = "0 টাকা ";
        double firstTaxamount =(newUserInput - ballance1);
        String ftaxAmount = String.format("%,.2f",firstTaxamount);
        double firstTax = firstTaxamount*5/100;
        String fstTax = String.format("%,.2f",firstTax);

        double secoundTaxableamount = (newUserInput - ballance2);
        String secTaxAmount = String.format("%,.2f",secoundTaxableamount);
        double  secondTax = secoundTaxableamount*10/100;
        String secTax = String.format("%,.2f",secondTax);


        double thirdTaxableamount = (double) (newUserInput - ballance3);
        String thirdTaxAmount = String.format("%,.2f",thirdTaxableamount);
        double thirdTax = thirdTaxableamount*15/100;
        String sThirdTax = String.format("%,.2f",thirdTax);


        double fourthTaxableamount =newUserInput - ballance4;
        String fourthTaxAmount = String.format("%,.2f",fourthTaxableamount);
        double fourthTax = fourthTaxableamount*20/100;
        String newfourthTax = String.format("%,.2f",fourthTax);

        double fifthTaxableamount = (double) (newUserInput - ballance5);
        String fifthTaxAmount = String.format("%,.2f",fifthTaxableamount);
        double fifthTax = fifthTaxableamount*25/100;
        String newfifthTax = String.format("%,.2f",fifthTax);


        //                ResultBar
        amountResult.setText(userValue + tk);


//                firstMathod
        if (newUserInput <= ballance1) {
            c1.setText(userValue + tk);
            d1.setText(zero_tk);
            c2.setText("");
            d2.setText("");
            taxResult.setText(zero_tk);
            //TextToSpeech
            voiceAsist("0");
        } else if (newUserInput > ballance1) {
            String newballance1 = String.format("%,.2f",ballance1);
            c1.setText(newballance1 + tk);
            d1.setText(zero_tk);
            //                TextToSpeech
            voiceAsist(zero_tk);
        }

        //            secondMathode
        if (newUserInput > ballance1 && newUserInput <= ballance2) {
            c2.setText(ftaxAmount + tk);
            d2.setText(fstTax + " টাকা");
            taxResult.setText(fstTax+tk);
            //                TextToSpeech
            voiceAsist(fstTax);
        } else if (newUserInput > ballance2) {
            double secoundMaxAmount = ballance2 - ballance1;
            double secoundMaxTax = (secoundMaxAmount * 5 / 100);
            String sMaxsecAmount = String.format("%,.2f",secoundMaxAmount);
            String sMaxsecTax = String.format("%,.2f",secoundMaxTax);
            c2.setText(sMaxsecAmount + tk);
            d2.setText(sMaxsecTax + tk);
            //                TextToSpeech
            voiceAsist(sMaxsecTax);
        }
        ;
//            secondMathode


//                THirdMathod
        if (newUserInput > ballance2 && newUserInput <= ballance3) {
            c3.setText(secTaxAmount + tk);
            d3.setText(secTax + tk);
            double sumSecTax =secondTax + 5000;
            String newSumSecTax = String.format("%,.2f",sumSecTax);
            taxResult.setText(newSumSecTax+tk);
            //                TextToSpeech
            voiceAsist(newSumSecTax);
        } else if (newUserInput > ballance3) {
            double ThirdMaxAmount = ballance3 - ballance2;
            double thirdMaxTax = (ThirdMaxAmount * 10 / 100);
            String sThirdMaxAmount = String.format("%,.2f",ThirdMaxAmount);
            String sthirdMaxTax = String.format("%,.2f",thirdMaxTax);
            c3.setText(sThirdMaxAmount + tk);
            d3.setText(sthirdMaxTax + tk);
            //                TextToSpeech
            voiceAsist(sthirdMaxTax);
        } else if (newUserInput <= ballance2) {
            c3.setText("");
            d3.setText("");
        }
        ;
//                THirdMathod

//                fouthMathod
        if (newUserInput > ballance3 && newUserInput <= ballance4) {
            c4.setText(thirdTaxAmount + tk);
            d4.setText(sThirdTax + tk);
            double sumThirdTax = thirdTax + 35000;
            String newSumThirdTax = String.format("%,.2f",sumThirdTax);
            taxResult.setText(newSumThirdTax+tk);
            //                TextToSpeech
            voiceAsist(newSumThirdTax);
        } else if (newUserInput > ballance4) {
            double fourthMaxAmount = ballance4 - ballance3;
            double fourthMaxTax = (fourthMaxAmount * 15 / 100);
            String sfourthMaxAmount = String.format("%,.2f",fourthMaxAmount);
            String sfourthMaxTax = String.format("%,.2f",fourthMaxTax);
            c4.setText(sfourthMaxAmount + tk);
            d4.setText(sfourthMaxTax + tk);
            //                TextToSpeech
            voiceAsist(sfourthMaxTax);
        } else if (newUserInput <= ballance3) {
            c4.setText("");
            d4.setText("");
        }
        ;
//                fouthMathod

//                FifthMathod
        if (newUserInput > ballance4 && newUserInput <= ballance5) {
            c5.setText(fourthTaxAmount + tk);
            d5.setText(newfourthTax + tk);
            double sumfourthTax = fourthTax + 95000;
            String newFourthTax = String.format("%,.2f",sumfourthTax);
            taxResult.setText(newFourthTax+tk);
            //                TextToSpeech
            voiceAsist(newFourthTax);
        } else if (newUserInput > ballance5) {
            double fifthMaxAmount = ballance5 - ballance4;
            double fifthMaxTax = (fifthMaxAmount * 20) / 100;
            String sfifthMaxAmount = String.format("%,.2f",fifthMaxAmount);
            String sfifthMaxTax = String.format("%,.2f",fifthMaxTax);
            c5.setText(sfifthMaxAmount + tk);
            d5.setText(sfifthMaxTax + tk);
            //                TextToSpeech
            voiceAsist(sfifthMaxTax);
        } else if (newUserInput <= ballance4) {
            c5.setText("");
            d5.setText("");
        }
        ;
//                FifthMathod

//                SixthMethod
        if (newUserInput > ballance5) {
            c6.setText(fifthTaxAmount + tk);
            d6.setText(newfifthTax + tk);
            double sumFifthTax = fifthTax + 195000;
            String newSumFifthTax = String.format("%,.2f",sumFifthTax);
            taxResult.setText(newSumFifthTax+tk);
            //                TextToSpeech
            voiceAsist(newSumFifthTax);
        } else if (newUserInput <= ballance5) {
            c6.setText("");
            d6.setText("");
        }
        ;
//                SixthMethod

//                if incase given amount is more than 999999999 digit then it will work for better user expreance
        if (newUserInput > 99999999) {
            amountResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
            taxResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
            c6.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
            d6.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
        }else {
            amountResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            taxResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
            c6.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
            d6.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
        };




        inputVal.setText("");
        calcButton.setEnabled(false);

    };//calculator finished

}//MainActivities
