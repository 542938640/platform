package com.taro.platform.listener.direct;import java.util.Map;import org.springframework.amqp.rabbit.annotation.RabbitHandler;import org.springframework.amqp.rabbit.annotation.RabbitListener;import org.springframework.stereotype.Component;/** * @Author : taro * @CreateTime : 2020/8/13 * @Description : **/@Component@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueuepublic class DirectReceiver2 {    @RabbitHandler    public void process(Map testMessage) {        System.out.println("第二个DirectReceiver消费者收到消息  : " + testMessage.toString());    }}