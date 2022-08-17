package com.example.parcelableexampleapp;

public class Counter {

    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;

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
}
