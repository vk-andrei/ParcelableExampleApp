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
    private String history = "";
    private Double result;
    private int operation = 0;

    public Calculator(CalcView calcView) {
        this.calcView = calcView;
    }
    // указываем на новую активити в случае поворота экрана или убийства
    public void setCalcView(CalcView calcView) {
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
        history += "1";
        update(history);
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
        history += "2";
        update(history);
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
        history += "3";
        update(history);
    }

    public void onPointPressed() {
        if (operation == 0) {
            firstNumber += ".";
        } else {
            secondNumber += ".";
        }
        history += ".";
        update(secondNumber);
    }

    public void update(String history) {
        if (operation != 0) {
            if (!secondNumber.equals("")) {
                calcView.showResult(secondNumber);
            } else {
                calcView.showResult(firstNumber);
            }
        } else {
            calcView.showResult(firstNumber);
        }
        calcView.showHistory(history);
    }

    public void onPlusPressed() {
        operation = 1;
        history += " + ";
        calcView.showHistory(history);
    }

    public void onMultPressed() {
        operation = 2;
        calcView.showHistory(firstNumber + " x ");
    }

    public void onEqualPressed() {
        if (operation == 1) {
            result = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
        } else if (operation == 2) {
            result = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
        }
        operation = 0;
        calcView.showResult(String.valueOf(result));
    }

    protected Calculator(Parcel in) {
        firstNumber = in.readString();
        secondNumber = in.readString();
        operation = in.readInt();
        history = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstNumber);
        parcel.writeString(secondNumber);
        parcel.writeInt(operation);
        parcel.writeString(history);
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
        history = "";
        calcView.showHistory("0");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getHistory() {
        return history;
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