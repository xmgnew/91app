module com.expldfsh.appnineone {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.expldfsh.appnineone to javafx.fxml;
    exports com.expldfsh.appnineone;
}
