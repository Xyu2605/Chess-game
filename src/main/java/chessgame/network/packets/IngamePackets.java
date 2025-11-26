package chessgame.network.packets;

import chessgame.logic.Pieces.Piece.Color;

public class IngamePackets {

    public static class InitPacket{
        public int userId;
        public InitPacket(){};
        public InitPacket(int id){
            this.userId = id;
        }
    }

    public static class MovePacket{
        public String from;   
        public String to;     
        public String promotion; // "Q" nếu phong cấp, còn lại null

        public MovePacket() {}
        public MovePacket(String from, String to, String promotion) {
            this.from = from;
            this.to = to;
            this.promotion = promotion;
        }
    }

    public static class OpponentInfo{
        public String opponentName;
        public int opponentId;
        public int opponentElo;
        public Color side;

        public OpponentInfo(){};
        public OpponentInfo(String oppnentName, int opponentId, int opponentElo, Color side){
            this.opponentName = oppnentName;
            this.opponentId = opponentId;
            this.opponentElo = opponentElo;
            this.side = side;
        }
    }

    public static class GameStateRespose {
        public int timeWhiteSide;
        public int timeBlackSide;
        public String nextTurn;
        public String lastMove;
    }

    public static class GameEndResponse{
        public double gameState;
        public int totalMoves;
        public int eloChange;

        public GameEndResponse(){};
        public GameEndResponse(double gameState, int totalMoves, int eloChange){
            this.gameState = gameState;
            this.totalMoves = totalMoves;
            this.eloChange = eloChange;
        }
    }

    public static class PingPacket {
        public long timestamp;

        public PingPacket() {}
        public PingPacket(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static class PongPacket {
        public long timestamp;

        public PongPacket() {}
        public PongPacket(long timestamp) {
            this.timestamp = timestamp;
        }
    }

}