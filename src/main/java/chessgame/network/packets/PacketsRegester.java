package chessgame.network.packets;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

import chessgame.network.auth.LoginRequest;
import chessgame.network.auth.LoginResponse;
import chessgame.network.auth.RegisterRequest;
import chessgame.network.auth.RegisterResponse;
import chessgame.network.packets.GeneralPackets.ErrorResponse;
import chessgame.network.packets.GeneralPackets.FindGameRequest;
import chessgame.network.packets.GeneralPackets.FindGameResponse;
import chessgame.network.packets.GeneralPackets.HistoryGame;
import chessgame.network.packets.GeneralPackets.ImageChunk;
import chessgame.network.packets.GeneralPackets.ImageUpLoad;
import chessgame.network.packets.GeneralPackets.MsgPacket;
import chessgame.network.packets.GeneralPackets.ProfileViewRequest;
import chessgame.network.packets.GeneralPackets.ProfileViewResponse;
import chessgame.network.packets.GeneralPackets.RankingListRequest;
import chessgame.network.packets.GeneralPackets.RankingListResponse;
import chessgame.network.packets.GeneralPackets.UserRank;
import chessgame.network.packets.IngamePackets.GameEndResponse;
import chessgame.network.packets.IngamePackets.GameStateRespose;
import chessgame.network.packets.IngamePackets.InitPacket;
import chessgame.network.packets.IngamePackets.MovePacket;
import chessgame.network.packets.IngamePackets.OpponentInfo;
import chessgame.network.packets.IngamePackets.PingPacket;
import chessgame.network.packets.IngamePackets.PongPacket;

public class PacketsRegester {
    static public void regester( EndPoint endPoint){
        Kryo kryo = endPoint.getKryo();
        kryo.register(LoginRequest.class);
        kryo.register(LoginResponse.class);
        kryo.register(RegisterRequest.class);
        kryo.register(RegisterResponse.class);
        kryo.register(FindGameRequest.class);
        kryo.register(FindGameResponse.class);
        kryo.register(UserRank.class);
        kryo.register(RankingListRequest.class);
        kryo.register(RankingListResponse.class);
        kryo.register(ErrorResponse.class);
        kryo.register(ProfileViewRequest.class);
        kryo.register(ProfileViewResponse.class);
        kryo.register(ImageChunk.class);
        kryo.register(ImageUpLoad.class);
        kryo.register(java.util.ArrayList.class); 
        kryo.register(byte[].class);
        kryo.register(HistoryGame.class);
        kryo.register(MsgPacket.class);
        kryo.register(InitPacket.class);
        kryo.register(MovePacket.class);
        kryo.register(OpponentInfo.class);
        kryo.register(PingPacket.class);
        kryo.register(PongPacket.class);
        kryo.register(GameStateRespose.class);
        kryo.register(GameEndResponse.class);
    }
}
