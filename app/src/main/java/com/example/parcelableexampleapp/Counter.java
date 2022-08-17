package com.example.parcelableexampleapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Counter implements Parcelable {

    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;

    public Counter() {
    }


    protected Counter(Parcel in) {
        counter1 = in.readInt();
        counter2 = in.readInt();
        counter3 = in.readInt();
    }

    public static final Creator<Counter> CREATOR = new Creator<Counter>() {
        @Override
        public Counter createFromParcel(Parcel in) {
            return new Counter(in);
        }

        @Override
        public Counter[] newArray(int size) {
            return new Counter[size];
        }
    };

    public void incrementCounter1() {
        counter1++;
    }

    public void incrementCounter2() {
        counter2++;
    }

    public void incrementCounter3() {
        counter3++;
    }

    public int getCounter1() {
        return counter1;
    }

    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    public int getCounter2() {
        return counter2;
    }

    public void setCounter2(int counter2) {
        this.counter2 = counter2;
    }

    public int getCounter3() {
        return counter3;
    }

    public void setCounter3(int counter3) {
        this.counter3 = counter3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(counter1);
        parcel.writeInt(counter2);
        parcel.writeInt(counter3);
    }
}
