module chessgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens chessgame to javafx.fxml;
    exports chessgame;
}
