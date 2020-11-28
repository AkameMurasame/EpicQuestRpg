package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.AnotationDTO;

@Component
public interface AnotationService {

	AnotationDTO createAnotation(AnotationDTO anotation);

	List<AnotationDTO> GetAnotationsByUserId(long userId);

	void deleteAnotation(long anotationId);
}
