package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GeometrytrapezoidActivity extends AppCompatActivity {

    Button btnTrapezoidResult;
    EditText editTrapezoidA;
    EditText editTrapezoidB;
    EditText editTrapezoidH;
    TextView textTrapezoidResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometrytrapezoid);
        btnTrapezoidResult = findViewById(R.id.btnTrapezoidResult);
        editTrapezoidA = findViewById(R.id.editTrapezoidA);
        editTrapezoidB = findViewById(R.id.editTrapezoidB);
        editTrapezoidH = findViewById(R.id.editTrapezoidH);
        textTrapezoidResult = findViewById(R.id.textTrapezoidResult);
        btnTrapezoidResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double A = Double.parseDouble(editTrapezoidA.getText().toString());
                double B = Double.parseDouble(editTrapezoidB.getText().toString());
                double H = Double.parseDouble(editTrapezoidH.getText().toString());
                double result = (A+B)*H/2;
                textTrapezoidResult.setText(""+result);
            }
        });
    }
}