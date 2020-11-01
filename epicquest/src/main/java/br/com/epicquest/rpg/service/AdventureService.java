package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.AdventureDTO;

@Component
public interface AdventureService {
	public AdventureDTO createAdventure(AdventureDTO adventureDto);

	public List<AdventureDTO> getAllAdventures();
}
