package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.DeusDTO;

@Component
public interface DeusService {
	public DeusDTO createDeus(DeusDTO deus);

	public List<DeusDTO> getAllDeuses();

	public DeusDTO getDeusById(Integer id);
}
