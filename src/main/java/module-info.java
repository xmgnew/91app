module com.expldfsh.app91 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.expldfsh.app91 to javafx.fxml;
    exports com.expldfsh.app91;
}
