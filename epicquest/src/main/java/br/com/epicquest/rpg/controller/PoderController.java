package br.com.epicquest.rpg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.PoderDTO;
import br.com.epicquest.rpg.service.PoderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Poder")
public class PoderController {
	@NonNull
	private PoderService _poderService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public PoderDTO createPoder(@RequestBody PoderDTO poder) {
		return _poderService.createPoder(poder);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/createAll")
	public List<PoderDTO> createAllPoder(@RequestBody List<PoderDTO> poderes) {
		return _poderService.createAllPoder(poderes);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getAll")
	public List<PoderDTO> getAllPoderes() {
		return _poderService.getAllPoderes();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{id}")
	public PoderDTO getPoderById(@PathVariable Integer id) {
		return _poderService.getPoderById(id);
	}
}
