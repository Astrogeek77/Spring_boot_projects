package com.gautam.notify_me.service;

import com.gautam.notify_me.factory.NotificationFactory;
import com.gautam.notify_me.notification.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationFactory notificationFactory;

    public NotificationService(NotificationFactory notificationFactory) {
        this.notificationFactory = notificationFactory;
    }

    public void send(String type, String message) {
        // The Factory decides WHAT object to create
        Notification notification = notificationFactory.createNotification(type);

        // The Interface handles HOW to do the work
        notification.notifyUser(message);
    }
}
