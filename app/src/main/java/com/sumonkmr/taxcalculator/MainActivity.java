package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {

//       varriables
    TextView c1, c2, c3, c4, c5, c6 ;
    TextView d1, d2, d3, d4, d5, d6, amountResult, taxResult;
    EditText inputVal;
    Button calcButton;
    double a1, a2, a3, a4, a5, sumTax;

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
        taxResult = findViewById(R.id.taxResult);
        amountResult = findViewById(R.id.amountResult);
        inputVal = findViewById(R.id.inputVal);
        calcButton = findViewById(R.id.calcButton);

        a1 = 300000;
        a2 = 400000;
        a3 = 700000;
        a4 = 1100000;
        a5 = 1600000;
        sumTax = 195000;


        //                thiorys\
        inputVal.addTextChangedListener(textWatcher);
        calcButton.setEnabled(false);

//        if (TextUtils.isEmpty(inputVal.getText().toString())){
//            Toast.makeText(MainActivity.this, "Please Enter Your Amount", Toast.LENGTH_SHORT).show();
//            calcButton.setEnabled(false);
//            return;
//        }else {
//            calcButton.setEnabled(true);
//        };




//


////       Litseners
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userInput = inputVal.getText().toString();
                double newUserInput = Double.parseDouble(userInput);
                BigDecimal userValue = BigDecimal.valueOf(newUserInput).setScale(2,1);



//                variabls with Theory
                String tk = " tk";
                double firstTaxamount = (double) (newUserInput - a1);
                BigDecimal ftaxAmount = BigDecimal.valueOf(firstTaxamount).setScale(2,1);
                double firstTax = firstTaxamount*5/100;
                BigDecimal fstTax = BigDecimal.valueOf(firstTax).setScale(2,1);

                double secoundTaxableamount = (newUserInput - a2);
                BigDecimal secTaxAmount = BigDecimal.valueOf(secoundTaxableamount).setScale(2,1);
                double  secondTax = secoundTaxableamount*10/100;
                BigDecimal secTax = BigDecimal.valueOf(secondTax).setScale(2,1);

                double thirdTaxableamount = (double) (newUserInput - a3);
                BigDecimal thirdTaxAmount = BigDecimal.valueOf(thirdTaxableamount).setScale(2,1);
                double thirdTax = thirdTaxableamount*15/100;
                BigDecimal sThirdTax = BigDecimal.valueOf(thirdTax).setScale(2,1);


                double fourthTaxableamount =newUserInput - a4;
                BigDecimal fourthTaxAmount = BigDecimal.valueOf(fourthTaxableamount).setScale(2,1);
                double fourthTax = fourthTaxableamount*20/100;
                BigDecimal newfourthTax = BigDecimal.valueOf(fourthTax).setScale(2,1);

                double fifthTaxableamount = (double) (newUserInput - a5);
                BigDecimal fifthTaxAmount = BigDecimal.valueOf(fifthTaxableamount).setScale(2,1);
                double fifthTax = fifthTaxableamount*25/100;
                BigDecimal newfifthTax = BigDecimal.valueOf(fifthTax).setScale(2,1);


                //                ResultBar
                amountResult.setText(userValue + tk);





//                firstMathod
                    if (newUserInput <= a1) {
                        c1.setText(userValue + tk);
                        d1.setText("0 tk");
                        c2.setText("");
                        d2.setText("");
                        taxResult.setText("0 tk");
                    } else if (newUserInput > a1) {
                        String newA1 = String.valueOf(a1);
                        c1.setText(newA1 + tk);
                        d1.setText("0 tk");
                    }
                    ;
//            firstMathod

                    //            secondMathode
                    if (newUserInput > a1 && newUserInput <= a2) {
                        c2.setText(ftaxAmount + tk);
                        d2.setText(fstTax + " tk");
                        taxResult.setText(fstTax+tk);
                    } else if (newUserInput > a2) {
                        double secoundMaxAmount = a2 - a1;
                        double secoundMaxTax = (secoundMaxAmount * 5 / 100);
                        c2.setText(secoundMaxAmount + tk);
                        d2.setText(secoundMaxTax + tk);
                    }
                    ;
//            secondMathode


//                THirdMathod
                    if (newUserInput > a2 && newUserInput <= a3) {
                        c3.setText(secTaxAmount + tk);
                        d3.setText(secTax + tk);
                        double sumSecTax =secondTax + 5000;
                        BigDecimal newSumSecTax = BigDecimal.valueOf(sumSecTax).setScale(2,1);
                        taxResult.setText(newSumSecTax+tk);
                    } else if (newUserInput > a3) {
                        double ThirdMaxAmount = a3 - a2;
                        double thirdMaxTax = (ThirdMaxAmount * 10 / 100);
                        c3.setText(ThirdMaxAmount + tk);
                        d3.setText(thirdMaxTax + tk);
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
                        BigDecimal newSumThirdTax = BigDecimal.valueOf(sumThirdTax).setScale(2,1);
                        taxResult.setText(newSumThirdTax+tk);
                    } else if (newUserInput > a4) {
                        double fourthMaxAmount = a4 - a3;
                        double fourthMaxTax = (fourthMaxAmount * 15 / 100);
                        c4.setText(fourthMaxAmount + tk);
                        d4.setText(fourthMaxTax + tk);
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
                        BigDecimal newFourthTax = BigDecimal.valueOf(sumfourthTax).setScale(2,1);
                        taxResult.setText(newFourthTax+tk);
                    } else if (newUserInput > a5) {
                        double fourthMaxAmount = a5 - a4;
                        double fourthMaxTax = (fourthMaxAmount * 20) / 100;
                        String sFourthTax = String.valueOf(fourthMaxTax);
                        c5.setText(fourthMaxAmount + tk);
                        d5.setText(sFourthTax + tk);
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
                        BigDecimal newSumFifthTax = BigDecimal.valueOf(sumFifthTax).setScale(2,1);
                        taxResult.setText(newSumFifthTax+tk);
                    } else if (newUserInput <= a5) {
                        c6.setText("");
                        d6.setText("");
                    }
                    ;
//                SixthMethod

//                if incase given amount is more than 999999999 digit then it will work for better user expreance
                if (newUserInput > 99999999) {
                    amountResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                    taxResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                }else {
                    amountResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    taxResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                };


                inputVal.setText("");
            };
//            clcButtion OnClick Litsenr




        });




    }//    View.OnCreateSaveInstance




    //        for Empty requration

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String userValue = inputVal.getText().toString();
            if (!userValue.isEmpty()){
                calcButton.setEnabled(true);
            }else {
                calcButton.setEnabled(false);
            };
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            calcButton.setEnabled(true);

        }
    };


};
