package com.zielniok.agot.view;

import com.zielniok.agot.model.AGotGameModel;
import com.zielniok.agot.model.Card;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

        List<Card> handP1 = agotGameModel.getHandP1();
        ObservableList handP11 = FXCollections.observableList(handP1);

        refreshHandCards(handP1, PLY1_SELECTOR_PREFIX);

        List<Card> handP2 = agotGameModel.getHandP2();
        refreshHandCards(handP2, PLY2_SELECTOR_PREFIX);

        Node button = stage.getScene().getRoot().lookup("#startButton");
        button.setDisable(true);

        handP2.remove(1);
        refreshHandCards(handP2, PLY2_SELECTOR_PREFIX);

        //-------------------------------------------------------------


        //TODO:mulligan
        //TODO:plot    ----   First player is top player
        //TODO:marshall
        //TODO:challenge
        //TODO:dominance
        //TODO:tax
        //TODO:standing


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
            iv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println(c.getName());
                }
            });
            iv.setPreserveRatio(true);
            iv.setFitHeight(120);

            hBox.getChildren().add(iv);

        }
    }
}
