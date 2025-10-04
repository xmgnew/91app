package com.expldfsh.app91;

import java.util.Optional;

import javafx.application.HostServices;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Controller implements EventHandler<ActionEvent> {
    private mainModel model;
    private HostServices hostServices;
    private Stage EZstage, chikenStage, NBStage;

    public Controller(mainModel model, HostServices hostServices) {
        this.model = model;
        this.hostServices = hostServices;
    }

    public void handle(ActionEvent event) {
        Button source = (Button) event.getSource();
        switch (source.getText()) {

            case "+1": model.plusOne(); break;
            
            case "-1": model.minusOne(); break;
            
            case "Click to watch 91": open91Link(); break;

            case "EZ": showEZStage(); break;

            case "Play chiken": showChikenStage(); break;
 
            case "NB Button": showNBStage(); break;
        }
    }
    // show Stage methods below -----------------------

    private void open91Link() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("18+确认");
            alert.setHeaderText(null);
            alert.setContentText("确定要看91吗？（18+）");
            // if confirmed, open Bilibili
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                hostServices.showDocument("https://www.bilibili.com/");
            }
    }

    private void showEZStage() {
        if (EZstage != null) {
            EZstage.toFront();
            EZstage.show();
                return;
        }
        EZstage = new Stage();
        // create label
        Label text = new Label("EZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\nEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZEZ\n");
        text.setStyle("-fx-alignment: center;");
        text.styleProperty().bind(
            Bindings.concat("-fx-font-size: ",
            EZstage.widthProperty().add(EZstage.heightProperty()).divide(20).asString(), ";"));
        Pane pane = new Pane(text);
        pane.setMinSize(300, 300);
        EZstage.setTitle("EZ");
        EZstage.setScene(new Scene(pane));
        EZstage.setFullScreen(true);
        EZstage.show();
    }

    private void showChikenStage() {
        if (chikenStage != null) {
            chikenStage.toFront();
            chikenStage.show();
            return;
        }
        chikenStage = new Stage();

        // init image
        Image icon = new Image(Controller.class.getResource("/img/avat.png").toExternalForm());
        chikenStage.getIcons().add(icon);
        Image image = new Image(Controller.class.getResource("/img/avat.png").toExternalForm());
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
        chikenStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
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

        // show chikenStage
        chikenStage.setTitle("BIG CHICKEN");
        chikenStage.setScene(scene);
        chikenStage.show();
    }

    private void showNBStage() {
        if (NBStage != null) {
            NBStage.toFront();
            NBStage.show();
            return;
        }
        NBStage = new Stage();

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
        NBStage.setTitle("NB tool");
        NBStage.setScene(new Scene(finalPane));
        NBStage.show();

    }

}