package chessgame.network.packets;

import java.util.ArrayList;

import chessgame.logic.Pieces.Piece.Color;

public class GeneralPackets {

    public static class ErrorResponse {
        public String error;
    }

    public static class HistoryGame {
        public String playerName;
        public String opponentName;
        public String result;
        public String moves;
        public long timestamp;
        public long gameDuration;
        public Color side;

        public HistoryGame(String playerName, String opponentName, String results, 
                           String moves, long timestamp, long gameDuration, Color side){

            this.playerName = playerName;
            this.opponentName = opponentName;
            this.result = results;
            this.moves = moves;
            this.timestamp = timestamp;
            this.gameDuration = gameDuration;
            this.side = side;
        }
    }

    public static class HistoryGameRequest {
        public int userId;

        public HistoryGameRequest(){};
        public HistoryGameRequest(int userId){
            this.userId = userId;
        }
        
    }

    public static class HistoryGameResponse {
        public ArrayList<HistoryGame> historyGamesList = new ArrayList<>();
        
        public void addHistoryGameToList(String playerName, String opponentName, String results, String moves, long timestamp, long gameDuration, Color playerColor){
            historyGamesList.add(new HistoryGame(playerName, opponentName, results, moves, timestamp, gameDuration, playerColor));
        }
    }

    public static class UserRank {
        public String userName;
        public int userId;
        public int elo;

        public UserRank(){};

        public UserRank(String userName, int userId, int elo){
            this.userName = userName;
            this.userId = userId;
            this.elo = elo;
        }

    }

    public static class RankingListRequest {
        public int topEloPlayer;

        public RankingListRequest(int topEloPlayer){
            this.topEloPlayer = topEloPlayer;
        }
    }

    public static class RankingListResponse {
        public ArrayList<UserRank> rankList = new ArrayList<>();

        public RankingListResponse(){};
        public void addUserRank(String userName, int userId, int elo){
            rankList.add(new UserRank(userName, userId, elo));
        }
    }

    public static class FindGameRequest {

        public int userId;

        public FindGameRequest(){};
        public FindGameRequest(String userName, int userId){
            this.userId = userId;
        }
    }

    public static class FindGameResponse {

        public boolean found;
        public int tcpPort;
        public int udpPort;

        public FindGameResponse(){};

        public FindGameResponse(boolean found, int tcpPort, int udpPort){
            this.found = found;
            this.tcpPort = tcpPort;
            this.udpPort = udpPort;
        }
    }


    public static class ProfileViewRequest {
        public int userId;

        public ProfileViewRequest(){};
        public ProfileViewRequest(int userId){
            this.userId = userId;
        }
    }

    public static class ProfileViewResponse {
        public String userName;
        public int userId;
        public int elo;
        public int win;
        public int lose;
        public int draw;

        public ProfileViewResponse(){};
        public ProfileViewResponse(String userName, int userId, int elo, int win, int lose, int draw){
            this.userName = userName;
            this.userId = userId;
            this.elo = elo;
            this.win = win;
            this.draw = draw;
        }
    }
    
    public static class MsgPacket {
        public String msg;

        public MsgPacket(){};

        public MsgPacket(String msg){
            this.msg = msg;
        }
    }

    public static class ImageUpLoad{
        public String fileName;
        public byte[] imageData;
    }

    public static class ImageChunk {
        public String fileName;
        public int chunkIndex;     // mảnh thứ bao nhiêu
        public int totalChunks;    // tổng số mảnh
        public byte[] imageData;   // dữ liệu của mảnh ảnh

        public ImageChunk(){};

        public ImageChunk(int totalChunks){
            this.totalChunks = totalChunks;
        }

        public ImageChunk(String fileName, int chunkIndex, int totalChunks, byte[] imageData){
            this.fileName = fileName;
            this.chunkIndex = chunkIndex;
            this.totalChunks = totalChunks;
            this.imageData = imageData;
        }
    }
}
