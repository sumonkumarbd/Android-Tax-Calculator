package com.sumonkmr.taxcalculator;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class SlabCalculator extends Main {

    //       varriables
    TextView c1, c2, c3, c4, c5, c6, d1, d2, d3, d4, d5, d6;
    TextView totalAmount, totalTax, amountResult, taxResult, appName, text_morq;
    TextView season, header_title1, header_title2, header_title3, header_title4;
    LinearLayout header_titles, dataTable_header ,resulBar, bottomArea, input_area;
    EditText inputVal;
    ImageButton calcButton;
    ImageView inputError;
    double a1, a2, a3, a4, a5, sumTax;
    TextToSpeech sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slab_calculator);



//       Hooks
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



//        values
        a1 = 300000;
        a2 = 400000;
        a3 = 700000;
        a4 = 1100000;
        a5 = 1600000;
        sumTax = 195000;
//        Objects
//        Object of Main
        Main main = new Main();
        //        Object of Handler
        Handler handler = new Handler();

//                Actions
//        CAll Functions & Methods
//        ============================
        calcButton.setEnabled(false);

//        for TextMorque
        Runnable taxt = () ->text_morq.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text_morq.setSelected(true);
        handler.postDelayed(taxt,2000);


//        textToVoice
        textToVoice();

//        taxtWatcher
        inputVal.addTextChangedListener(textWatcher);



//        Runnables
        Runnable appname = () -> appName.startAnimation(slide_in_left);
        Runnable seasoN = () -> season.startAnimation(zoom_in);
        Runnable header = () -> header_titles.startAnimation(right_to_left);
        Runnable resbar = () -> resulBar.startAnimation(left_to_right);
        Runnable datatable = () -> dataTable_header.startAnimation(fade_in);
        Runnable input_sec = () -> input_area.startAnimation(right_to_left_slow);
        Runnable bottom_sec = () -> bottomArea.startAnimation(up_from_bottom_slow);
        Runnable title_one = () -> header_title1.startAnimation(fade_in);
        Runnable title_tow = () -> header_title2.startAnimation(fade_in);
        Runnable title_three = () -> header_title3.startAnimation(fade_in);
        Runnable title_four = () -> header_title4.startAnimation(fade_in);
        Runnable ttlAomount = () -> totalAmount.startAnimation(fade_in);
        Runnable ttlTax = () -> totalTax.startAnimation(fade_in);


        Runnable r = () -> Toast.makeText(SlabCalculator.this, "নিশ্চিত করুন এটি আপনার বার্ষিক আয়!!", Toast.LENGTH_LONG).show();


//        animations calling
        handler.postDelayed(r,2000);
        handler.postDelayed(appname,700);
        handler.postDelayed(seasoN,800);
        handler.postDelayed(header,1300);
        handler.postDelayed(resbar,1200);
        handler.postDelayed(datatable,1800);
        handler.postDelayed(input_sec,1300);
        handler.postDelayed(bottom_sec,1500);
        handler.postDelayed(title_one,1500);
        handler.postDelayed(title_tow,1500);
        handler.postDelayed(title_three,1500);
        handler.postDelayed(title_four,1500);
        handler.postDelayed(ttlAomount,1500);
        handler.postDelayed(ttlTax,1500);




