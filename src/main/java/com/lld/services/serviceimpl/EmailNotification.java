package com.lld.services.serviceimpl;

import com.lld.services.NotificationService;

public class EmailNotification implements NotificationService{

	@Override
	public void notify(String message) {
		System.out.println("Sending to email ......\n"+ message + "\n.........");
	}
    
}
