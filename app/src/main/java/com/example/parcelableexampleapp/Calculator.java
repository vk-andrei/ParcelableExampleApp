package com.example.parcelableexampleapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator implements Parcelable {

    private CalcView calcView;
    private String firstNumber = "0";
    private String secondNumber = "";
    private Double result;
    private int operation = 0;

    public Calculator(CalcView calcView) {
        this.calcView = calcView;
    }

    public void onOnePressed() {
        if (operation == 0) {
            if (firstNumber.equals("0")) {
                firstNumber = "1";
            } else {
                firstNumber += "1";
            }
        } else {
            secondNumber += "1";
        }
        update();
    }

    public void onTwoPressed() {
        if (operation == 0) {
            if (firstNumber.equals("0")) {
                firstNumber = "2";
            } else {
                firstNumber += "2";
            }
        } else {
            secondNumber += "2";
        }
        update();
    }

    public void onThreePressed() {
        if (operation == 0) {
            if (firstNumber.equals("0")) {
                firstNumber = "3";
            } else {
                firstNumber += "3";
            }
        } else {
            secondNumber += "3";
        }
        update();
    }

    public void onPointPressed() {
        if (operation == 0) {
            firstNumber += ".";
        } else {
            secondNumber += ".";
        }
        update();
    }

    public void update() {
        if (operation != 0) {
            if (!secondNumber.equals("")) {
                calcView.showResult(secondNumber);
            } else {
                calcView.showResult(firstNumber);
            }
        } else {
            calcView.showResult(firstNumber);
        }
    }

    public void onPlusPressed() {
        operation = 1;
    }

    public void onMultPressed() {
        operation = 2;
    }

    public void onEqualPressed() {
        if (operation == 1) {
            result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
            operation = 0;
        } else if (operation == 2) {
            result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
        }
        calcView.showResult(String.valueOf(result));
    }

    protected Calculator(Parcel in) {
        firstNumber = in.readString();
        secondNumber = in.readString();
        operation = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstNumber);
        parcel.writeString(secondNumber);
        parcel.writeInt(operation);
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public void onClearPressed() {
        firstNumber = "0";
        secondNumber = "";
        operation = 0;
        calcView.showResult("0");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public int getOperation() {
        return operation;
    }
}