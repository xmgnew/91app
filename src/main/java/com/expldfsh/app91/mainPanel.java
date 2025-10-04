package com.expldfsh.app91;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class mainPanel implements Observer {

    private Button nineoneButton = new Button("Click to watch 91");
    private Button EZButton = new Button("EZ");
    private Button chikenButtoon = new Button("Play chiken");
    private Button niubiButton = new Button("NB Button");
    private Button addVal = new Button("+1");
    private Button minusVal = new Button("-1");
    private TextField modelValue = new TextField("0");

    public Scene getScene() {
        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.add(nineoneButton, 0, 0);
        root.add(EZButton, 1, 0);
        root.add(chikenButtoon, 2, 0);
        root.add(niubiButton, 3, 0);
        root.add(addVal, 2, 1);
        root.add(modelValue, 1, 1);
        root.add(minusVal, 0, 1);
        return new Scene(root);
    }

    public void setController(Controller c) {
        nineoneButton.setOnAction(c);
        chikenButtoon.setOnAction(c);
        niubiButton.setOnAction(c);
        EZButton.setOnAction(c);
        addVal.setOnAction(c);
        minusVal.setOnAction(c);
    }

    @Override
    public void update(Observable o, Object arg) {
        mainModel model = (mainModel) o;
        modelValue.setText("" + model.getValue());
    }

}
