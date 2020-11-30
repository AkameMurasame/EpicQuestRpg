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
		Friendlist friendlist = new Friendlist();
		friendlist.setUserId(userLogged);
		friendlist.setFriendId(userFriend);
		friendlist.setStatus(0);
		_friendListRepository.save(friendlist);
		List<User> userCollection = new ArrayList<User>();
		userCollection.add(userFriend);
		Notification notification = new Notification();
		notification.setDescription(userLogged.getUserName() + " te mandou um pedido de amizade");
		notification.setUsers(userCollection);
		notification.setUserId(userLogged);
		_notificationService.createNotificacao(notification);
	}

	public void aceptInvite(UserDTO friend, UsuarioLogado user) {
		Friendlist friendlist = _friendListRepository.getFriendlyRequest(friend.getId(), user.getId());
		friendlist.setStatus(1);
		_friendListRepository.save(friendlist);
		List<User> users = new ArrayList<User>();
		users.add(_userMapper.toModel(friend));
		Notification notification = new Notification();
		notification.setDescription(user.getUsername() + " Aceitou seu pedido de amizade");
		notification.setUsers(users);
		notification.setUserId(_userMapper.toModelByLoggedUser(user));
		_notificationService.createNotificacao(notification);
	}

	public List<UserDTO> getFriends(UsuarioLogado user) {
		List<Friendlist> friends = _friendListRepository.getFriendList(user.getId());
		List<UserDTO> users = new ArrayList<UserDTO>();
		friends.forEach(e -> {
			if (!e.getFriendId().getId().equals(user.getId())) {
				User friend = e.getFriendId();
				users.add(_userMapper.toDto(friend));
			} else {
				User friend = e.getUserId();
				users.add(_userMapper.toDto(friend));
			}
		});
		return users;
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		User userEntity = _userRepository.save(_userMapper.toModel(user));
		return _userMapper.toDto(userEntity);
	}
}
