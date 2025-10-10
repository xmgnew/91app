package com.expldfsh.app91.subViews;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class chikenStage extends Stage {

    private static chikenStage instance;

    private chikenStage() {
        instance = this;
        // init image
        Image icon = new Image(chikenStage.class.getResource("/img/avat.png").toExternalForm());
        instance.getIcons().add(icon);
        Image image = new Image(chikenStage.class.getResource("/img/avat.png").toExternalForm());
        ImageView imageview = new ImageView(image);
        imageview.setFitWidth(100);
        imageview.setFitHeight(100);
        imageview.setLayoutX(200);
        imageview.setLayoutY(200);

        // add image Pane
        Pane imagePane = new Pane();
        imagePane.getChildren().add(imageview);
        imagePane.setMinSize(600, 600);

        // initialize keyboard listner
        instance.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if ("W".equals(event.getCode().getName())) {
                imageview.setLayoutY(imageview.getLayoutY() - 10);
            }
            if ("S".equals(event.getCode().getName())) {
                imageview.setLayoutY(imageview.getLayoutY() + 10);
            }
            if ("A".equals(event.getCode().getName())) {
                imageview.setLayoutX(imageview.getLayoutX() - 10);
            }
            if ("D".equals(event.getCode().getName())) {
                imageview.setLayoutX(imageview.getLayoutX() + 10);
            }
        });

        // add instruction label Pane
        Label instructionLabel = new Label("\tUse W, A, S, D to move the chiken");
        Pane instructionPane = new Pane(instructionLabel);

        // create & set up final root scene
        StackPane root = new StackPane();
        root.getChildren().add(instructionPane);
        root.getChildren().add(imagePane);
        Scene scene = new Scene(root);

        // show instance
        instance.setTitle("BIG CHICKEN");
        instance.setScene(scene);
    }

    public static synchronized chikenStage getInstance() {
        if (instance == null) {
            instance = new chikenStage();
        }
        return instance;
    }
    
}
