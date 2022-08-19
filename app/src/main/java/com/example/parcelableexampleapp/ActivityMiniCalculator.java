package com.example.parcelableexampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityMiniCalculator extends AppCompatActivity implements CalcView {

    private TextView tv_inputted_numbs;
    private TextView tv_main;
    private Button btnOne, btnTwo, btnThree, btnPoint, btnPlus, btnMult, btnEqual, btnClr;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_calculator);
        Log.d("TAG", "Act: onCreate: ");

        init();
        calculator = new Calculator(this);


/*        if (savedInstanceState == null) {
              Log.d("TAG", "savedInstanceState: " + savedInstanceState);
            calculator = new Calculator(tv_inputted_numbs, et_main);
        } else {
              Log.d("TAG", "savedInstanceState != null: " + savedInstanceState);
            calculator = savedInstanceState.getParcelable("ARGS");
              Log.d("TAG", "calculator: " + calculator);
              Log.d("TAG", "calculator.first: " + calculator.getFirstNumber());
              Log.d("TAG", "calculator.second: " + calculator.getSecondNumber());
              Log.d("TAG", "calculator.result: " + calculator.getResult());
                tv_inputted_numbs.setText(calculator.getTv_inputted_numbs());
          }*/


        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("ARGS", calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("TAG", "Act: onRestoreInstanceState: ");

        calculator = savedInstanceState.getParcelable("ARGS");

        calculator.update();


    }

    private void init() {
        tv_inputted_numbs = findViewById(R.id.tv_inputted_numbs);
        //tv_inputted_numbs.setText(calculator.);
        tv_main = findViewById(R.id.tv_main);
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
                calculator.onOnePressed();
            } else if (id == R.id.btn_Two) {
                calculator.onTwoPressed();
            } else if (id == R.id.btn_Three) {
                calculator.onThreePressed();
            } else if (id == R.id.btn_Point) {
                calculator.onPointPressed();
            } else if (id == R.id.btn_Plus) {
                calculator.onPlusPressed();
            } else if (id == R.id.btn_Mult) {
                calculator.onMultPressed();
            } else if (id == R.id.btn_Equal) {
                calculator.onEqualPressed();
            } else if (id == R.id.btn_Clear) {
                calculator.onClearPressed();
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

    public void showResult(String text) {
        Log.d("TAG", "ActivityCalc: showResult: " + text);
        tv_main.setText(text);
        //Log.d("TAG", "ActivityCalc: showResult: tv_main " + tv_main);

    }
}