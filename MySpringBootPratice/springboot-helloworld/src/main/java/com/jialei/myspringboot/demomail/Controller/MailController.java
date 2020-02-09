package com.jialei.myspringboot.demomail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Controller
@RequestMapping("mail")
public class MailController {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @RequestMapping("simple")
    public String sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Notification");
        message.setText("Test Email");

        message.setTo("693248540@qq.com");
        message.setFrom("693248540@qq.com");

        mailSender.send(message);
        return "success";
    }

    @RequestMapping("complex")
    public String sendComplexEmail() throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);

        helper.setSubject("Notification");
        helper.setText("<b style='color:red'> Test Email </b>", true);
        helper.setTo("693248540@qq.com");
        helper.setFrom("693248540@qq.com");
        helper.addAttachment("1.jpg", new File("./1.jpg"));

        mailSender.send(mimeMailMessage);
        return "success";
    }


}
