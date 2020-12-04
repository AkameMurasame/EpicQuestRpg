package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.DeusDTO;
import br.com.epicquest.rpg.mapper.DeusMapper;
import br.com.epicquest.rpg.repository.DeusRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeusServiceImpl implements DeusService {

	@NonNull
	DeusRepository _deusRepository;

	@NonNull
	DeusMapper _deusMapper;

	@Override
	public DeusDTO createDeus(DeusDTO deus) {
		try {
			return _deusMapper.toDto(_deusRepository.save(_deusMapper.toModel(deus)));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<DeusDTO> getAllDeuses() {
		return _deusMapper.toDtoList(_deusRepository.findAll());
	}

	@Override
	public DeusDTO getDeusById(Integer id) {
		return _deusMapper.toDto(_deusRepository.findById(id).get());
	}

}
