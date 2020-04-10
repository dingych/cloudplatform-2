package com.cloudsplatform.springbootwebsocket.handler;

import com.cloudsplatform.springbootwebsocket.commons.JacksonUtil;
import com.cloudsplatform.springbootwebsocket.model.WsParam;
import com.cloudsplatform.springbootwebsocket.model.WsResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *@description: SocketHandler
 *@author: WuDG
 *@time: 2020/4/10 23:13
 *
 */
@Component
public class SocketHandler extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String HEART_BREAK = "hb";

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        ReentrantLock lock = new ReentrantLock();
        logger.info("=============handleTextMessage start=============");
        // 将消息进行转化，因为是消息是json数据，可能里面包含了发送给某个人的信息，所以需要用json相关的工具类处理之后再封装成TextMessage，
        // 我这儿并没有做处理，消息的封装格式一般有{from:xxxx,to:xxxxx,msg:xxxxx}，来自哪里，发送给谁，什么消息等等
        String msg = message.getPayload();
        if(HEART_BREAK.equals(msg)){
            logger.info("=============心跳检测=============");
        }
        logger.info("消息 -- > " + msg);
        WsResponse<String> response = new WsResponse<>();
        response.setResult("hello list");
        lock.lock();
        sendMessageToUser(session, new TextMessage(JacksonUtil.bean2Json(response)));
        lock.unlock();
        // 给所有用户群发消息
        sendMessagesToUsers(message);
        // 给指定用户群发消息
        //sendMessageToUser(userId, msg);
        logger.info("=============handleTextMessage end=============");
    }



    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connected ... " + session.getId());
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        sessions.remove(session);
        logger.info(String.format("Session %s closed because of %s", session.getId(), status.getReason()));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        logger.error("error occured at sender " + session, throwable);
    }

    /**
     * 给所有的用户发送消息
     */
    public void sendMessagesToUsers(TextMessage message) {
        for (WebSocketSession user : sessions) {
            try {
                // isOpen()在线就发送
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送消息给指定的用户
     */
    private void sendMessageToUser(WebSocketSession user, TextMessage message) {
        try {
            // 在线就发送
            if (user.isOpen()) {
                user.sendMessage(message);
            }
        } catch (IOException e) {
           logger.error("发送消息给指定的用户出错", e);
        }
    }
}
