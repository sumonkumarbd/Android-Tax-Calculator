package com.sumonkmr.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = findViewById(R.id.mainButton);

        mainButton.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this, SlabCalculator.class);
            startActivity(intent);
        });



    }//onCreate Bundle
}//main Finised