package com.example.parcelableexampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNTER_1 = "KEY_COUNTER_1";
    private static final String KEY_COUNTER_2 = "KEY_COUNTER_2";
    private static final String KEY_COUNTER_3 = "KEY_COUNTER_3";
    private static final String KEY_COUNTER = "KEY_COUNTER";
    /*private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;*/

    private Button btn1, btn2, btn3, btnMiniCalculator;
    private TextView tv1, tv2, tv3;
    private Counter counter = new Counter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        /**** SIMPLE DATA  ****/
        /*outState.putInt(KEY_COUNTER_1, counter1);
        outState.putInt(KEY_COUNTER_2, counter2);
        outState.putInt(KEY_COUNTER_3, counter3);*/
        /**** DATA of the class  ****/
        /*outState.putInt(KEY_COUNTER_1, counter.getCounter1());
        outState.putInt(KEY_COUNTER_2, counter.getCounter2());
        outState.putInt(KEY_COUNTER_3, counter.getCounter3());*/
        /**** DATA of the class with Parcelable  ****/
        outState.putParcelable(KEY_COUNTER, counter);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /**** SIMPLE DATA  ****/
        /*counter1 = savedInstanceState.getInt(KEY_COUNTER_1);
        counter2 = savedInstanceState.getInt(KEY_COUNTER_2);
        counter3 = savedInstanceState.getInt(KEY_COUNTER_3);*/
        /**** DATA of the class  ****/
        /*counter.setCounter1(savedInstanceState.getInt(KEY_COUNTER_1));
        counter.setCounter2(savedInstanceState.getInt(KEY_COUNTER_2));
        counter.setCounter3(savedInstanceState.getInt(KEY_COUNTER_3));*/
        /**** DATA of the class with Parcelable  ****/
        counter = savedInstanceState.getParcelable(KEY_COUNTER);
        init();
    }

    private void init() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btnMiniCalculator= findViewById(R.id.btn_mini_calculator);
        tv1 = findViewById(R.id.tv_1);
        tv1.setText(String.valueOf(counter.getCounter1()));
        tv2 = findViewById(R.id.tv_2);
        tv2.setText(String.valueOf(counter.getCounter2()));
        tv3 = findViewById(R.id.tv_3);
        tv3.setText(String.valueOf(counter.getCounter3()));
    }

    private void setListeners() {
        View.OnClickListener myListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_1:
                        counter.incrementCounter1();
                        tv1.setText(String.valueOf(counter.getCounter1()));
                        break;
                    case R.id.btn_2:
                        counter.incrementCounter2();
                        tv2.setText(String.valueOf(counter.getCounter2()));
                        break;
                    case R.id.btn_3:
                        counter.incrementCounter3();
                        tv3.setText(String.valueOf(counter.getCounter3()));
                        break;
                    case R.id.btn_mini_calculator:
                        Intent intent = new Intent(MainActivity.this, ActivityMiniCalculator.class);
                        startActivity(intent);
                        break;

                    default: {
                    }

                }
            }
        };
        // ???????????? ???????????? ?????????? ?????? ?????????????? myListener.
        // ???????? ?????? ???????????? - ???????????????????????????????? ?????????? View.OnClickListener ?? ?????????? ????????????????, ?? ?????????? ????????????
        // ???????????????????? ???????? ???????????????? this
        btn1.setOnClickListener(myListener);
        btn2.setOnClickListener(myListener);
        btn3.setOnClickListener(myListener);
        btnMiniCalculator.setOnClickListener(myListener);
    }
}