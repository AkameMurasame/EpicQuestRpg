package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.RaceDTO;

@Component
public interface RaceService {
	public RaceDTO createRace(RaceDTO deus);

	public List<RaceDTO> getAllRaces();

	public RaceDTO getRaceById(Integer id);
}
