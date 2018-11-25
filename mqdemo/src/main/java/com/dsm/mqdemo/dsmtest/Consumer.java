package com.dsm.mqdemo.dsmtest;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

public class Consumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("DsmConsumerGroup");
        defaultMQPushConsumer.setNamesrvAddr("127.0.0.1:9876");
        defaultMQPushConsumer.subscribe("DsmTopic", "DsmTags");
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 按序
//        defaultMQPushConsumer.registerMessageListener(new OrderlyListenner());
        // 无序
        defaultMQPushConsumer.registerMessageListener(new CurrentlyListener());
        defaultMQPushConsumer.start();
    }
}
