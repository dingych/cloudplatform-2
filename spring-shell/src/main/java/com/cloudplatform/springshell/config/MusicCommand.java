package com.cloudplatform.springshell.config;


import com.cloudplatform.springshell.music.SingleMusic;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @ClassName:MusicCommand
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/6 15:47
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@ShellComponent
public class MusicCommand {
    public static final String ONLINE_BASE_URL="http://static.goexploit.com/music/";
    public static final String LOCAL_BASE_PATH="D:\\softs\\music\\download\\";
    public static final String NGROK_BASE_PATH="http://ngrok.goexploit.com/download/";
    private static ExecutorService fixedThreadPool = newFixedThreadPool(4);

    @ShellMethod("开始播放音乐:")
    public void start(String musicName) throws UnsupportedEncodingException {
        musicName = NGROK_BASE_PATH+musicName;
        musicName = new String(musicName.getBytes(),"UTF-8");
        SingleMusic singleMusic = new SingleMusic();
//        singleMusic.setMusicPath(LOCAL_BASE_PATH+"hiroko - Promise You.mp3");
//        singleMusic.setMusicPath(ONLINE_BASE_URL+"JS - 你是此生最美的风景.mp3");
        System.out.println(musicName);
        singleMusic.setMusicPath(musicName);
        fixedThreadPool.submit(singleMusic);
    }
}
