package com.wiam.notificationservice.Kafka;


import com.wiam.notificationservice.entities.Notification;
import com.wiam.notificationservice.repositories.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaConsumer {
    NotificationRepository notificationRepository;



    public KafkaConsumer(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @KafkaListener(topics = "acheteur",groupId = "group")
    public void consume(String message){

        notificationRepository.save(Notification.builder().message(message).build());
    }


}