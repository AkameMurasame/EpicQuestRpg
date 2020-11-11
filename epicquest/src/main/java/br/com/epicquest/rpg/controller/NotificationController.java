package br.com.epicquest.rpg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.NotificationDTO;
import br.com.epicquest.rpg.service.NotificationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification")
public class NotificationController {

	@NonNull
	private NotificationService _notificationService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public void createAdventure() {

	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@GetMapping("/getById/{userId}")
	public List<NotificationDTO> getNotificationByUserId(@PathVariable long userId) {
		return _notificationService.getNotificationByUserId(userId);
	}
}
