package com.example.mycalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GeometryOptionActivty extends AppCompatActivity {
    Button btnCircle;
    Button btnTrapezoid;
    Button btnParallelogram;
    Button btnRhombus;
    ImageView imgMolle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometry_option_activty);
        btnCircle = findViewById(R.id.btnCircle);
        btnTrapezoid = findViewById(R.id.btnTrapezoid);
        btnParallelogram = findViewById(R.id.btnParallelogram);
        btnRhombus = findViewById(R.id.btnRhombus);
        imgMolle = findViewById(R.id.imgMolle);
    }
}