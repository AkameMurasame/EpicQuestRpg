package br.com.epicquest.rpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.AcceptAdventureRequestDTO;
import br.com.epicquest.rpg.dto.AdventureDTO;
import br.com.epicquest.rpg.entity.Adventure;
import br.com.epicquest.rpg.entity.Notification;
import br.com.epicquest.rpg.entity.User;
import br.com.epicquest.rpg.mapper.AdventureMapper;
import br.com.epicquest.rpg.mapper.UserMapper;
import br.com.epicquest.rpg.repository.AdventureRepository;
import br.com.epicquest.rpg.security.UsuarioLogado;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdventureServiceImpl implements AdventureService {

	@NonNull
	private AdventureRepository _adventureRepository;
	@NonNull
	private AdventureMapper _adventureMapper;
	@NonNull
	private UserMapper _userMapper;
	@NonNull
	private NotificationService _notificationService;

	public AdventureDTO createAdventure(AdventureDTO adventureDto, UsuarioLogado usuario) {
		try {
			User mestre = _userMapper.toModelByLoggedUser(usuario);
			Adventure adventure = _adventureMapper.toModel(adventureDto);
			adventure.setMestre(mestre);
			adventure.setIsSessionActive(1);
			adventure = _adventureRepository.save(adventure);
			return _adventureMapper.toDto(adventure);
		} catch (Exception e) {
			throw e;
		}
	}

	public AdventureDTO getAdventureById(long adventureId) {
		try {
			Adventure adventure = _adventureRepository.findById(adventureId).get();
			return _adventureMapper.toDto(adventure);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<AdventureDTO> getAllAdventures() {
		try {
			List<Adventure> aventuras = _adventureRepository.findAll();
			List<AdventureDTO> adventures = new ArrayList<AdventureDTO>();
			for (Adventure adventure : aventuras) {
				adventures.add(_adventureMapper.toDto(adventure));
			}

			return adventures;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void requestAdventure(AdventureDTO adventure, UsuarioLogado user) {
		try {
			Adventure adventureEntity = _adventureRepository.findById(adventure.getId()).get();
			List<User> users = new ArrayList<User>();
			users.add(adventureEntity.getMestre());
			Notification notification = new Notification();
			notification.setDescription(user.getUsername() + "quer participar da aventura" + adventureEntity.getName());
			notification.setUsers(users);
			notification.setAdventureId(adventureEntity);
			notification.setUserId(_userMapper.toModelByLoggedUser(user));
			_notificationService.createNotificacao(notification);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void acceptRequestAdventure(AcceptAdventureRequestDTO request) {
		Adventure adventureEntity = _adventureRepository.findById(request.getAdventure().getId()).get();
		User user = _userMapper.toModel(request.getUser());
		adventureEntity.getUsers().add(user);
		_adventureRepository.save(adventureEntity);
		List<User> users = new ArrayList<User>();
		users.add(user);
		Notification notification = new Notification();
		notification.setDescription("Você foi aceito na aventura " + adventureEntity.getName());
		notification.setUsers(users);
		notification.setAdventureId(adventureEntity);
		notification.setUserId(adventureEntity.getMestre());
		_notificationService.createNotificacao(notification);
	}
}
