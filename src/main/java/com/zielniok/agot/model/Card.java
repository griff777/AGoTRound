package com.zielniok.agot.model;

public class Card {
    private String name;
    private boolean knelt;
    private int cost;
    private int strenght;
    int militaryIkon;
    int intrigueIkon;
    int powerIkon;

    public Card (int pCost, int pMil, int pIntr, int pPow, int pStr){
        cost = pCost;
        militaryIkon = pMil;
        intrigueIkon = pIntr;
        powerIkon = pPow;
        strenght = pStr;
    }

    public Card(int cost){
        this(cost, 0,0,0,0 );}


    public int getMilitaryIkon() {
        return militaryIkon;
    }

    public void setMilitaryIkon(int militaryIkon) {
        this.militaryIkon = militaryIkon;
    }

    public int getIntrigueIkon() {
        return intrigueIkon;
    }

    public void setIntrigueIkon(int intrigueIkon) {
        this.intrigueIkon = intrigueIkon;
    }

    public int getPowerIkon() {
        return powerIkon;
    }

    public void setPowerIkon(int powerIkon) {
        this.powerIkon = powerIkon;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

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
