package com.example.bmi_app;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText height_ft,height_inch,weightText;
    TextView bmi;
    Button calculate;
    LinearLayout main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        height_ft = findViewById(R.id.height_ft);
        height_inch = findViewById(R.id.height_inch);
        weightText = findViewById(R.id.weightText);
        bmi = findViewById(R.id.bmi);
        calculate = findViewById(R.id.calculate);
        main = findViewById(R.id.main);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int heightft = Integer.parseInt(height_ft.getText().toString());
                int heightinch = Integer.parseInt(height_inch.getText().toString());
                int weight = Integer.parseInt(weightText.getText().toString());

                double heightCM =( (heightft * 12) + heightinch)*2.54;
                double heightM = heightCM/100;
                double BMI = (weight / (heightM * heightM));

                if (BMI < 18.5) {
                    bmi.setText("You are Underweight!!"+BMI);

                } else if ( BMI > 25) {
                    bmi.setText("You are Overweight!!"+ BMI);

                } else {
                    bmi.setText("You are Healthy!!"+BMI);

                }

            }




        });
    }
}