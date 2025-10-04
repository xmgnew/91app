package com.expldfsh.app91;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private mainModel model = new mainModel();
    private mainPanel mainPanel;
    private Controller controller;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainPanel = new mainPanel();
        model.addObserver(mainPanel);
        controller = new Controller(model, getHostServices());
        mainPanel.setController(controller);

        stage.setTitle("91APP");
        stage.setScene(mainPanel.getScene());
        stage.show();
    }



}