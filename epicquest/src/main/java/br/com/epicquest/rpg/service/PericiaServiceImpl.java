package br.com.epicquest.rpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.PericiaDTO;
import br.com.epicquest.rpg.mapper.PericiaMapper;
import br.com.epicquest.rpg.repository.PericiaRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PericiaServiceImpl implements PericiaService {

	@NonNull
	PericiaRepository _periciaRepository;

	@NonNull
	PericiaMapper _periciaMapper;

	@Override
	public PericiaDTO createPericia(PericiaDTO pericia) {
		try {
			return _periciaMapper.toDto(_periciaRepository.save(_periciaMapper.toModel(pericia)));
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<PericiaDTO> createAllPericia(List<PericiaDTO> pericias) {
		try {
			List<PericiaDTO> rtPericias = new ArrayList<PericiaDTO>();
			for(PericiaDTO pericia: pericias) {
				PericiaDTO rtPericia = _periciaMapper.toDto(_periciaRepository.save(_periciaMapper.toModel(pericia)));
				rtPericias.add(rtPericia);
			}
			return rtPericias;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<PericiaDTO> getAllPericias() {
		return _periciaMapper.toDtoList(_periciaRepository.findAll());
	}

	@Override
	public PericiaDTO getPericiaById(Integer id) {
		return _periciaMapper.toDto(_periciaRepository.findById(id).get());
	}
}
