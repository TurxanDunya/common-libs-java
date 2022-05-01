package com.projecthope.mssmsconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "sms", groupId = "sms-consumers")
    void listener(String data) {
        System.out.println(data);
    }

}
