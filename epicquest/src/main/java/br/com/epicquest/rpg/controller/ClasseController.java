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

import br.com.epicquest.rpg.dto.ClasseDTO;
import br.com.epicquest.rpg.service.ClasseService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Classe")
public class ClasseController {
	@NonNull
	private ClasseService _classeService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public ClasseDTO createClasse(@RequestBody ClasseDTO deus) {
		return _classeService.createClasse(deus);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getAll")
	public List<ClasseDTO> getAllClasses() {
		return _classeService.getAllClasses();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{id}")
	public ClasseDTO getClassesById(@PathVariable Integer id) {
		return _classeService.getClasseById(id);
	}
}
