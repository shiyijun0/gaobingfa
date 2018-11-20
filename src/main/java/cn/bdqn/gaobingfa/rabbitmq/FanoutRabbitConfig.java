package cn.bdqn.gaobingfa.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *Fanout Exchange
*
 Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列
 都收到这个消息
 *
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutex");
    }

    @Bean
    FanoutExchange fanout() {
        return new FanoutExchange("fanout");
    }

    @Bean
    FanoutExchange fanoutExchange1() {
        return new FanoutExchange("fanoutExchange1");
    }


    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange1) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange1);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanout) {
        return BindingBuilder.bind(BMessage).to(fanout);
    }


    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
