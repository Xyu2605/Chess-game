package chessgame.network.auth;

public class RegisterRequest {
    private String userName;
    private String email;
    private String passWord;

    public RegisterRequest() {}

    public RegisterRequest(String userName, String email, String passWord) {
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
