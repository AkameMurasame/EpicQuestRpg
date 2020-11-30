package br.com.epicquest.rpg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.AcceptAdventureRequestDTO;
import br.com.epicquest.rpg.dto.AdventureDTO;
import br.com.epicquest.rpg.security.CurrentUser;
import br.com.epicquest.rpg.security.UsuarioLogado;
import br.com.epicquest.rpg.service.AdventureService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/adventure")
public class AdventureController {

	@NonNull
	private AdventureService adventureService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public AdventureDTO createAdventure(@RequestBody AdventureDTO adventure, @CurrentUser UsuarioLogado usuario) {
		return adventureService.createAdventure(adventure, usuario);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getAll")
	public List<AdventureDTO> getAllAdventures() {
		return adventureService.getAllAdventures();
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/requestAdventure")
	public void requestAdventure(@RequestBody AdventureDTO adventure, @CurrentUser UsuarioLogado usuario) {
		adventureService.requestAdventure(adventure, usuario);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/acceptAdventureRequest")
	public void requestAdventure(@RequestBody AcceptAdventureRequestDTO request) {
		adventureService.acceptRequestAdventure(request);
	}
}
