package com.zielniok.agot.model;

public class Plot {

    private int gold;
    private int initiative;
    private int claim;
    private int reserve;

    public Plot (int pGold, int pInitiative, int pClaim, int pReserve){
        gold = pGold;
        initiative = pInitiative;
        claim = pClaim;
        reserve = pReserve;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getClaim() {
        return claim;
    }

    public void setClaim(int claim) {
        this.claim = claim;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

}
