package com.way2learn.service;

public class EmailServiceImpl implements EmailService {

	public void sendMail(String toAddress, String fromAddress, String content) {
		System.out.println("Mail Sent : "+content);

	}

}
