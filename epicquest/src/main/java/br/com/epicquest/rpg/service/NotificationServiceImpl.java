package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.NotificationDTO;
import br.com.epicquest.rpg.entity.Notification;
import br.com.epicquest.rpg.entity.User;
import br.com.epicquest.rpg.mapper.NotificationMapper;
import br.com.epicquest.rpg.repository.NotificationRepository;
import br.com.epicquest.rpg.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

	@NonNull
	private NotificationRepository _notificationRepository;

	@NonNull
	private UserRepository _userRepository;
	
	@NonNull
	private NotificationMapper _notificationMapper;

	@Override
	public void createNotificacao(Notification notification) {
		_notificationRepository.save(notification);
	}

	public void deleteNotification(long id) {
		_notificationRepository.deleteById(id);
	}

	@Override
	public List<NotificationDTO> getNotificationByUserId(long userId) {
		List<Notification> notifications = _userRepository.findById(userId).get().getNotificationCollection();
		return _notificationMapper.toDtoList(notifications);
	}
}
