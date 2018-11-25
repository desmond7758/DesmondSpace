package com.dsm.mqdemo.dsmtest;

import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class OrderlyListenner implements MessageListenerOrderly {
    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
        Message message = list.get(0);
        try {
            System.err.println(new String(message.getBody(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
    }
}
