package com.zielniok.agot.view;

import com.zielniok.agot.model.AGotGameModel;
import com.zielniok.agot.model.Card;
import com.zielniok.agot.model.GamePhase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;

public class AGotBoardController {

    private static final String PLY1_SELECTOR_PREFIX = "top";
    private static final String PLY2_SELECTOR_PREFIX = "bot";

    private AGotGameModel agotGameModel;

    private Stage stage;

    private ImageRepo imgRepo;

    public void setImgRepo(ImageRepo imgRepo) {
        this.imgRepo = imgRepo;
    }

    public void setAgotGameModel(AGotGameModel p_agotGameModel) {
        this.agotGameModel = p_agotGameModel;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void startClicked() {

        System.out.println("startclicked:" + agotGameModel.hashCode());

        agotGameModel.newGame();

        agotGameModel.setUpDrawDeck();

        ///-------------------------------------
        agotGameModel.drawInitialCards();


        Node button = stage.getScene().getRoot().lookup("#startButton");
        button.setDisable(true);
        List<Card> handP1 = agotGameModel.getHandP1();
        refreshHandCards(handP1, PLY1_SELECTOR_PREFIX);
        List<Card> handP2 = agotGameModel.getHandP2();
        refreshHandCards(handP2, PLY2_SELECTOR_PREFIX);
        refreshPhaseLabel();

        // TODO:mulligan

        //TODO:plot    ----   First player is top player



        //TODO: gold, claim, first player

        //TODO:marshall



        //TODO:challenge
        //TODO:dominance
        //TODO:tax
        //TODO:standing


    }

    private void refreshPhaseLabel() {
        Label phaseLabel = (Label)stage.getScene().getRoot().lookup("#phaseLabel");

        phaseLabel.setText(agotGameModel.getCurrentPhase().toString());
    }

    private void refreshHandCards(List<Card> cards, String pl_prefix) {

        HBox handHBox = (HBox) stage.getScene().getRoot().lookup("#" + pl_prefix + "Hand");
        refreshCardHbox(cards, handHBox);

    }

    private void refreshCharInPlayCards(List<Card> cards, String pl_prefix) {

        HBox handHBox = (HBox) stage.getScene().getRoot().lookup("#" + pl_prefix + "Char");
        refreshCardHbox(cards, handHBox);
    }

    private void refreshLocInPlayCards(List<Card> cards, String pl_prefix) {

        HBox handHBox = (HBox) stage.getScene().getRoot().lookup("#" + pl_prefix + "Loc");
        refreshCardHbox(cards, handHBox);
    }

    private void refreshCardHbox(List<Card> cards, HBox hBox) {

        hBox.getChildren().clear();

        for (Card c: cards) {
            Image i = imgRepo.getImage(c);
            ImageView iv = new ImageView(i);
            iv.setOnMouseClicked(event -> {
                handleCardClick(c);
            });
            iv.setPreserveRatio(true);
            iv.setFitHeight(120);

            hBox.getChildren().add(iv);

        }
    }

    private void handleCardClick(Card c) {

        if (agotGameModel.getCurrentPhase() == GamePhase.MARSHALLING) {
            if ((agotGameModel.whoIsActive() == agotGameModel.getP1() && agotGameModel.getHandP1().contains(c)) ||
                    (agotGameModel.whoIsActive() == agotGameModel.getP2() && agotGameModel.getHandP2().contains(c)))
                {
                    System.out.println(c.getName());
                    agotGameModel.marshallCard(c);
                    refreshCharInPlayCards(agotGameModel.getCharPlayareaP1(), PLY1_SELECTOR_PREFIX);
                    refreshHandCards(agotGameModel.getHandP1(), PLY1_SELECTOR_PREFIX);
                }
        }
    }
}
