package com.wiam.notificationservice.repositories;

import com.wiam.notificationservice.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
