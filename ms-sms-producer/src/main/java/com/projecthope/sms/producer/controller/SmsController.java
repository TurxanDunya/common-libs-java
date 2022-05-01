package com.projecthope.sms.producer.controller;

import com.projecthope.sms.producer.dto.request.SmsRequestDto;
import com.projecthope.sms.producer.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/send")
    public void send(@RequestBody SmsRequestDto request) {
        smsService.send(request);
    }

}
