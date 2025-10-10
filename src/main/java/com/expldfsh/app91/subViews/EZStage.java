package com.expldfsh.app91.subViews;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public final class EZStage extends Stage {

    private static EZStage instance;

    private EZStage() {
        instance = this;
        // create label
        Label text = new Label("EZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\n");
        text.setStyle("-fx-alignment: center;");
        text.styleProperty().bind(
            Bindings.concat("-fx-font-size: ",
            instance.widthProperty().add(instance.heightProperty()).divide(20).asString(), ";"));
        Pane pane = new Pane(text);
        pane.setMinSize(300, 300);
        instance.setTitle("EZ");
        instance.setScene(new Scene(pane));
        instance.setFullScreen(true);
    }

    public static synchronized EZStage getInstance(){
        if (instance == null) {
            instance = new EZStage();
        }
        return instance;
    }
}
