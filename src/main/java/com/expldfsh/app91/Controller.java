package com.expldfsh.app91;

import java.util.Optional;

import com.expldfsh.app91.subViews.EZStage;
import com.expldfsh.app91.subViews.NBStage;
import com.expldfsh.app91.subViews.chikenStage;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Controller implements EventHandler<ActionEvent> {

    private mainModel model;
    private HostServices hostServices;
    private TextField modelValue;

    public Controller(mainModel model, HostServices hostServices, TextField tf) {
        this.model = model;
        this.hostServices = hostServices;
        this.modelValue = tf;
    }

    public void handle(ActionEvent event) {
        Button source = (Button) event.getSource();
        switch (source.getText()) {

            case "+1":
                try {
                    model.setValue(Integer.parseInt(modelValue.getText()));
                } catch (Exception e) {
                }
                model.plusOne();
                break;

            case "-1":
                try {
                    model.setValue(Integer.parseInt(modelValue.getText()));
                } catch (Exception e) {
                }
                model.minusOne();
                break;

            case "Click to watch 91":
                open91Link();
                break;

            case "EZ":
                EZStage.getInstance().show();
                break;

            case "Play chiken":
                chikenStage.getInstance().show();
                break;

            case "NB Button":
                NBStage.getInstance().show();
                break;
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

}
