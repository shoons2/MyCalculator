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

public class GeometrytriangleActivity extends AppCompatActivity {

    Button btnTriangleResult;
    EditText editTriangleA;
    EditText editTriangleB;
    TextView textTriangleResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometrytriangle);
        btnTriangleResult = findViewById(R.id.btnTriangleResult);
        editTriangleA = findViewById(R.id.editTriangleA);
        editTriangleB = findViewById(R.id.editTriangleB);
        textTriangleResult = findViewById(R.id.textTriangleResult);
        btnTriangleResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double A = Double.parseDouble(editTriangleA.getText().toString());
                double B = Double.parseDouble(editTriangleB.getText().toString());
                double result = A*B/2;
                textTriangleResult.setText(""+result);
            }
        });

    }
}