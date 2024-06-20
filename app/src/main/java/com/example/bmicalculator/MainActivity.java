package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText  edtweight,edtheigtft,edtheigtin;
        Button btnCalculate;
        TextView txtbmi,txtResult;


        edtweight=findViewById(R.id.edtweight);
        edtheigtft=findViewById(R.id.edtheigtft);
        edtheigtin=findViewById(R.id.edtheigtin);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        txtbmi=findViewById(R.id.txtbmi);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  wt=Integer.parseInt(edtweight.getText().toString());
                int ft=Integer.parseInt(edtheigtft.getText().toString());
                int in=Integer.parseInt(edtheigtin.getText().toString());

                int totalIn=ft*12+in;

                double totalCm=totalIn*2.53;

                double totalM=totalCm/100;
                double bmi=wt/(totalM*totalM);

                if(bmi>25){
                    txtbmi.setText(String.format("BMI : %.2f",bmi));
                    txtResult.setText("You are Overweight");
                    txtResult.setTextColor(getResources().getColor(R.color.colorOw));

                } else if (bmi<18) {
                    txtbmi.setText(String.format("BMI : %.2f",bmi));
                    txtResult.setText("You are Underweight");
                    txtResult.setTextColor(getResources().getColor(R.color.colorUw));

                }else {
                    txtbmi.setText(String.format("BMI : %.2f",bmi));
                    txtResult.setText("You are Healthy");
                    txtResult.setTextColor(getResources().getColor(R.color.colorh));

                }
            }
        });
    }
}