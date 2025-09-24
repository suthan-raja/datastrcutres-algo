package com.data.algo.design.factory;

interface Notification {
    void sendMessage(String message);
}

class EmailNotification implements Notification {
    public void sendMessage(String message) {
        System.out.println("Email Notification");
    }
}

class SmsNotification implements Notification {
    public void sendMessage(String message) {
        System.out.println("Sms Notification");
    }
}

public class NotificationFactory {
    Notification getNotification(String type) {
        if(type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        }
        return new SmsNotification();
    }
}


class NotificationMain {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.getNotification("email");
        notification.sendMessage("Hello mail");
        notification = factory.getNotification("sms");
        notification.sendMessage("Hello SMS");
    }
}