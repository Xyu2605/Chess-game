package chessgame.network;

import chessgame.network.auth.LoginResponse;
import chessgame.network.auth.RegisterResponse;
import chessgame.network.packets.GeneralPackets.FindGameResponse;
import chessgame.network.packets.GeneralPackets.HistoryGameResponse;
import chessgame.network.packets.GeneralPackets.ProfileViewResponse;
import chessgame.network.packets.GeneralPackets.RankingListResponse;

public interface ClientResponse {

    void handleLoginResponse(LoginResponse user);
    void handleRegisterResponse(RegisterResponse response);
    void handleRankingList(RankingListResponse response);
    void handleProfileView(ProfileViewResponse response);
    void handleHistoryGame(HistoryGameResponse response);
    void handleFindGameResponse(FindGameResponse response);
}