//      Litseners
        calcButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                String uservalue = inputVal.getText().toString();
                if (!uservalue.isEmpty()){
                    // calculator
                    calculator();
                }else {
                    calcButton.setEnabled(false);
                };


            }; //OnClick Litsenr
        });// ClacButton Listener


    }//    View.OnCreateSaveInstance



    //    Functions
    public void calculator(){
//                variables with Theory
//        ====================================
        String userInput = inputVal.getText().toString();
        double newUserInput = Double.parseDouble(userInput);
        String userValue = String.format("%,.2f",newUserInput);

        String tk = " টাকা";
        String zero_tk = "0 টাকা ";
        double firstTaxamount =(newUserInput - a1);
        String ftaxAmount = String.format("%,.2f",firstTaxamount);
        double firstTax = firstTaxamount*5/100;
        String fstTax = String.format("%,.2f",firstTax);

        double secoundTaxableamount = (newUserInput - a2);
        String secTaxAmount = String.format("%,.2f",secoundTaxableamount);
        double  secondTax = secoundTaxableamount*10/100;
        String secTax = String.format("%,.2f",secondTax);


        double thirdTaxableamount = (double) (newUserInput - a3);
        String thirdTaxAmount = String.format("%,.2f",thirdTaxableamount);
        double thirdTax = thirdTaxableamount*15/100;
        String sThirdTax = String.format("%,.2f",thirdTax);


        double fourthTaxableamount =newUserInput - a4;
        String fourthTaxAmount = String.format("%,.2f",fourthTaxableamount);
        double fourthTax = fourthTaxableamount*20/100;
        String newfourthTax = String.format("%,.2f",fourthTax);

        double fifthTaxableamount = (double) (newUserInput - a5);
        String fifthTaxAmount = String.format("%,.2f",fifthTaxableamount);
        double fifthTax = fifthTaxableamount*25/100;
        String newfifthTax = String.format("%,.2f",fifthTax);


        //                ResultBar
        amountResult.setText(userValue + tk);


//                firstMathod
        if (newUserInput <= a1) {
            c1.setText(userValue + tk);
            d1.setText(zero_tk);
            c2.setText("");
            d2.setText("");
            taxResult.setText(zero_tk);
            //TextToSpeech
            voiceAsist("0");
        } else if (newUserInput > a1) {
            String newA1 = String.format("%,.2f",a1);
            c1.setText(newA1 + tk);
            d1.setText(zero_tk);
            //                TextToSpeech
            voiceAsist(zero_tk);
        }

        //            secondMathode
        if (newUserInput > a1 && newUserInput <= a2) {
            c2.setText(ftaxAmount + tk);
            d2.setText(fstTax + " টাকা");
            taxResult.setText(fstTax+tk);
            //                TextToSpeech
            voiceAsist(fstTax);
        } else if (newUserInput > a2) {
            double secoundMaxAmount = a2 - a1;
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
        if (newUserInput > a2 && newUserInput <= a3) {
            c3.setText(secTaxAmount + tk);
            d3.setText(secTax + tk);
            double sumSecTax =secondTax + 5000;
            String newSumSecTax = String.format("%,.2f",sumSecTax);
            taxResult.setText(newSumSecTax+tk);
            //                TextToSpeech
            voiceAsist(newSumSecTax);
        } else if (newUserInput > a3) {
            double ThirdMaxAmount = a3 - a2;
            double thirdMaxTax = (ThirdMaxAmount * 10 / 100);
            String sThirdMaxAmount = String.format("%,.2f",ThirdMaxAmount);
            String sthirdMaxTax = String.format("%,.2f",thirdMaxTax);
            c3.setText(sThirdMaxAmount + tk);
            d3.setText(sthirdMaxTax + tk);
            //                TextToSpeech
            voiceAsist(sthirdMaxTax);
        } else if (newUserInput <= a2) {
            c3.setText("");
            d3.setText("");
        }
        ;
//                THirdMathod

//                fouthMathod
        if (newUserInput > a3 && newUserInput <= a4) {
            c4.setText(thirdTaxAmount + tk);
            d4.setText(sThirdTax + tk);
            double sumThirdTax = thirdTax + 35000;
            String newSumThirdTax = String.format("%,.2f",sumThirdTax);
            taxResult.setText(newSumThirdTax+tk);
            //                TextToSpeech
            voiceAsist(newSumThirdTax);
        } else if (newUserInput > a4) {
            double fourthMaxAmount = a4 - a3;
            double fourthMaxTax = (fourthMaxAmount * 15 / 100);
            String sfourthMaxAmount = String.format("%,.2f",fourthMaxAmount);
            String sfourthMaxTax = String.format("%,.2f",fourthMaxTax);
            c4.setText(sfourthMaxAmount + tk);
            d4.setText(sfourthMaxTax + tk);
            //                TextToSpeech
            voiceAsist(sfourthMaxTax);
        } else if (newUserInput <= a3) {
            c4.setText("");
            d4.setText("");
        }
        ;
//                fouthMathod

//                FifthMathod
        if (newUserInput > a4 && newUserInput <= a5) {
            c5.setText(fourthTaxAmount + tk);
            d5.setText(newfourthTax + tk);
            double sumfourthTax = fourthTax + 95000;
            String newFourthTax = String.format("%,.2f",sumfourthTax);
            taxResult.setText(newFourthTax+tk);
            //                TextToSpeech
            voiceAsist(newFourthTax);
        } else if (newUserInput > a5) {
            double fifthMaxAmount = a5 - a4;
            double fifthMaxTax = (fifthMaxAmount * 20) / 100;
            String sfifthMaxAmount = String.format("%,.2f",fifthMaxAmount);
            String sfifthMaxTax = String.format("%,.2f",fifthMaxTax);
            c5.setText(sfifthMaxAmount + tk);
            d5.setText(sfifthMaxTax + tk);
            //                TextToSpeech
            voiceAsist(sfifthMaxTax);
        } else if (newUserInput <= a4) {
            c5.setText("");
            d5.setText("");
        }
        ;
//                FifthMathod

//                SixthMethod
        if (newUserInput > a5) {
            c6.setText(fifthTaxAmount + tk);
            d6.setText(newfifthTax + tk);
            double sumFifthTax = fifthTax + 195000;
            String newSumFifthTax = String.format("%,.2f",sumFifthTax);
            taxResult.setText(newSumFifthTax+tk);
            //                TextToSpeech
            voiceAsist(newSumFifthTax);
        } else if (newUserInput <= a5) {
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


    //                Methods
//        ====================
    void secoundMathod(){};//secoundMethod

    //    VoiceAsist
    public String voiceAsist(String voice){
        int speech = sp.speak("আপনার ট্যাক্স হচ্ছে",TextToSpeech.QUEUE_FLUSH,null);
        int taxResult = sp.speak(voice,TextToSpeech.QUEUE_ADD,null);
        int taka = sp.speak("টাকা",TextToSpeech.QUEUE_ADD,null);
        return voice;
    };//voiceAsist
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
            }else{
                calcButton.setEnabled(true);
                inputError.setVisibility(View.INVISIBLE);
            };


        }

        @Override
        public void afterTextChanged(Editable editable) {
//            calcButton.setEnabled(true);


        }
    };  //for Empty requration




}//MainActivities
