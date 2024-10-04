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

public class GeometryparallelogramActivity extends AppCompatActivity {

    Button btnParallelogramResult;
    EditText editParallelogramA;
    EditText btnParallelogramB;
    TextView textParallelogramResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometryparallelogram);
        btnParallelogramResult = findViewById(R.id.btnParallelogramResult);
        editParallelogramA = findViewById(R.id.editParallelogramA);
        btnParallelogramB = findViewById(R.id.btnParallelogramB);
        textParallelogramResult = findViewById(R.id.textParallelogramResult);
        btnParallelogramResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double A = Double.parseDouble(editParallelogramA.getText().toString());
                double B = Double.parseDouble(btnParallelogramB.getText().toString());
                double result = A*B;
                textParallelogramResult.setText(""+result);
            }
        });
    }
}