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

import br.com.epicquest.rpg.dto.RaceDTO;
import br.com.epicquest.rpg.service.RaceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Race")
public class RaceController {
	@NonNull
	private RaceService _raceService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public RaceDTO createItem(@RequestBody RaceDTO race) {
		return _raceService.createRace(race);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getAll")
	public List<RaceDTO> getAllRaces() {
		return _raceService.getAllRaces();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{id}")
	public RaceDTO getRaceById(@PathVariable Integer id) {
		return _raceService.getRaceById(id);
	}
}
