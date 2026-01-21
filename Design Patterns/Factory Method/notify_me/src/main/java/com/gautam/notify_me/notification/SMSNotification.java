package com.gautam.notify_me.notification;

public class SMSNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("📱 Sending SMS: " + message);
    }
}
