package br.com.epicquest.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
