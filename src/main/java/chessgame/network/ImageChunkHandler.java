package chessgame.network;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import chessgame.network.packets.GeneralPackets.ImageChunk;


public class ImageChunkHandler extends Listener{

    private final Map<String, ImageChunk> fileMap = new HashMap<>();

    public void receive(Connection connection, Object object){
        if(object instanceof ImageChunk){
            ImageChunk imgChunk = (ImageChunk)object;
            
            String tempDirPath = System.getProperty("java.io.tmpdir");
            File folder = new File (tempDirPath + "avatar");

            if(!folder.exists()){
                folder.mkdirs();
            }

            // Lưu hoặc cập nhật Chunk
            fileMap.putIfAbsent(imgChunk.fileName, new ImageChunk(imgChunk.totalChunks));
        }
    }
}

