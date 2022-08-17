package com.example.parcelableexampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNTER_1 = "KEY_COUNTER_1";
    private static final String KEY_COUNTER_2 = "KEY_COUNTER_2";
    private static final String KEY_COUNTER_3 = "KEY_COUNTER_3";
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER_1, counter1);
        outState.putInt(KEY_COUNTER_2, counter2);
        outState.putInt(KEY_COUNTER_3, counter3);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter1 = savedInstanceState.getInt(KEY_COUNTER_1);
        counter2 = savedInstanceState.getInt(KEY_COUNTER_2);
        counter3 = savedInstanceState.getInt(KEY_COUNTER_3);
        init();
    }

    public void init() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        tv1 = findViewById(R.id.tv_1);
        tv1.setText(String.valueOf(counter1));
        tv2 = findViewById(R.id.tv_2);
        tv2.setText(String.valueOf(counter2));
        tv3 = findViewById(R.id.tv_3);
        tv3.setText(String.valueOf(counter3));
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
        // говорю кнопке чтобы она слушала myListener.
        // Есть еще способ - имплементировать метод View.OnClickListener в самой активити, и тогда кнопке
        // передавать саму активити this
        btn1.setOnClickListener(myListener);
        btn2.setOnClickListener(myListener);
        btn3.setOnClickListener(myListener);

    }
}