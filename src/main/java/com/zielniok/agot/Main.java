package com.zielniok.agot;

import com.zielniok.agot.model.AGotGameModel;
import com.zielniok.agot.view.AGotBoardController;
import com.zielniok.agot.view.ImageRepo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    AGotGameModel gameModel;
    ImageRepo imgRepo;

    @Override
    public void start(Stage primaryStage) throws Exception{


        gameModel = new AGotGameModel();
        imgRepo = new ImageRepo();

        initRootLayout(primaryStage);

    }

    private void initRootLayout(Stage primaryStage) throws java.io.IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/AGotBoard.fxml"));
        Parent root = loader.load();

        AGotBoardController controller = loader.getController();
        controller.setAgotGameModel(gameModel);
        controller.setImgRepo(imgRepo);
        controller.setStage(primaryStage);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
