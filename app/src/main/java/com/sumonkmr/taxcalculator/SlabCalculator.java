package com.sumonkmr.taxcalculator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;

import java.util.Locale;


public class SlabCalculator extends Main {

    //       varriables
    TextView a1 ,c1, c2, c3, c4, c5, c6, d1, d2, d3, d4, d5, d6;
    TextView totalAmount, totalTax, amountResult, taxResult, appName, text_morq;
    TextView season, header_title1, header_title2, header_title3, header_title4;
    LinearLayout dataTable_header ,resulBar, bottomArea, input_area;
    androidx.constraintlayout.widget.ConstraintLayout header_titles;
    EditText inputVal;
    ImageButton calcButton, calcButton_disabled;
    ImageView inputError;
    double ballance1, ballance2, ballance3, ballance4, ballance5, sumTax;
    String beforeText, afterText;
    double middleText;
    TextToSpeech sp;
    Spinner spinner;
    String[] items;
    String far = "%,.2f";
    String tk = " টাকা";
    String zero_tk = "0 টাকা ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slab_calculator);

        MobileAds.initialize(this, initializationStatus -> {
        });
        adView = findViewById(R.id.adView);
        adView.loadAd(adRequest);


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
                        ballance1 = 300000;
                        ballance2 = 400000;
                        ballance3 = 700000;
                        ballance4 = 1100000;
                        ballance5 = 1600000;
                        a1.setText("প্রথম ৩ লক্ষ টাকা টাকা");
                        break;
                    case 1:
                        //        values
                        ballance1 = 350000;
                        ballance2 = 450000;
                        ballance3 = 750000;
                        ballance4 = 1150000;
                        ballance5 = 1650000;
                        a1.setText("প্রথম সাড়ে ৩ লক্ষ টাকা");
                        Toast.makeText(SlabCalculator.this,"আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো।",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        //        values
                        ballance1 = 350000;
                        ballance2 = 450000;
                        ballance3 = 750000;
                        ballance4 = 1150000;
                        ballance5 = 1650000;
                        a1.setText("প্রথম সাড়ে ৩ লক্ষ টাকা");
                        Toast.makeText(SlabCalculator.this,"আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো। ",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        //        values
                        ballance1 = 350000;
                        ballance2 = 450000;
                        ballance3 = 750000;
                        ballance4 = 1150000;
                        ballance5 = 1650000;
                        a1.setText("প্রথম সাড়ে ৩ লক্ষ টাকা");
                        a1.setTextSize(TypedValue.COMPLEX_UNIT_SP,8);
                        Toast.makeText(SlabCalculator.this," আপনার নির্ধারিত ট্যাক্সমুক্ত ইনকামে আরো অতিরিক্ত ৫০ হাজার টাকা যোগ হলো।",Toast.LENGTH_LONG).show();
                        break;

                    default:
                        Toast.makeText(SlabCalculator.this, "আপনার কোনো প্রতিবন্ধি সন্তান থাকলে সিলেক্ট করুন!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                //        values
                ballance1 = 300000;
                ballance2 = 400000;
                ballance3 = 700000;
                ballance4 = 1100000;
                ballance5 = 1600000;

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


        Runnable r = () -> Toast.makeText(SlabCalculator.this, "নিশ্চিত করুন এটি আপনার বার্ষিক আয়!!", Toast.LENGTH_LONG).show();


//        animations calling
        appName.startAnimation(zoom_in);
        season.startAnimation(zoom_in);
        header_titles.startAnimation(right_to_left);
        resulBar.startAnimation(left_to_right);
//        dataTable_header.startAnimation(fade_in);
        input_area.startAnimation(right_to_left_slow);
        bottomArea.startAnimation(up_from_bottom_slow);
        header_title1.startAnimation(fade_in);
        header_title2.startAnimation(fade_in);
        header_title3.startAnimation(fade_in);
        header_title4.startAnimation(fade_in);
        totalAmount.startAnimation(fade_in);
        totalTax.startAnimation(fade_in);




        //Litseners

        //OnClick Litsenr
        calcButton.setOnClickListener(view -> {
            String uservalue = inputVal.getText().toString();
            if (uservalue.length() == 0){
                calcButton.setEnabled(false);
                calcButton_disabled.setVisibility(View.VISIBLE);
                inputError.setVisibility(View.VISIBLE);
                Toast.makeText(SlabCalculator.this,"আপনার ট্যাক্সযোগ্য আয় ইনপুট দিন!",Toast.LENGTH_SHORT).show();
            }else {
                // calculator
                calculator();
            };


        });// ClacButton Listener

        // ClacButton_disabled Listener
        calcButton_disabled.setOnClickListener(view -> {
            Toast.makeText(SlabCalculator.this, "নির্ভুল তথ্য পেতে সঠিক সংখ্যা প্রদান করুন!!", Toast.LENGTH_SHORT).show();
        });// ClacButton_disabled Listener



    }//    View.OnCreateSaveInstance




//                Methods
//        ====================
    public void calculator(){
//                variables with Theory
//        ====================================
        String userInput = inputVal.getText().toString();
        double newUserInput = Double.parseDouble(userInput);
        @SuppressLint("DefaultLocale") String userValue = String.format(far,newUserInput);


        double firstTaxamount =(newUserInput - ballance1);
        String ftaxAmount = String.format(far,firstTaxamount);
        double firstTax = firstTaxamount*5/100;
        String fstTax = String.format(far,firstTax).concat(tk);

        double secoundTaxableamount = (newUserInput - ballance2);
        String secTaxAmount = String.format(far,secoundTaxableamount);
        double  secondTax = secoundTaxableamount*10/100;
        String secTax = String.format(far,secondTax);


        double thirdTaxableamount = (double) (newUserInput - ballance3);
        String thirdTaxAmount = String.format(far,thirdTaxableamount);
        double thirdTax = thirdTaxableamount*15/100;
        String sThirdTax = String.format(far,thirdTax);


        double fourthTaxableamount =newUserInput - ballance4;
        String fourthTaxAmount = String.format(far,fourthTaxableamount);
        double fourthTax = fourthTaxableamount*20/100;
        String newfourthTax = String.format(far,fourthTax);

        double fifthTaxableamount = (double) (newUserInput - ballance5);
        String fifthTaxAmount = String.format(far,fifthTaxableamount);
        double fifthTax = fifthTaxableamount*25/100;
        String newfifthTax = String.format(far,fifthTax);


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
            voiceAsst(zero_tk);
        } else if (newUserInput > ballance1) {
            String newballance1 = String.format(far,ballance1).concat(tk);
            c1.setText(newballance1);
            d1.setText(zero_tk);
            //                TextToSpeech
            voiceAsst(zero_tk+tk);
        }

        //            secondMathode
        if (newUserInput > ballance1 && newUserInput <= ballance2) {
            c2.setText(ftaxAmount + tk);
            d2.setText(fstTax + tk);
            taxResult.setText(fstTax);
            //                TextToSpeech
            voiceAsst(fstTax);
        } else if (newUserInput > ballance2) {
            double secoundMaxAmount = ballance2 - ballance1;
            double secoundMaxTax = (secoundMaxAmount * 5 / 100);
            String sMaxsecAmount = String.format(far,secoundMaxAmount).concat(tk);
            String sMaxsecTax = String.format(far,secoundMaxTax).concat(tk);
            c2.setText(sMaxsecAmount);
            d2.setText(sMaxsecTax);
            //                TextToSpeech
            voiceAsst(sMaxsecTax);
        }
        ;
//            secondMathode


//                THirdMathod
        if (newUserInput > ballance2 && newUserInput <= ballance3) {
            c3.setText(secTaxAmount + tk);
            d3.setText(secTax + tk);
            double sumSecTax =secondTax + 5000;
            String newSumSecTax = String.format(far,sumSecTax).concat(tk);
            taxResult.setText(newSumSecTax);
            //                TextToSpeech
            voiceAsst(newSumSecTax);
        } else if (newUserInput > ballance3) {
            double ThirdMaxAmount = ballance3 - ballance2;
            double thirdMaxTax = (ThirdMaxAmount * 10 / 100);
            String sThirdMaxAmount = String.format(far,ThirdMaxAmount);
            String sthirdMaxTax = String.format(far,thirdMaxTax).concat(tk);
            c3.setText(sThirdMaxAmount + tk);
            d3.setText(sthirdMaxTax);
            //                TextToSpeech
            voiceAsst(sthirdMaxTax);
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
            String newSumThirdTax = String.format(far,sumThirdTax).concat(tk);
            taxResult.setText(newSumThirdTax);
            //                TextToSpeech
            voiceAsst(newSumThirdTax);
        } else if (newUserInput > ballance4) {
            double fourthMaxAmount = ballance4 - ballance3;
            double fourthMaxTax = (fourthMaxAmount * 15 / 100);
            String sfourthMaxAmount = String.format(far,fourthMaxAmount);
            String sfourthMaxTax = String.format(far,fourthMaxTax).concat(tk);
            c4.setText(sfourthMaxAmount + tk);
            d4.setText(sfourthMaxTax);
            //                TextToSpeech
            voiceAsst(sfourthMaxTax);
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
            String newFourthTax = String.format(far,sumfourthTax).concat(tk);
            taxResult.setText(newFourthTax);
            //                TextToSpeech
            voiceAsst(newFourthTax);
        } else if (newUserInput > ballance5) {
            double fifthMaxAmount = ballance5 - ballance4;
            double fifthMaxTax = (fifthMaxAmount * 20) / 100;
            String sfifthMaxAmount = String.format(far,fifthMaxAmount).concat(tk);
            String sfifthMaxTax = String.format(far,fifthMaxTax).concat(tk);
            c5.setText(sfifthMaxAmount);
            d5.setText(sfifthMaxTax);
            //                TextToSpeech
            voiceAsst(sfifthMaxTax);
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
            String newSumFifthTax = String.format(far,sumFifthTax).concat(tk);
            taxResult.setText(newSumFifthTax);
            //                TextToSpeech
            voiceAsst(newSumFifthTax);
        } else if (newUserInput <= ballance5) {
            c6.setText("");
            d6.setText("");
        }
        ;
//                SixthMethod

//                if incase given amount is more than 999999999 digit then it will work for better user expreance
        if (userInput.length() > 13) {
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

    };//calculator finished

    //    VoiceAsist
    public void voiceAsst(String voice){
        int speech = sp.speak("আপনার ট্যাক্স হচ্ছে",TextToSpeech.QUEUE_FLUSH,null);
        int taxResult = sp.speak(voice,TextToSpeech.QUEUE_ADD,null);
    };//voiceAsist

    //    voiceBrief
    public void voiceBrief(String voice){
        int taxResult = sp.speak(voice,TextToSpeech.QUEUE_ADD,null);
    };//voiceBrief

    public void textToVoice(){
        sp = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = sp.setLanguage(new Locale("bn_BD"));
                        }
                    }
                });
    };//textToVoice

    //        for Empty requration
    public TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String uservalue = inputVal.getText().toString();
            if (!uservalue.isEmpty() && !uservalue.matches("[.0-9]+")) {
                Toast.makeText(SlabCalculator.this, "ইনপুট সঠিক নয়!!", Toast.LENGTH_SHORT).show();
                calcButton.setEnabled(false);
                inputError.setVisibility(View.VISIBLE);
                calcButton_disabled.setVisibility(View.VISIBLE);
                calcButton_disabled.setEnabled(true);
            }else{
                calcButton.setEnabled(true);
                inputError.setVisibility(View.INVISIBLE);
                calcButton_disabled.setVisibility(View.INVISIBLE);
                calcButton_disabled.setEnabled(false);

            };


        }

        @Override
        public void afterTextChanged(Editable editable) {
//            calcButton.setEnabled(true);


        }
    };  //for Empty requration






    }//SlabCalcolatorCalss


