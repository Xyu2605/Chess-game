package chessgame.network;

public class User {
    private int playerId;
    private String playerName;
    private int win, lose, draw;
    private int elo;

    public User(int id, String name){
        this.playerId = id;
        this.playerName = name;
        this.win = 0;
        this.lose = 0;
        this.draw = 0;
        this.elo = 1000;
    }

    public void setName(String name){
        this.playerName = name;
    }

    public String getName(){
        return this.playerName;
    }

    public int getPlayerId(){
        return this.playerId;
    }

    public void setWin(){
        this.win += 1;
    }

    public int getWin(){
        return this.win;
    }

    public void setLose(){
        this.lose += 1;
    }

    public int getLose(){
        return this.lose;
    }

    public void setDraw(){
        this.draw += 1;
    }

    public int getDraw(){
        return this.draw;
    }

    public void setElo(int oppnentElo){
        this.elo = (oppnentElo + 400*(this.win - this.lose)) / this.win + this.lose + this.draw;
    }
    
    public int getElo(){
        return this.elo;
    }
}
