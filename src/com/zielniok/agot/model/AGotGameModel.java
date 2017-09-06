package com.zielniok.agot.model;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class AGotGameModel {

    private List<Card> handP1 = new ArrayList<>();
    private List<Card> handP2 = new ArrayList<>();

    public List<Card> getHandP1() {
        return handP1;
    }

    public void setHandP1(List<Card> handP1) {
        this.handP1 = handP1;
    }

    public List<Card> getHandP2() {
        return handP2;
    }

    public void setHandP2(List<Card> handP2) {
        this.handP2 = handP2;
    }

    public void newGame() {
        
    }

    public void drawInitialCards() {

        for (int i = 0; i < 4 ; i++) {
            Card c = new Card();
            c.setName("Ranging Party");
            handP1.add(c);
        }

        for (int i = 0; i < 4 ; i++) {
            Card c = new Card();
            c.setName("Ranging Party");
            handP2.add(c);
        }
    }

    public void setUpDrawDeck() {

    }
}
