package com.cloudplatform.examplebusiness.utils;

/**
 * @ClassName:DownloadPicFromUrl
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/27 21:12
 * @Version: V1.0
 * @since: JDK 1.java8
 **/
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadPicFromUrl {
    /**
     * 指定URL下载图片到本地，并返回本地路径
     * @return
     */
    public static String getPath() {
        String windowUrl = "E:/picture/";
//        String centosUrl = "/usr/henry/dev/sms/pic/";
        String url = "https://cn.bing.com/"+HttpClientTest.getContent();
        String path=windowUrl+System.currentTimeMillis()+".jpg";
        downloadPicture(url,path);
        return path;
    }
    public static void main(String[] args) {
        String url = "https://cn.bing.com/th?id=OHR.CharlestonAzaleas_ZH-CN3924268565_UHD.jpg";
        String path="/usr/henry/dev/sms/pic/"+System.currentTimeMillis()+".jpg";
        downloadPicture(url,path);
    }

    /**
     * 链接url下载图片
     * @param urlList
     * @param path
     */
    private static void downloadPicture(String urlList,String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(buffer);//返回Base64编码过的字节数组字符串
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}