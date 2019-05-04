package com.mailsender.mailsender.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody User user){

        mailService.sendEmail(user);
        return "email send";
    }
}
