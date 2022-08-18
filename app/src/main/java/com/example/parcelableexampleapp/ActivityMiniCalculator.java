package com.example.parcelableexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMiniCalculator extends AppCompatActivity {

    private TextView tv_inputted_numbs;
    private EditText et_main;
    private Button btnOne, btnTwo, btnThree, btnPoint, btnPlus, btnMult, btnEqual, btnClr;
    private Double firstNumber;
    private Double secondNumber;
    private Double result;
    private int operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_calculator);

        init();
        setListeners();

    }

    private void init() {
        tv_inputted_numbs = findViewById(R.id.tv_inputted_numbs);
        et_main = findViewById(R.id.et_main);
        btnOne = findViewById(R.id.btn_One);
        btnTwo = findViewById(R.id.btn_Two);
        btnThree = findViewById(R.id.btn_Three);
        btnPoint = findViewById(R.id.btn_Point);
        btnPlus = findViewById(R.id.btn_Plus);
        btnMult = findViewById(R.id.btn_Mult);
        btnEqual = findViewById(R.id.btn_Equal);
        btnClr = findViewById(R.id.btn_Clear);
    }

    private void setListeners() {
        View.OnClickListener calcListener = view -> {

            int id = view.getId();
            if (id == R.id.btn_One) {
                et_main.setText(String.format("%s1", et_main.getText()));
            } else if (id == R.id.btn_Two) {
                et_main.setText(String.format("%s2", et_main.getText()));
            } else if (id == R.id.btn_Three) {
                et_main.setText(String.format("%s3", et_main.getText()));
            } else if (id == R.id.btn_Point) {
                et_main.setText(String.format("%s.", et_main.getText()));
            } else if (id == R.id.btn_Plus) {
                operation = 1;
                firstNumber = Double.parseDouble(String.valueOf(et_main.getText()));
                //Toast.makeText(this, "first = " + firstNumber, Toast.LENGTH_SHORT).show();
                tv_inputted_numbs.setText(String.format("%s + ", et_main.getText()));
                et_main.setText("");
            } else if (id == R.id.btn_Mult) {
                operation = 2;
                tv_inputted_numbs.setText(String.format("%s * ", et_main.getText()));
                firstNumber = Double.parseDouble(String.valueOf(et_main.getText()));
                et_main.setText("");
            } else if (id == R.id.btn_Equal) {
                secondNumber = Double.parseDouble(String.valueOf(et_main.getText()));
                tv_inputted_numbs.setText(String.format("%s %s =", tv_inputted_numbs.getText(), secondNumber));

                if (operation == 1) {
                    result = firstNumber + secondNumber;
                    operation = 0;
                } else if (operation == 2) {
                    result = firstNumber * secondNumber;
                }
                et_main.setText(String.valueOf(result));

            } else if (id == R.id.btn_Clear) {
                tv_inputted_numbs.setText("");
                et_main.setText("");
            }
        };
        btnOne.setOnClickListener(calcListener);
        btnTwo.setOnClickListener(calcListener);
        btnThree.setOnClickListener(calcListener);
        btnPoint.setOnClickListener(calcListener);
        btnPlus.setOnClickListener(calcListener);
        btnMult.setOnClickListener(calcListener);
        btnEqual.setOnClickListener(calcListener);
        btnClr.setOnClickListener(calcListener);
    }

}