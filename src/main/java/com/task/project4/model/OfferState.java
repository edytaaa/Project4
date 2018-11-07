package com.task.project4.model;

public enum OfferState {

    FREE("Wolne"),
    BOOKED("Zarezerwowane"),
    SOLD("Sprzedane");


    private String plState;

    OfferState(String plState) {
        this.plState = plState;
    }

    public String getPlState() {
        return plState;
    }

    public void setPlState(String plState) {
        this.plState = plState;
    }
}
