package com.sumonkmr.taxcalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Currency;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

//       varriables
    TextView c1, c2, c3, c4, c5, c6 ;
    TextView d1, d2, d3, d4, d5, d6, amountResult, taxResult;
    EditText inputVal;
    Button calcButton;
    float a1, a2, a3, a4, a5, sumTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

//        values
        a1 = 300000;
        a2 = 400000;
        a3 = 700000;
        a4 = 1100000;
        a5 = 1600000;
        sumTax = 195000;


        //                Actions
        inputVal.addTextChangedListener(textWatcher);
        calcButton.setEnabled(false);

        Handler h = new Handler();
        Runnable r = () -> Toast.makeText(MainActivity.this, "Put your amount to check your tax!!", Toast.LENGTH_LONG).show();
        h.postDelayed(r,2000);






//      Litseners
        calcButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {

                String userInput = inputVal.getText().toString();
                float newUserInput = Float.valueOf(userInput);
                String userValue = String.format("%,.2f",newUserInput);






//                variabls with Theory
                String tk = " tk";
                float firstTaxamount =(newUserInput - a1);
                String ftaxAmount = String.format("%,.2f",firstTaxamount);
                float firstTax = firstTaxamount*5/100;
                String fstTax = String.format("%,.2f",firstTax);

                float secoundTaxableamount = (newUserInput - a2);
                String secTaxAmount = String.format("%,.2f",secoundTaxableamount);
                float  secondTax = secoundTaxableamount*10/100;
                String secTax = String.format("%,.2f",secondTax);


                float thirdTaxableamount = (float) (newUserInput - a3);
                String thirdTaxAmount = String.format("%,.2f",thirdTaxableamount);
                float thirdTax = thirdTaxableamount*15/100;
                String sThirdTax = String.format("%,.2f",thirdTax);


                float fourthTaxableamount =newUserInput - a4;
                String fourthTaxAmount = String.format("%,.2f",fourthTaxableamount);
                float fourthTax = fourthTaxableamount*20/100;
                String newfourthTax = String.format("%,.2f",fourthTax);

                float fifthTaxableamount = (float) (newUserInput - a5);
                String fifthTaxAmount = String.format("%,.2f",fifthTaxableamount);
                float fifthTax = fifthTaxableamount*25/100;
                String newfifthTax = String.format("%,.2f",fifthTax);


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
                        String newA1 = String.format("%,.2f",a1);
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
                        float secoundMaxAmount = a2 - a1;
                        float secoundMaxTax = (secoundMaxAmount * 5 / 100);
                        String sMaxsecAmount = String.format("%,.2f",secoundMaxAmount);
                        String sMaxsecTax = String.format("%,.2f",secoundMaxTax);
                        c2.setText(sMaxsecAmount + tk);
                        d2.setText(sMaxsecTax + tk);
                    }
                    ;
//            secondMathode


//                THirdMathod
                    if (newUserInput > a2 && newUserInput <= a3) {
                        c3.setText(secTaxAmount + tk);
                        d3.setText(secTax + tk);
                        float sumSecTax =secondTax + 5000;
                        String newSumSecTax = String.format("%,.2f",sumSecTax);
                        taxResult.setText(newSumSecTax+tk);
                    } else if (newUserInput > a3) {
                        float ThirdMaxAmount = a3 - a2;
                        float thirdMaxTax = (ThirdMaxAmount * 10 / 100);
                        String sThirdMaxAmount = String.format("%,.2f",ThirdMaxAmount);
                        String sthirdMaxTax = String.format("%,.2f",thirdMaxTax);
                        c3.setText(sThirdMaxAmount + tk);
                        d3.setText(sthirdMaxTax + tk);
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
                        float sumThirdTax = thirdTax + 35000;
                        String newSumThirdTax = String.format("%,.2f",sumThirdTax);
                        taxResult.setText(newSumThirdTax+tk);
                    } else if (newUserInput > a4) {
                        float fourthMaxAmount = a4 - a3;
                        float fourthMaxTax = (fourthMaxAmount * 15 / 100);
                        String sfourthMaxAmount = String.format("%,.2f",fourthMaxAmount);
                        String sfourthMaxTax = String.format("%,.2f",fourthMaxTax);
                        c4.setText(sfourthMaxAmount + tk);
                        d4.setText(sfourthMaxTax + tk);
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
                        float sumfourthTax = fourthTax + 95000;
                        String newFourthTax = String.format("%,.2f",sumfourthTax);
                        taxResult.setText(newFourthTax+tk);
                    } else if (newUserInput > a5) {
                        float fifthMaxAmount = a5 - a4;
                        float fifthMaxTax = (fifthMaxAmount * 20) / 100;
                      String sfifthMaxAmount = String.format("%,.2f",fifthMaxAmount);
                        String sfifthMaxTax = String.format("%,.2f",fifthMaxTax);
                        c5.setText(sfifthMaxAmount + tk);
                        d5.setText(sfifthMaxTax + tk);
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
                        float sumFifthTax = fifthTax + 195000;
                        String newSumFifthTax = String.format("%,.2f",sumFifthTax);
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
                    c6.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                    d6.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
                }else {
                    amountResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    taxResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
                    c6.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    d6.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                };


                inputVal.setText("");
                calcButton.setEnabled(false);
            };
//            clcButtion OnClick Litsenr
        });// ClacButton Listener




    }//    View.OnCreateSaveInstance




    //        for Empty requration
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String userValue = inputVal.getText().toString();
            if (!userValue.isEmpty()){
                calcButton.setEnabled(true);
            }else{
                calcButton.setEnabled(false);
                Toast.makeText(MainActivity.this, "Put Your Amount For Check Your Tax!!", Toast.LENGTH_SHORT).show();
            };

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            calcButton.setEnabled(true);


        }
    };  //        for Empty requration


};//MainActivities
