package com.zielniok.agot.model;

public class Card {
    private String name;
    private boolean knelt;
    private int cost;

    private int strenght;
    int militaryIcon;
    int intrigueIcon;
    int powerIcon;

    public Card (int pCost, int pMil, int pIntr, int pPow, int pStr){
        cost = pCost;
        militaryIcon = pMil;
        intrigueIcon = pIntr;
        powerIcon = pPow;
        strenght = pStr;
    }

    public Card(int cost){
        this(cost, 0,0,0,0 );}


    public int getMilitaryIcon() {
        return militaryIcon;
    }

    public void setMilitaryIcon(int militaryIcon) {
        this.militaryIcon = militaryIcon;
    }

    public int getIntrigueIcon() {
        return intrigueIcon;
    }

    public void setIntrigueIcon(int intrigueIcon) {
        this.intrigueIcon = intrigueIcon;
    }

    public int getPowerIcon() {
        return powerIcon;
    }

    public void setPowerIcon(int powerIcon) {
        this.powerIcon = powerIcon;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
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
