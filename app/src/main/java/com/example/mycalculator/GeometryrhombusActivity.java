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

public class GeometryrhombusActivity extends AppCompatActivity {

    Button btnRhombusResultButton;
    EditText btnRhombusResult;
    EditText btnRhombusResult2;
    TextView textRhombusResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometryrhombus);
        btnRhombusResultButton = findViewById(R.id.btnRhombusResultButton);
        btnRhombusResult = findViewById(R.id.btnRhombusResult);
        btnRhombusResult2 = findViewById(R.id.btnRhombusResult2);
        textRhombusResult = findViewById(R.id.textRhombusResult);
        btnRhombusResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double A = Double.parseDouble(btnRhombusResult.getText().toString());
                double B = Double.parseDouble(btnRhombusResult.getText().toString());
                double result = A*B/2;
                textRhombusResult.setText(""+result);
            }
        });

    }
}