package com.cloudplatform.springshell.music;

import javazoom.jl.player.Player;
import lombok.Data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * @ClassName:SingleMusic
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/6 15:49
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@Data
public class SingleMusic implements Runnable{
    public static final String HTTP="http";
    String musicPath;
    Player player;
    @Override
    public void run() {
        BufferedInputStream stream;
        try {
            if(musicPath.startsWith(HTTP)){
                URL url = new URL(musicPath);
                InputStream fis = url.openStream();
                stream = new BufferedInputStream(fis);
            }else{

                File file = new File(musicPath);
                FileInputStream fis = new FileInputStream(file);
                stream = new BufferedInputStream(fis);
            }
            player = new Player(stream);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
