package com.cloudplatform.springshell.music;

/**
 * @ClassName:MusicPlayer
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/6 15:34
 * @Version: V1.0
 * @since: JDK 1.8
 **/

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * Java 播放音频
 * @ClassName: MusicPlayer
 * @Description: TODO
 * @author: hyacinth
 * @date: 2020年3月5日 上午12:10:53
 * @Copyright: hyacinth
 */
public class MusicPlayer {

    private static ExecutorService fixedThreadPool = newFixedThreadPool(4);

    public static void main(String[] args) {
        SingleMusic singleMusic = new SingleMusic();
        singleMusic.setMusicPath("http://static.goexploit.com/music/JS - 你是此生最美的风景.mp3");
        fixedThreadPool.submit(singleMusic);
    }
}