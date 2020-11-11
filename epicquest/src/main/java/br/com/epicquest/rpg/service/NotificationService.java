package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.NotificationDTO;
import br.com.epicquest.rpg.entity.Notification;

@Component
public interface NotificationService {
	public void createNotificacao(Notification notification);

	public void deleteNotification(long id);

	public List<NotificationDTO> getNotificationByUserId(long userId);
}
