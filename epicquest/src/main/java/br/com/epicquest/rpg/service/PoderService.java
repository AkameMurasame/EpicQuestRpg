package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.PoderDTO;

@Component
public interface PoderService {
	public PoderDTO createPoder(PoderDTO deus);

	public List<PoderDTO> getAllPoderes();

	public PoderDTO getPoderById(Integer id);
}
