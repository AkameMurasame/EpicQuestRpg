package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.PlayerDTO;
import br.com.epicquest.rpg.security.UsuarioLogado;

@Component
public interface PlayerService {
	public PlayerDTO createPlayer(PlayerDTO player, UsuarioLogado user);

	public PlayerDTO updatePlayer(PlayerDTO player, UsuarioLogado user);

	public PlayerDTO getPlayerById(long id);

	public List<PlayerDTO> getPlayersByAdventure(long adventureId);
}
