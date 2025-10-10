package com.expldfsh.app91.subViews;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NBStage extends Stage {
    private static NBStage instance;

    private NBStage() {
        instance = this;
        // init messagebox
        // prompt
        Label promptLabel = new Label("请输入你的名字：");

        // text pane
        TextField textfield = new TextField();

        // button pane
        Button confirmButton = new Button("确定");
        confirmButton.setOnAction(e -> {
            String name = textfield.getText();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setHeaderText(name + " 牛逼!");
            info.setContentText(name + " 牛逼!");
            info.show();
        });

        Button clearButton = new Button("清除");
        clearButton.setOnAction(e -> {
            textfield.clear();
        });

        // set up pane
        HBox textPane = new HBox(5);
        textPane.getChildren().addAll(promptLabel, textfield);

        // final pane
        BorderPane finalPane = new BorderPane();
        finalPane.setTop(textPane);
        finalPane.setLeft(clearButton);
        finalPane.setRight(confirmButton);

        // final scene and stage
        instance.setTitle("NB tool");
        instance.setScene(new Scene(finalPane));
    }

    public static synchronized NBStage getInstance() {
        if (instance == null) {
            instance = new NBStage();
        }
        return instance;
    }
    
}
