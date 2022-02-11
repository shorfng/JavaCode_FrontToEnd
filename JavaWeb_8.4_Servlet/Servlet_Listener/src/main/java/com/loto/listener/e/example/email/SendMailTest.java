package com.loto.listener.e.example.email;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMailTest {
	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("shorfng@126.com", "测试邮件", "这是一封测试邮件");
	}
}
