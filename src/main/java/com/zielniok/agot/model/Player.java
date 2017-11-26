package com.zielniok.agot.model;

public class Player {

    private boolean isActive;
    private Plot currentPlot;

    public Player(){};
    public Player(Plot plot){
        currentPlot = plot;
    }

    public int getGoldValue() {
        return currentPlot.getGold();
    }
    public void refreshGoldValue(int goldValue){
        currentPlot.setGold(goldValue);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
