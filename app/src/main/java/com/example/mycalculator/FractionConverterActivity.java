package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FractionConverterActivity extends AppCompatActivity {
    EditText numerator1;
    EditText numerator2;
    EditText numerator3;
    EditText numerator4;
    EditText denominator1;
    EditText denominator2;
    EditText denominator3;
    EditText denominator4;
    Button btnConavert1;
    Button btnConavert2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraction_converter);
        numerator1 = findViewById(R.id.numerator1);
        numerator2 = findViewById(R.id.numerator2);
        numerator3 = findViewById(R.id.numerator3);
        numerator4 = findViewById(R.id.numerator4);
        
        denominator1 = findViewById(R.id.denominator1);
        denominator2 = findViewById(R.id.denominator2);
        denominator3 = findViewById(R.id.denominator3);
        denominator4 = findViewById(R.id.denominator4);

        btnConavert1 = findViewById(R.id.btnConvert1);
        btnConavert2 = findViewById(R.id.btnConvert2);

        btnConavert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numerator1.getText().toString().compareTo("") !=0 && denominator1.getText().toString() != ""){
                    int gcd =GCD( Integer.parseInt((numerator1.getText().toString())),Integer.parseInt(denominator1.getText().toString()));
                    numerator3.setText(""+(Integer.parseInt((numerator1.getText().toString()))/gcd));
                    denominator3.setText(""+(Integer.parseInt((denominator1.getText().toString()))/gcd));
                }
            }
        });
        btnConavert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numerator2.getText().toString().compareTo("") !=0 && denominator2.getText().toString() != ""){
                    int gcd =GCD( Integer.parseInt((numerator2.getText().toString())),Integer.parseInt(denominator2.getText().toString()));
                    numerator4.setText(""+(Integer.parseInt((numerator2.getText().toString()))/gcd));
                    denominator4.setText(""+(Integer.parseInt((denominator2.getText().toString()))/gcd));
                }
            }
        });

    }
    int GCD(int a, int b){
        int min = 0;
        if(a > b)
            min = b;
        else
            min = a;
        for(int i = min;i >= 1; i--){
            if(a % i == 0 && b % i ==0) {
                return i;
            }
        }
        return 1;
    }
    int LCM(int a, int b) {
        int gcd = GCD(a,b);
        return a*b / gcd;
    }
}