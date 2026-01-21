package com.gautam.notify_me.notification;

public class PushNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("🔔 Sending PUSH NOTIFICATION: " + message);
    }
}
