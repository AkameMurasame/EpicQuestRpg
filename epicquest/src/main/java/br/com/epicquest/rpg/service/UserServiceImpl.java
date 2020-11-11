package br.com.epicquest.rpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.UserDTO;
import br.com.epicquest.rpg.entity.Friendlist;
import br.com.epicquest.rpg.entity.Notification;
import br.com.epicquest.rpg.entity.User;
import br.com.epicquest.rpg.exceptions.AbstractException;
import br.com.epicquest.rpg.mapper.UserMapper;
import br.com.epicquest.rpg.repository.FriendListRepository;
import br.com.epicquest.rpg.repository.UserRepository;
import br.com.epicquest.rpg.security.UsuarioLogado;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository _userRepository;
	@Autowired
	private PasswordEncoder _passwordEncoder;
	@Autowired
	private UserMapper _userMapper;
	@Autowired
	private FriendListRepository _friendListRepository;
	@Autowired
	private NotificationService _notificationService;

	@Override
	public UserDTO registerUser(UserDTO userDto) {
		User user = _userMapper.toModel(userDto);
		if (!_userRepository.existsByUserName(user.getUserName())) {
			user.setPassword(_passwordEncoder.encode(user.getPassword()));
			user = _userRepository.save(user);
			return _userMapper.toDto(user);
		}

		throw new AbstractException("Username is already in use");
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> usuarios = _userRepository.findAll();
		return _userMapper.toDtoList(usuarios);
	}

	@Override
	public UserDTO GetUserById(long userId) {
		return _userMapper.toDto(_userRepository.findById(userId).get());
	}

	@Override
	public void AddFriend(UserDTO friend, UsuarioLogado user) {
		User userLogged = _userMapper.toModelByLoggedUser(user);
		User userFriend = _userMapper.toModel(friend);
		Friendlist friendlist = Friendlist.builder().userId(userLogged).friendId(userFriend).status(0).build();
		_friendListRepository.save(friendlist);
		List<User> userCollection = new ArrayList<User>();
		userCollection.add(userFriend);
		Notification notification = Notification.builder()
				.description(userLogged.getUserName() + "te mandou um pedido de amizade").userCollection(userCollection)
				.build();
		_notificationService.createNotificacao(notification);
	}
}
