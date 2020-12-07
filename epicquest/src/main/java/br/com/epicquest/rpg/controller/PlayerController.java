package br.com.epicquest.rpg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.AdventureDTO;
import br.com.epicquest.rpg.dto.PlayerDTO;
import br.com.epicquest.rpg.security.CurrentUser;
import br.com.epicquest.rpg.security.UsuarioLogado;
import br.com.epicquest.rpg.service.PlayerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/player")
public class PlayerController {

	@NonNull
	private PlayerService _playerService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public PlayerDTO createPlayer(@RequestBody PlayerDTO adventure, @CurrentUser UsuarioLogado usuario) {
		return _playerService.createPlayer(adventure, usuario);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PutMapping("/update")
	public PlayerDTO updatePLayer(@RequestBody PlayerDTO adventure, @CurrentUser UsuarioLogado usuario) {
		return _playerService.updatePlayer(adventure, usuario);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{id}")
	public PlayerDTO getPlayerById(@PathVariable long id) {
		return _playerService.getPlayerById(id);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{id}")
	public List<PlayerDTO> getPlayersByAdventureId(@PathVariable long id) {
		return _playerService.getPlayersByAdventure(id);
	}
}
