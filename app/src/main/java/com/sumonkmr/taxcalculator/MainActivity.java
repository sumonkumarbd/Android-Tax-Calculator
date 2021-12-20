package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

//       varriables
    TextView c1, c2, c3, c4, c5, c6 ;
    TextView d1, d2, d3, d4, d5, d6, result;
    EditText inputVal;
    Button calcButton;
    double a1, a2, a3, a4, a5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//////        Hooks
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
        result = findViewById(R.id.result);
        inputVal = findViewById(R.id.inputVal);
        calcButton = findViewById(R.id.calcButton);

        a1 = 300000;
        a2 = 400000;
        a3 = 700000;
        a4 = 1100000;
        a5 = 1600000;

        //                thiorys


        
//


////       Litseners
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userInput = inputVal.getText().toString();
                float newUserInput = Float.parseFloat(userInput);
                String mainVal = String.valueOf(newUserInput);

//                variabls
                String tk = " tk";
                double firstTaxamount = newUserInput-a1;
                String ftaxAmount = String.valueOf(firstTaxamount);
                double firstTax = (firstTaxamount*5)/100 ;
                String fTax = String.valueOf(firstTax);

                double secoundTaxableamount = newUserInput-a2;
                double secondTax = (secoundTaxableamount*10)/100 ;
                String secTaxAmount = String.valueOf(secoundTaxableamount);
                String secTax = String.valueOf(secondTax);

                double thirdTaxableamount = newUserInput-a3;
                double thirdTax = (thirdTaxableamount*15)/100 ;
                String thirdTaxAmount = String.valueOf(thirdTaxableamount);
                String sThirdTax = String.valueOf(thirdTax);

                double fourthTaxableamount = newUserInput-a4;
                double fourthTax = (fourthTaxableamount*20)/100 ;
                String fourthTaxAmount = String.valueOf(fourthTaxableamount);
                String newfourthTax = String.valueOf(fourthTax);

                double fifthTaxableamount = newUserInput-a5;
                double fifthTax = (fifthTaxableamount*25)/100 ;
                String fifthTaxAmount = String.valueOf(fifthTaxableamount);
                String newfifthTax = String.valueOf(fifthTax);



//                firstMathod
                if (newUserInput <= a1){
                    c1.setText(mainVal+tk);
                    d1.setText("0 tk");
                    c2.setText("");
                    d2.setText("");
                };
                if (newUserInput > a1){
                    String newA1 = String.valueOf(a1);
                    c1.setText(newA1+tk);
                    d1.setText("0 tk");
                };
//            firstMathod

                //            secondMathode
                if (newUserInput > a1 && newUserInput <= a2){
                    c2.setText(ftaxAmount+tk);
                    d2.setText(fTax+" tk");
                };
                if (newUserInput > a2){
                    double secoundMaxAmount = a2-a1;
                    double secoundMaxTax = (secoundMaxAmount*5/100);
                    c2.setText(secoundMaxAmount+tk);
                    d2.setText(secoundMaxTax+tk);
                };
//            secondMathode


//                THirdMathod
                if (newUserInput > a2 && newUserInput <= a3){
                    c3.setText(secTaxAmount+" tk");
                    d3.setText(secTax+" tk");
                };
                if (newUserInput > a3){
                    double ThirdMaxAmount = a3-a2;
                    double thirdMaxTax = (ThirdMaxAmount*10/100);
                    c3.setText(ThirdMaxAmount+tk);
                    d3.setText(thirdMaxTax+tk);
                };
                if (newUserInput <= a2){
                    c3.setText("");
                    d3.setText("");
                };
//                THirdMathod

//                fouthMathod
                if (newUserInput > a3 && newUserInput <= a4){
                    c4.setText(thirdTaxAmount+" tk");
                    d4.setText(sThirdTax+" tk");
                };
                if (newUserInput > a4){
                    double fourthMaxAmount = a4-a3;
                    double fourthMaxTax = (fourthMaxAmount*15/100);
                    c4.setText(fourthMaxAmount+tk);
                    d4.setText(fourthMaxTax+tk);
                };
                if (newUserInput <= a3){
                    c4.setText("");
                    d4.setText("");
                };
//                fouthMathod

//                FifthMathod
                if (newUserInput > a4 && newUserInput <= a5){
                    c5.setText(fourthTaxAmount+" tk");
                    d5.setText(newfourthTax+" tk");
                };
                if (newUserInput > a5){
                    double fourthMaxAmount = a5-a4;
                    double fourthMaxTax = (fourthMaxAmount*20)/100 ;
                    String sFourthTax = String.valueOf(fourthMaxTax);
                    c5.setText(fourthMaxAmount+tk);
                    d5.setText(sFourthTax+tk);
                };
                if (newUserInput <= a4){
                    c5.setText("");
                    d5.setText("");
                };
//                FifthMathod

//                SixthMethod
                if (newUserInput > a5){
                    c6.setText(fifthTaxAmount+tk);
                    d6.setText(newfifthTax+tk);
                };
                if (newUserInput <= a5){
                    c6.setText("");
                    d6.setText("");
                };
//                SixthMethod

//                TotalTax
                if (newUserInput > 300000){
                    double totalTax = firstTax+secondTax+thirdTax+fourthTax+fifthTax;
                    String sTotalTax = String.valueOf(totalTax);
                    result.setText(sTotalTax);
                };
                if (newUserInput <= 300000){
                    result.setText("0 tk");
                };



            };
//            clcButtion OnClick Litsenr




        });

//



    }
}