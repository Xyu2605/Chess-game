package chessgame.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WelcomeController {
    
    @FXML
    private Button loginBtn;
    
    @FXML
    public void initialize() {
        // Đây là phương thức chạy khi FXML được load
        System.out.println("Welcome screen loaded!");
    }
    
    @FXML
    private void handleLoginGoogle() {
        System.out.println("Login with Google clicked!");
        // Ở đây bạn sẽ thêm code xử lý đăng nhập Google
        // VD: Mở browser, gọi Google OAuth API, v.v.
    }
}
