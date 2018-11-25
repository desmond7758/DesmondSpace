package com.dsm.mqdemo.dsmtest;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("DsmProducerGroup");
        defaultMQProducer.setNamesrvAddr("127.0.0.1:9876");
        defaultMQProducer.start();
        for (int i = 0; i < 5; i++) {
            Message message = new Message("DsmTopic", "DsmTags",("美好的一天" + i).getBytes());
//            defaultMQProducer.send(message, defaultMQProducer.fetchPublishMessageQueues("DsmTopic").get(0));
            defaultMQProducer.send(message);
        }
        defaultMQProducer.shutdown();

    }
}
