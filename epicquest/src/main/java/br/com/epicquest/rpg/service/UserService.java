package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.UserDTO;
import br.com.epicquest.rpg.security.UsuarioLogado;

@Component
public interface UserService {
	public UserDTO registerUser(UserDTO usuarioDto);

	public List<UserDTO> getAllUsers();

	public UserDTO GetUserById(long userId);

	public void AddFriend(UserDTO friend, UsuarioLogado user);

	public void aceptInvite(UserDTO friend, UsuarioLogado user);

	public List<UserDTO> getFriends(UsuarioLogado user);
}
