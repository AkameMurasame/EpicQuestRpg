package br.com.epicquest.rpg.service;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.PlayerDTO;
import br.com.epicquest.rpg.entity.Player;
import br.com.epicquest.rpg.entity.User;
import br.com.epicquest.rpg.mapper.PlayerMapper;
import br.com.epicquest.rpg.mapper.UserMapper;
import br.com.epicquest.rpg.repository.PlayerRepository;
import br.com.epicquest.rpg.security.UsuarioLogado;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

	@NonNull
	private PlayerRepository _playerRepository;

	@NonNull
	private PlayerMapper _playerMapper;

	@NonNull
	private UserMapper _userMapper;

	@Override
	public PlayerDTO createPlayer(PlayerDTO player, UsuarioLogado user) {
		try {
			Player playerEntity = _playerMapper.toModel(player);
			User userLogged = _userMapper.toModelByLoggedUser(user);
			playerEntity.setUserId(userLogged);
			return _playerMapper.toDto(_playerRepository.save(playerEntity));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public PlayerDTO updatePlayer(PlayerDTO player, UsuarioLogado user) {
		try {
			return _playerMapper.toDto(_playerRepository.save(_playerMapper.toModel(player)));
		} catch (Exception e) {
			throw e;
		}
	}

}
