package com.lld.models;

import java.util.HashMap;

import com.lld.services.NotificationService;
import com.lld.services.serviceimpl.EmailNotification;
import com.lld.services.serviceimpl.MessageNotification;

public class NotificationFactory {
    private static HashMap<NotificationType, NotificationService> factory;

    static {
        factory = new HashMap<>();
        factory.put(NotificationType.Email, new EmailNotification());
        factory.put(NotificationType.Message, new MessageNotification());
    }

    public NotificationService getInstance(NotificationType type){
        return factory.get(type);
    }
}
