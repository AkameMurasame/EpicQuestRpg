package br.com.epicquest.rpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.AnotationDTO;
import br.com.epicquest.rpg.entity.Anotation;
import br.com.epicquest.rpg.entity.User;
import br.com.epicquest.rpg.mapper.AnotationMapper;
import br.com.epicquest.rpg.repository.AdventureRepository;
import br.com.epicquest.rpg.repository.AnotationRepository;
import br.com.epicquest.rpg.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnotationServiceImpl implements AnotationService {

	@NonNull
	private UserRepository _userRepository;

	@NonNull
	private AnotationMapper _anotationMapper;

	@NonNull
	private AnotationRepository _anotationRepository;

	@NonNull
	private AdventureRepository _adventureRepository;

	@Override
	public AnotationDTO createAnotation(AnotationDTO anotationDTO) {
		List<User> usuarios = new ArrayList<User>();
		usuarios.add(_userRepository.findById(anotationDTO.getUserId()).get());

		if (!anotationDTO.getSharedUsersIds().isEmpty()) {
			anotationDTO.getSharedUsersIds().forEach(e -> {
				usuarios.add(_userRepository.findById(e).get());
			});
		}

		Anotation anotation = _anotationMapper.toModel(anotationDTO);
		anotation.setUsers(usuarios);
		anotation.setAdventureId(_adventureRepository.findById(anotationDTO.getAdventureId().getId()).get());
		Anotation anotationSaved = _anotationRepository.save(anotation);
		return _anotationMapper.toDto(anotationSaved);
	}

	@Override
	public List<AnotationDTO> GetAnotationsByUserId(long userId) {
		return _anotationMapper.toDtoList(_userRepository.findById(userId).get().getAnotations());
	}

	@Override
	public void deleteAnotation(long anotationId) {
		_anotationRepository.deleteById(anotationId);
	}
}
