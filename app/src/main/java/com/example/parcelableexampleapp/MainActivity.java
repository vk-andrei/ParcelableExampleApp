package com.example.parcelableexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;

    private Button btn1, btn2, btn3;
    private TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListeners();
    }

    public void init() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        tv3 = findViewById(R.id.tv_3);
    }

    private void setListeners() {
        View.OnClickListener myListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_1:
                        counter1++;
                        tv1.setText(String.valueOf(counter1));
                        break;
                    case R.id.btn_2:
                        counter2++;
                        tv2.setText(String.valueOf(counter2));
                        break;
                    case R.id.btn_3:
                        counter3++;
                        tv3.setText(String.valueOf(counter3));
                        break;
                    default: {
                    }

                }
            }
        };
        btn1.setOnClickListener(myListener);
        btn2.setOnClickListener(myListener);
        btn3.setOnClickListener(myListener);

    }
}