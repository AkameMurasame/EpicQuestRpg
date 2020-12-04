package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.RaceDTO;
import br.com.epicquest.rpg.mapper.RaceMapper;
import br.com.epicquest.rpg.repository.RaceRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {

	@NonNull
	RaceRepository _raceRepository;

	@NonNull
	RaceMapper _raceMapper;

	@Override
	public RaceDTO createRace(RaceDTO race) {
		try {
			return _raceMapper.toDto(_raceRepository.save(_raceMapper.toModel(race)));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<RaceDTO> getAllRaces() {
		return _raceMapper.toDtoList(_raceRepository.findAll());
	}

	@Override
	public RaceDTO getRaceById(Integer id) {
		return _raceMapper.toDto(_raceRepository.findById(id).get());
	}

}
