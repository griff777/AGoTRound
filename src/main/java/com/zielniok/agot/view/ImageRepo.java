package com.zielniok.agot.view;

import com.zielniok.agot.model.Card;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ImageRepo {

    Map<String, Image> map = new HashMap<>();

    public ImageRepo() {
        //map.put("HARRENHAL", new Image("GT11_50.jpg"));
        map.put("Ranging Party", new Image("01132.png"));
    }

    public Image getImage(Card c) {
        return map.get(c.getName());

    }
}
