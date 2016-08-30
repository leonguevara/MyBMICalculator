package com.leonguevara.myimccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Double calcBMI(Double mass, Double height) {
        return (mass / (height * height));
    }

    public void calc(View view) {
        EditText heightBox = (EditText) findViewById(R.id.heightText);
        EditText massBox = (EditText) findViewById(R.id.massText);
        TextView labelBMI = (TextView) findViewById(R.id.bmiLabel);

        String sHeight = heightBox.getText().toString().trim();
        String sMass = massBox.getText().toString().trim();

        Double height = Double.parseDouble(sHeight);
        Double mass = Double.parseDouble(sMass);

        // IMC = mass / (height * height)

        if (mass > 0) {
            if (height > 0) {
                //Double imc = mass / (height * height);
                Double imc = calcBMI(mass, height);
                labelBMI.setText("Tu IMC es de: " + imc.toString());
            } else {
                labelBMI.setText("La height debe ser mayor a 0");
            }
        } else {
            labelBMI.setText("La mass debe ser mayor a 0");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
