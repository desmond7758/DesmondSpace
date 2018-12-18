package com.dsm.mqdemo.dsmtest;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

public class Consumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("DsmConsumerGroup");
        defaultMQPushConsumer.setNamesrvAddr("127.0.0.1:9876");
        defaultMQPushConsumer.subscribe("DsmTopic", "DsmTags");
        // 消费端 设置 集群模式 (默认) 构造器 默认设置集群 这段可以不加
        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 按序
//        defaultMQPushConsumer.registerMessageListener(new OrderlyListenner());
        // 无序
        defaultMQPushConsumer.registerMessageListener(new CurrentlyListener());
        defaultMQPushConsumer.start();
    }
}
