package br.com.epicquest.rpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.AdventureDTO;
import br.com.epicquest.rpg.entity.Adventure;
import br.com.epicquest.rpg.exceptions.AbstractException;
import br.com.epicquest.rpg.mapper.AdventureMapper;
import br.com.epicquest.rpg.repository.AdventureRepository;

@Service
public class AdventureServiceImpl implements AdventureService {

	@Autowired
	private AdventureRepository _adventureRepository;
	@Autowired
	private AdventureMapper _adventureMapper;

	public AdventureDTO createAdventure(AdventureDTO adventureDto) {
		Adventure adventure = _adventureMapper.toModel(adventureDto);
		adventure = _adventureRepository.save(adventure);
		return _adventureMapper.toDto(adventure);
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
