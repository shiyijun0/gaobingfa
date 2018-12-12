package cn.bdqn.gaobingfa.websocket1;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyHandler extends TextWebSocketHandler {
    private static Map<String,WebSocketSession> sessionMap = new HashMap<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        session.sendMessage(new TextMessage(session.getPrincipal().getName()+",你是第" + (sessionMap.size()) + "位访客")); //p2p
        if(message.getPayload().equals("ping")) {
            sendMessage(session.getId(),"pong"+session.getId());
            return;
        }else {
            //处理正常的对话
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionMap.put(session.getId(),session);
        sendMessage(session.getId(), "welcome to connect");
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }

    /**
     * 发送消息
     * 单发
     */
    public static void sendMessage(String username,String message) throws IOException {
        sendMessage(Arrays.asList(username),Arrays.asList(message));
    }

    /**
     *
     * 发送消息
     * 群发
     */
    public static void sendMessage(Collection<String> acceptorList, String message) throws IOException {
        sendMessage(acceptorList, Arrays.asList(message));
    }

    /**
     * 发送消息，p2p 群发都支持
     */
    public static void sendMessage(Collection<String> acceptorList, Collection<String> msgList) throws IOException {
        if (acceptorList != null && msgList != null) {
            for (String acceptor : acceptorList) {
                WebSocketSession session = sessionMap.get(acceptor);
                if (session != null && session.isOpen() ) {
                    for (String msg : msgList) {
                        session.sendMessage(new TextMessage(msg.getBytes()));
                    }
                }
            }
        }
    }

    /**
     群发/推送
     **/
    public static void sendToAll() throws IOException {
        sendMessage(sessionMap.keySet(), " this is from web ");
    }

    //右侧车辆推送
    public static void sendToRight(String json) throws IOException{
        sendMessage(sessionMap.keySet(), json);
    }



}
