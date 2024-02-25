package com.wiam.notificationservice.web;


import com.wiam.notificationservice.entities.Notification;
import com.wiam.notificationservice.repositories.NotificationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    NotificationRepository notificationRepository;

    public RestController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/notifications")
    public List<Notification> getAll(){
        return notificationRepository.findAll();
    }

    @PutMapping("/notifications/{id}")
    public Notification updateNotification(@PathVariable Integer id){
        Notification n = notificationRepository.findById(id).orElseThrow(()-> new RuntimeException("Notification not found"));
        n.setSeen(true);
        return notificationRepository.save(n);
    }
}
