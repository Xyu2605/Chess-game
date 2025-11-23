package chessgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("Chess Game");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
