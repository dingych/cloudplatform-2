package com.cloudplatform.jdklearndemo.file_download_write;

/**
 * @ClassName:FileDown
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/24 21:50
 * @Version: V1.0
 * @since: JDK 1.8
 **/
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FileDown {
    /**
     * 说明：根据指定URL将文件下载到指定目标位置
     *
     * @param urlPath
     *            下载路径
     * @param downloadDir
     *            文件存放目录
     * @return 返回下载文件
     */
    @SuppressWarnings("finally")
    public static File downloadFile(String urlPath, String downloadDir, String suffix) {
        File file = null;
        try {
            // 统一资源
            URL url = new URL(urlPath);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            //设置超时
            httpURLConnection.setConnectTimeout(1000*5);
            //设置请求方式，默认是GET
            httpURLConnection.setRequestMethod("GET");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开到此 URL引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();
            // 文件大小
            int fileLength = httpURLConnection.getContentLength();

            // 控制台打印文件大小
            System.out.println("您要下载的文件大小为:" + fileLength / (1024 * 1024) + "MB");

            // 建立链接从请求中获取数据
            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
            // 指定文件名称(有需求可以自定义)
            String fileFullName = "aaa."+suffix;
            // 指定存放位置(有需求可以自定义)
            String path = downloadDir + File.separatorChar + fileFullName;
            file = new File(path);
            // 校验文件夹目录是否存在，不存在就创建一个目录
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            OutputStream out = new FileOutputStream(file);
            int size;
            int len = 0;
            byte[] buf = new byte[2048];
            while ((size = bin.read(buf)) != -1) {
                len += size;
                out.write(buf, 0, size);
                // 控制台打印文件下载的百分比情况
                System.out.println("下载了-------> " + len * 100 / fileLength + "%\n");
            }
            // 关闭资源
            bin.close();
            out.close();
            System.out.println("文件下载成功！");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("文件下载失败！");
        } finally {
            return file;

        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 指定资源地址，下载文件测试
//        downloadFile("http://static.goexploit.com:35214/images/log.txt", "D:/myFiles/", "txt");
        downloadFile("http://static.goexploit.com:35214/images/1.jpg", "D:/myFiles/", "jpg");

    }
}