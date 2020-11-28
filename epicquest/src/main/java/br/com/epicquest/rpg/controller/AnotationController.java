package br.com.epicquest.rpg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.AnotationDTO;
import br.com.epicquest.rpg.service.AnotationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/anotation")
public class AnotationController {
	
	@NonNull
	private AnotationService _anotationService;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public AnotationDTO createAdventure(@RequestBody AnotationDTO anotation) {
		return _anotationService.createAnotation(anotation);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getByUserId/{userId}")
	public List<AnotationDTO> getUserById(@PathVariable long userId) {
		return _anotationService.GetAnotationsByUserId(userId);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@DeleteMapping("/delete/{anotationId}")
	public void friendlyRequest(@PathVariable long anotationId) {
		_anotationService.deleteAnotation(anotationId);
	}

}
