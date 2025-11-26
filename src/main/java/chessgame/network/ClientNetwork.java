package chessgame.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import chessgame.network.auth.LoginRequest;
import chessgame.network.auth.LoginResponse;
import chessgame.network.auth.RegisterRequest;
import chessgame.network.auth.RegisterResponse;
import chessgame.network.packets.GeneralPackets.FindGameResponse;

public class ClientNetwork {
    private Client client;
    private int timeout;
    private int tcpPort;
    private int udpPort;
    private String serverAddress;
    private boolean isConnected = false;
    private ClientResponse  clientResponse;

    public ClientNetwork(int timeout, int tcpPort, int udpPort, String serverAddress){
        this.timeout = timeout;
        this.tcpPort = tcpPort;
        this.udpPort = udpPort;
        this.serverAddress = serverAddress;
        client = new Client(1024 * 1024, 1024*1024);
    }

    public void setUiResponseHandler(ClientResponse clientResponse){
        this.clientResponse = clientResponse;
    }

    public void connectToServer() throws IOException{
        isConnected = false;
        client.start();

        client.addListener(new Listener(){
            public void connected(Connection connection){
                isConnected = true;
            }

            public void received(Connection connection, Object object){
                if(object instanceof LoginResponse){
                    LoginResponse response = (LoginResponse)object;
                    clientResponse.handleLoginResponse(response);
                }

                if(object instanceof RegisterResponse){
                    RegisterResponse response = (RegisterResponse)object;
                    clientResponse.handleRegisterResponse(response);
                }

                if(object instanceof FindGameResponse) {
                    FindGameResponse response = (FindGameResponse)object;
                    clientResponse.handleFindGameResponse(response);
                }
            }
            
            public void sendRequest(Object object){
                                                                                     
                if(object instanceof LoginRequest){
                    client.sendTCP((LoginRequest)object);
                }

                if(object instanceof RegisterRequest){
                    client.sendTCP((RegisterRequest)object);
                }

                if(object instanceof FindGameResponse){
                    client.sendTCP((FindGameResponse)object);
                }

            }
        });


        client.addListener(new Listener());
    }
}
