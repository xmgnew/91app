package com.expldfsh.appnineone.subViews;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MarketStage extends Stage {

    private static MarketStage instance;

    private MarketStage() {
        instance = this;

        Label date = new Label("今日日期: 2025年10月23日");
        Button checkInv = new Button("看看CS库存");
        checkInv.setOnAction(e -> {
            TextInputDialog input = new TextInputDialog();
            input.setTitle("登录");
            input.setHeaderText("请输入你的steam用户名:");
            input.setContentText("用户名:");
            input.initOwner(instance);
            Optional<String> res = input.showAndWait();
            if (!res.isPresent()) return;
            String username = res.get().trim();
            if (username.isEmpty()) return;

            Stage progressStage = new Stage();
            progressStage.setWidth(300);
            progressStage.setHeight(200);
            progressStage.initOwner(instance);
            progressStage.initModality(Modality.APPLICATION_MODAL);
            progressStage.setTitle("大进度条");

            Label info = new Label("查询库存中, 请稍后...");
            ProgressBar bar = new ProgressBar(0);
            VBox box = new VBox(10, info, bar);
            box.setStyle("-fx-padding: 16;");
            progressStage.setScene(new Scene(box));
            progressStage.show();

            int durationMs = ThreadLocalRandom.current().nextInt(2000, 5001);
            Timeline tl = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(bar.progressProperty(), 0)),
                    new KeyFrame(Duration.millis(durationMs), new KeyValue(bar.progressProperty(), 1))
            );
            tl.setOnFinished(ev -> {
                progressStage.close();
                long price = ThreadLocalRandom.current().nextLong(1_000_000_001L, Long.MAX_VALUE);
                Alert done = new Alert(Alert.AlertType.INFORMATION);
                done.setWidth(500);
                done.setHeight(200);
                done.initOwner(instance);
                done.setTitle("CS库存小助手");
                done.setHeaderText(null);
                done.setContentText(String.format("尊敬的 %s, 您今日的总盈亏为: -$%s", username, Long.toString(price)));
                done.show();
            });
            tl.play();
        });

        VBox root = new VBox();
        root.getChildren().addAll(date, checkInv);
        instance.setWidth(300);
        instance.setHeight(200);
        instance.setTitle("CS库存小助手");
        instance.setScene(new Scene(root));
    }

    public static synchronized MarketStage getInstance() {
        if (instance == null) {
            instance = new MarketStage();
        }
        return instance;
    }

}
