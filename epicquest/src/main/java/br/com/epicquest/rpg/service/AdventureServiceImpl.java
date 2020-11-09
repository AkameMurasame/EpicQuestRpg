package br.com.epicquest.rpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.AdventureDTO;
import br.com.epicquest.rpg.entity.Adventure;
import br.com.epicquest.rpg.entity.Player;
import br.com.epicquest.rpg.entity.User;
import br.com.epicquest.rpg.exceptions.AbstractException;
import br.com.epicquest.rpg.mapper.AdventureMapper;
import br.com.epicquest.rpg.mapper.UserMapper;
import br.com.epicquest.rpg.repository.AdventureRepository;
import br.com.epicquest.rpg.security.JwtTokenProvider;
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

	public AdventureDTO createAdventure(AdventureDTO adventureDto, UsuarioLogado usuario) {
		try {
			User mestre = _userMapper.toModelByLoggedUser(usuario);
			// Adventure adventure = _adventureMapper.toModel(adventureDto);
			Adventure adventure = _adventureMapper.toModel(adventureDto);
			adventure.setMestre(mestre);
			adventure.setIsSessionActive(1);
			adventure = _adventureRepository.save(adventure);
			return _adventureMapper.toDto(adventure);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<AdventureDTO> getAllAdventures() {
		List<Adventure> aventuras = _adventureRepository.findAll();
		List<AdventureDTO> adventures = new ArrayList<AdventureDTO>();
		for (Adventure adventure : aventuras) {
			adventures.add(_adventureMapper.toDto(adventure));
		}

		return adventures;
	}
}
