package com.zielniok.agot.model;

import javafx.collections.ObservableList;
import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;

public class AGotGameModel {

    private GamePhase currentPhase = GamePhase.SETUP;

    private List<Card> handP1 = new ArrayList<>();
    private List<Card> handP2 = new ArrayList<>();

    private List<Card> charPlayareaP1 = new ArrayList<>();

    private Player p1 = new Player();
    private Player p2 = new Player();

    public AGotGameModel(){
        p1.setActive(true);
    }

    public GamePhase getCurrentPhase() {
        return currentPhase;
    }
    public void setCurrentPhase(GamePhase currentPhase) {
        this.currentPhase = currentPhase;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }



    public List<Card> getCharPlayareaP1() {
        return charPlayareaP1;
    }

    public void setCharPlayareaP1(List<Card> charPlayareaP1) {
        this.charPlayareaP1 = charPlayareaP1;
    }

    public List<Card> getCharPlayareaP2() {
        return charPlayareaP2;
    }

    public void setCharPlayareaP2(List<Card> charPlayareaP2) {
        this.charPlayareaP2 = charPlayareaP2;
    }

    private List<Card> charPlayareaP2 = new ArrayList<>();


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

        currentPhase = GamePhase.MARSHALLING;
    }

    public void setUpDrawDeck() {

    }

    public void marshallCard(Card c) {
        if (currentPhase != GamePhase.MARSHALLING) throw new IllegalStateException();
        handP1.remove(c);
        charPlayareaP1.add(c);
    }

    public Player whoIsActive(){
        if (p1.isActive())  return p1;
        else if (p2.isActive()) return p2;
        else throw new IllegalStateException();
    }
}
