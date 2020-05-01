package com.cloudplatform.jdklearndemo.file_download_write;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName:DownLoadUtile
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/24 22:05
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class DownLoadUtile {
    //文件保存地址
    public static String filePath = "D:/myFiles/java.pdf";
    //文件地址
    public static String fileUrl = "http://static.goexploit.com:35214/images/java.pdf";
    //线程数量
    public int threadCount = 5;
    //文件大小
    public static int fileLength = 0;
    public Thread[] threadList;

    public DownLoadUtile() {
        super();
    }

    public DownLoadUtile(int threadCount) {//有参构造
        this.threadCount = threadCount;
        this.threadList = new Thread[threadCount];
    }

    public static void main(String[] args) throws Exception {
        for(int i=0 ;i<1;i++){
            System.out.println("线程数为:"+20);
            DownLoadUtile downLoadUtile = new DownLoadUtile(20);
            downLoadUtile.start();
        }
    }
    public void start() throws Exception{
        long startTime = System.currentTimeMillis();
        URL url = new URL(fileUrl);
        //创建连接对象
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //请求超时时间
        conn.setConnectTimeout(5000);

        int code = conn.getResponseCode();
        System.out.println("服务器响应码" + code);
        //响应正常
        if (code == 200) {
            //获取文件大小
            fileLength = conn.getContentLength();
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            //断点续传的关键
            RandomAccessFile raf = new RandomAccessFile(filePath, "rwd");
            raf.setLength(fileLength);
            //计算每个线程需要下的长度
            int blockSize = fileLength / threadCount;
            for (int i = 0; i < threadCount; i++) {
                //当前线程需要下载的开始位置
                int startSize = i * blockSize;
                //当前线程需要下载的结束位置
                int endSize = (i + 1) * blockSize - 1;
                //最后一个线程的结尾赋值文件大小
                if (1 + i == threadCount) {
                    endSize = fileLength;
                }
                threadList[i] = new DownThread_1(filePath, fileUrl, "线程" + i, startSize, endSize);
                threadList[i].start();
            }

            while (DownUtile.downOver) {
                //间隔0.5秒计算一下
                Thread.sleep(500);
                if (DownUtile.downLength == fileLength) {
                    DownUtile.downOver = false;
                    System.out.println("下载完成：100%");
                    long endTime = System.currentTimeMillis();
                    System.out.println("下载时间为:"+(endTime-startTime)+" ms");
                } else {
                    System.out.println("已经下载了：" + ((int) (float) DownUtile.downLength / (float) fileLength * 100) + "%");
                }
            }

        } else {
            System.out.println("服务器响应失败" + code);
        }
    }
}
