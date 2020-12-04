package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.ClasseDTO;

@Component
public interface ClasseService {
	public ClasseDTO createClasse(ClasseDTO deus);

	public List<ClasseDTO> getAllClasses();

	public ClasseDTO getClasseById(Integer id);
}
