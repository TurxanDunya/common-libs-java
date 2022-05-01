package com.projecthope.sms.producer.dto.request;

import lombok.Data;

@Data
public class SmsRequestDto {

    private String phoneNumber;
    private String message;

}
