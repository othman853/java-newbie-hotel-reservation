package com.yrachid.reservations.domain;


public enum CustomerType {

    REGULAR("Regular"),
    REWARDS("Rewards");

    private String type;

    CustomerType(String type) {
        this.type = type;
    }

    public String asString(){
        return type;
    }
}
