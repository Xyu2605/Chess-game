package chessgame.network;

public class User {
    private int playerId;
    private String playerName;
    private int win, lose, draw;

    public User(int id, String name, int win, int lose, int draw){
        this.playerId = id;
        this.playerName = name;
        this.win = win;
        this.lose = lose;
        this.draw = draw;
    }

    public void setName(String name){
        this.playerName = name;
    }
}
