package com.cloudplatform.examplebusiness.utils;

/**
 * @ClassName:HttpClientTest
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/27 20:41
 * @Version: V1.0
 * @since: JDK 1.java8
 **/

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HttpClientTest {

    private static Logger log = Logger.getLogger(HttpClientTest.class);

    /**
     * 根据URL返回html源码
     * @return
     */
    public static String getContent() {
        String content = "找不到图片";
        //1.生成httpclient，相当于该打开一个浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        //2.创建get请求，相当于在浏览器地址栏输入 网址
        HttpGet request = new HttpGet("https://cn.bing.com/");
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            response = httpClient.execute(request);

            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");
                content = explainHtml(html);
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                log.info("返回状态不是200");
                log.info(EntityUtils.toString(response.getEntity(), "utf-java8"));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return content;
    }

    /**
     * 解析html
     * @param html
     * @return
     */
    public static String explainHtml(String html){
        Document document = Jsoup.parse(html);
        Element postList = document.getElementById("bgDiv");
        Elements footEle = postList.select("#bgDiv div[id='bgImgProgLoad']");
        String url = footEle.attr("data-ultra-definition-src");
        return url;
    }
}