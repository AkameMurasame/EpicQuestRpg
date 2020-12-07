package br.com.epicquest.rpg.game.websocket.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import br.com.epicquest.rpg.game.websocket.model.Pincel;
import br.com.epicquest.rpg.game.websocket.repository.PlayerRepository;

@Controller
public class WebSoketController {

	private final SimpMessagingTemplate simpMessagingTemplate;
	private final Set<String> connectedUsers;

	public WebSoketController(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
		connectedUsers = new HashSet<>();
	}

	@Autowired
	private PlayerRepository _playerRepository;

	@MessageMapping("/register")
	@SendToUser("/queue/newMember")
	public Set<String> registerUser(Long playerId) {
		// Player player = _playerRepository.findById(playerId).get();
		if (!connectedUsers.contains(playerId.toString())) {
			connectedUsers.add(playerId.toString());
			simpMessagingTemplate.convertAndSend("/topic/newMember", connectedUsers); // 4
			return connectedUsers;
		} else {
			return new HashSet<>();
		}
	}

	/*
	@MessageMapping("/unregister") // 5
	@SendTo("/topic/disconnectedUser")
	public String unregisterUser(String webChatUsername) {
		connectedUsers.remove(webChatUsername);
		return webChatUsername;
	}
	*/

	@MessageMapping("/message") // 6
	public void greeting(Pincel pincel) {
		connectedUsers.forEach(e -> {
			simpMessagingTemplate.convertAndSendToUser(e, "/msg", pincel);
		});
	}
}
