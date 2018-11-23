package cn.bdqn.gaobingfa.websocket;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//@Configuration
//@EnableWebSocketMessageBroker//支持使用MessageMapping 相当于用requestMapping
//@MessageMapping("/socket")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS();//映射指定的url,指定使用SockJS协议
        registry.addEndpoint("/endpointChat").withSockJS();//注册一个名为/endpointChat的endpoint
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        super.configureMessageBroker(registry);
        //registry.enableSimpleBroker("/topic");//配置消息代理，广播式配置一个/topic消息代理
        registry.enableSimpleBroker("/queue","topic");//一对一增加一个消息代理

    }
}
