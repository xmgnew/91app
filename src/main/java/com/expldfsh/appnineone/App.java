package com.expldfsh.appnineone;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application implements Observer {

    public static void main(String[] args) {
        launch(args);
    }

    private Button nineoneButton = new Button("Click to watch 91");
    private Button EZButton = new Button("EZ");
    private Button chikenButtoon = new Button("Play chiken");
    private Button niubiButton = new Button("NB Button");
    private Button CSMarket = new Button("CS库存小助手");
    private Button addVal = new Button("+1");
    private Button minusVal = new Button("-1");
    private TextField modelValue = new TextField("0");

    private mainModel model = new mainModel();

    @Override
    public void start(Stage stage) throws IOException {
        model.addObserver(this);
        Controller c = new Controller(model, getHostServices(), modelValue);
        this.setController(c);

        stage.setTitle("91APP");

        HBox counter = new HBox();
        counter.setSpacing(0.91);
        counter.getChildren().addAll(minusVal, modelValue, addVal);

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.add(nineoneButton, 0, 0);
        root.add(EZButton, 1, 0);
        root.add(chikenButtoon, 2, 0);
        root.add(niubiButton, 3, 0);
        root.add(counter, 0, 1);
        root.add(CSMarket, 2, 1);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void update(Observable o, Object arg) {
        mainModel model = (mainModel) o;
        modelValue.setText("" + model.getValue());
    }

    private void setController(Controller c) {
        nineoneButton.setOnAction(c);
        chikenButtoon.setOnAction(c);
        niubiButton.setOnAction(c);
        EZButton.setOnAction(c);
        addVal.setOnAction(c);
        minusVal.setOnAction(c);
        CSMarket.setOnAction(c);
    }

}
