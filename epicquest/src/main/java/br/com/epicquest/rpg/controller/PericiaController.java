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

import br.com.epicquest.rpg.dto.PericiaDTO;
import br.com.epicquest.rpg.service.PericiaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Pericia")
public class PericiaController {
	@NonNull
	private PericiaService _periciaService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public PericiaDTO createPericia(@RequestBody PericiaDTO pericia) {
		return _periciaService.createPericia(pericia);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/createAll")
	public List<PericiaDTO> createAllPericia(@RequestBody List<PericiaDTO> pericias) {
		return _periciaService.createAllPericia(pericias);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getAll")
	public List<PericiaDTO> getAllPericias() {
		return _periciaService.getAllPericias();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{id}")
	public PericiaDTO getPericiaById(@PathVariable Integer id) {
		return _periciaService.getPericiaById(id);
	}
}
