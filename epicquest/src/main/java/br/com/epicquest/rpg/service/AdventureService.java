package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.AcceptAdventureRequestDTO;
import br.com.epicquest.rpg.dto.AdventureDTO;
import br.com.epicquest.rpg.security.UsuarioLogado;

@Component
public interface AdventureService {
	public AdventureDTO createAdventure(AdventureDTO adventureDto, UsuarioLogado usuario);

	public List<AdventureDTO> getAllAdventures();

	public void requestAdventure(AdventureDTO adventure, UsuarioLogado user);

	public void acceptRequestAdventure(AcceptAdventureRequestDTO request);

	public AdventureDTO getAdventureById(long adventureId);
}
