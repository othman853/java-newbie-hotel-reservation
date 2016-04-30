package com.yrachid.reservations.data;


public class FileLine {

    public final int number;
    public final String value;

    public FileLine(int number, String value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return number + ": " + value;
    }
}
