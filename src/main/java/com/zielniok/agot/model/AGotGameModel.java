package com.zielniok.agot.model;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

public class AGotGameModel {

    private GamePhase currentPhase = GamePhase.SETUP;

    private List<Card> handP1 = new ArrayList<>();
    private List<Card> handP2 = new ArrayList<>();

    private List<Card> charPlayareaP1 = new ArrayList<>();
    private List<Card> charPlayareaP2 = new ArrayList<>();

    private Player p1 = new Player(new Plot(8, 4, 1, 7));
    private Player p2 = new Player(new Plot(5, 3, 1, 6));

    private List<Integer> challengeStr = new ArrayList();

    private static int marshallingCount;

    public static int getMarshallingCount() {
        return marshallingCount;
    }

    public static void setMarshallingCount(int marshallingCount) {
        AGotGameModel.marshallingCount = marshallingCount;
    }

    public void incrementMoveCount() {
        setMarshallingCount(getMarshallingCount() + 1);
    }

    public AGotGameModel() {
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

        for (int i = 0; i < 4; i++) {
            Card c = new Card(4);
            c.setName("Ranging Party");
            handP1.add(c);
        }

        for (int i = 0; i < 4; i++) {
            Card c = new Card(4);
            c.setName("Ranging Party");
            handP2.add(c);
        }

        setCurrentPhase(GamePhase.MARSHALLING);
    }

    public void setUpDrawDeck() {

    }

    public void marshallCard(Card c) {
        try {
            if (currentPhase != GamePhase.MARSHALLING) throw new IllegalStateException();
            if (p1.isActive() && c.getCost() <= p1.getGoldValue()) {
                handP1.remove(c);
                charPlayareaP1.add(c);
                p1.refreshGoldValue(p1.getGoldValue() - c.getCost());
            } else if (p2.isActive() && c.getCost() <= p2.getGoldValue()) {
                handP2.remove(c);
                charPlayareaP2.add(c);
                p2.refreshGoldValue(p2.getGoldValue() - c.getCost());
            } else throw new IllegalStateException();
        }
        catch(IllegalStateException e) {
            System.out.println("Not enaught gold");
        }

}

    public Player whoIsActive(){
        if (p1.isActive())  return p1;
        if (p2.isActive()) return p2;
        else throw new IllegalStateException();
    }

    public boolean checkIfAvailableForClick(Card c){

        if (getCurrentPhase() == GamePhase.MARSHALLING) {
            if ((whoIsActive() == p1 && getHandP1().contains(c)) ||
                    (whoIsActive() == p2 && getHandP2().contains(c)))
            return true;
        }
        return false;
    }
    public void finishMarshallingActions() {
        changeActivePlayer();
        marshallingCount++;

        if (getCurrentPhase()== GamePhase.MARSHALLING && marshallingCount >= 2) {
            setCurrentPhase(GamePhase.CHALLENGE);
        }

    }
    public void changeActivePlayer(){
        if (p1.isActive()) {
            p1.setActive(false);
            p2.setActive(true);
        }
        else if (p2.isActive()) {
            p2.setActive(false);
            p1.setActive(true);
        }
        else throw new IllegalStateException();

    }
    public void committeForChallenge(Card c, ChallengeType cht){

        switch (cht){
            case MILLITARY: {
                if (c.getMilitaryIkon() != 0 ) challengeStr.add(c.getStrenght()); break;}
            case INTRIGUE:
            case POWER:
        }

    }
}
