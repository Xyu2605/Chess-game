module chessgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires kryo;
    requires kryonet;

    opens chessgame to javafx.fxml;
    exports chessgame;
}
