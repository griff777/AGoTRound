package com.zielniok.agot.model;

public class Card {
    private String name;
    private boolean knelt;

    public boolean isKnelt() {
        return knelt;
    }

    public void setKnelt(boolean knelt) {
        this.knelt = knelt;
    }

    public void kneel() {
        setKnelt(true);
    }

    public void stand() {
        setKnelt(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
