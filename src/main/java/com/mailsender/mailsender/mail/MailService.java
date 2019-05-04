package com.mailsender.mailsender.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(User user) throws MailException {

        String mailTo = user.getMail();
        String name = user.getName();
        String msg = user.getMsg();
        String num = user.getNumber();
        String res = user.getRes();
        Date date = user.getDate();

        String subject = "";
        String message = "";
        String messageToUser="";

        if(res.equalsIgnoreCase("yes")){
            subject = "Invitation Response YES from " + name;
            message = "Dear Mr & Mrs Agrahari\n\nYou have got an invitation response from " + name +
            " who is arriving on: " + date + " and have following message for you \n\n" + msg + "\nDetail:\n" +
                    "Name: " + name +
                    "\nContact Number: " + num+
                    "\nEmail: "+ mailTo +
                    "\nArriving Date: "+ date;
            messageToUser = "Dear " + name +"\n\nThank you for spending your time in providing your response, we have got your wishes and information and we are excited to welcome you on our wedding.\n\n Once again thank you for your time\n\nRegards\nRahul Agrahari";
        }

        else{
            subject = "Invitation Response " + res + " from " + name;
            message = "Dear Mr & Mrs Agrahari \n\n You have got an invitation response from " + name +
                    " who is not coming on you wedding and have following message for you \n\n" + msg+ "\nDetail:\n " +
                    "Name: " + name +
                    "\nContact Number: " + num+
                    "\nEmail: "+ mailTo;
            messageToUser = "Dear " + name +"\n\nThank you for spending your time in providing your response, we have got your wishes and response. It would have been really great if you guys could have made to our wedding .\n\n Once again thank you for your time\n\nRegards\nRahul Agrahari";

        }


        SimpleMailMessage mail = new SimpleMailMessage();
        SimpleMailMessage mail1 = new SimpleMailMessage();
        mail.setTo("agraharr@tcd.ie");
        mail.setSubject(subject);
        mail.setText(message);
        mail1.setTo(mailTo);
        mail1.setSubject("Thank Your Response!!");
        mail1.setText("Dear " + name +"\n\nThank you for spending your time in providing your response, we have got you wishes and information.\n\n Once again thank you for your time\n\nRegards\nRahul Agrahari");

        /*
         * This send() contains an Object of SimpleMailMessage as an Parameter
         */
        javaMailSender.send(mail);
        javaMailSender.send(mail1);
    }

}
