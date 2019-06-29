package com.project.patientmanagementsystem.Twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/sms")
public class twilioController {


    private final TwilioService twilioService;

    @Autowired
    public twilioController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping
    public void  sendSms(@Valid @RequestBody SmsRequest smsRequest){
        twilioService.sendSms(smsRequest);
    }

}
