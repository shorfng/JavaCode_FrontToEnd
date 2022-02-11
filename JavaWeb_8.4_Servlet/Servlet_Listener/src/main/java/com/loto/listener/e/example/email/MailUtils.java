package com.loto.listener.e.example.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Author：蓝田_Loto
 * Date：2019-01-05 21:15
 * PageName：MailUtils.java
 * Function：邮箱服务器
 */

public class MailUtils {
    // email:邮件发给谁 subject:主题 emailMsg：邮件的内容
    public static void sendMail(String email, String subject, String emailMsg) throws MessagingException {
        // 1、创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");  // 发邮件的协议
        props.setProperty("mail.host", "localhost");           // 发送邮件的服务器地址
        props.setProperty("mail.smtp.auth", "true");           // 指定验证为true

        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tom", "12345");// 发邮件的账号的验证
            }
        };

        Session session = Session.getInstance(props, auth);

        // 2、创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("tom@itheima32.com")); // 设置发送者
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者
        message.setSubject(subject);// 邮件的主题
        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 3、创建 Transport 用于将邮件发送
        Transport.send(message);
    }
}
