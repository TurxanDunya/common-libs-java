package com.projecthope.sms.producer.service;

import com.projecthope.sms.producer.dto.request.SmsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.projecthope.sms.producer.config.properties.ApplicationConstants.SMS_TOPIC;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final KafkaTemplate<String, SmsRequestDto> kafkaTemplate;

    public void send(SmsRequestDto request) {
        kafkaTemplate.send(SMS_TOPIC, request);
    }

}
