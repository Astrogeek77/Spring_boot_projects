package com.gautam.notify_me.notification;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("📧 Sending EMAIL: " + message);
    }
}
