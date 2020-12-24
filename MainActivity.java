package com.example.calcolatorebmi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.icu.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod(){
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {          //Method to set a click Listener to the button
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final EditText weightText = (EditText) findViewById(R.id.weightInput);
                String weightStr = weightText.getText().toString();                         //get the text digit by the user in the first field
                double weight = Double.parseDouble(weightStr);                              //Convert the value from String to double
                final EditText heightText = (EditText) findViewById(R.id.heightInput);
                String heightStr = heightText.getText().toString();                         //Get the text digit by the user in the second field
                double height = Double.parseDouble(heightStr);                              //Convert the values from String to double
                double BMI = weight / (height * height);                                    //Calculate the BMI
                final EditText risultato = (EditText) findViewById(R.id.result);
                risultato.setText(Double.toString(BMI));                                    //Set the BMI's value in the text area
                String BMI_Cat;
                if(BMI < 15)                                                                //With a series of IF control determine the respective result
                    BMI_Cat = "Very severely underweight";
                else if (BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if (BMI < 18.5)
                    BMI_Cat = "Underweight";
                else if (BMI < 25)
                    BMI_Cat = "Normal";
                else if (BMI < 30)
                    BMI_Cat = "Overweight";
                else if (BMI < 35)
                    BMI_Cat = "Obese Class 1 – Moderately Obese";
                else if (BMI < 40)
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                else
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";

                final TextView finalResult = (TextView) findViewById(R.id.BMIResult);       //String result's output
                finalResult.setText(BMI_Cat);
            }
        });
    }
}