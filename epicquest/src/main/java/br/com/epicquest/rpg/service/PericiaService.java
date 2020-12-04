package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.PericiaDTO;

@Component
public interface PericiaService {
	public PericiaDTO createPericia(PericiaDTO deus);

	public List<PericiaDTO> getAllPericias();

	public PericiaDTO getPericiaById(Integer id);
}
