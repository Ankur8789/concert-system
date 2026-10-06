package com.lld.services.serviceimpl;

import com.lld.services.NotificationService;

public class MessageNotification implements NotificationService{

	@Override
	public void notify(String message) {
		System.out.println("Sending to message ......\n"+ message + "\n.........");
	}
    
}
