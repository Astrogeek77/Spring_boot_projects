package com.gautam.notify_me.controller;

import com.gautam.notify_me.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public String sendNotification(@RequestParam String type, @RequestParam String message) {
        notificationService.send(type, message);
        return "Request processed for channel: " + type;
    }
}
