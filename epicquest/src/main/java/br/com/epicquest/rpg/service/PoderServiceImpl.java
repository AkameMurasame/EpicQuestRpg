package br.com.epicquest.rpg.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.PoderDTO;
import br.com.epicquest.rpg.mapper.PoderMapper;
import br.com.epicquest.rpg.repository.PoderRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PoderServiceImpl implements PoderService {

	@NonNull
	PoderRepository _poderRepository;

	@NonNull
	PoderMapper _poderMapper;
	
	@Override
	public List<PoderDTO> createAllPoder(List<PoderDTO> poderes) {
		try {
			List<PoderDTO> rtPoderes = new ArrayList<PoderDTO>();
			for(PoderDTO poder: poderes) {
				PoderDTO rtPoder = _poderMapper.toDto(_poderRepository.save(_poderMapper.toModel(poder)));
				rtPoderes.add(rtPoder);
			}
			return rtPoderes;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public PoderDTO createPoder(PoderDTO poder) {
		try {
			return _poderMapper.toDto(_poderRepository.save(_poderMapper.toModel(poder)));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<PoderDTO> getAllPoderes() {
		return _poderMapper.toDtoList(_poderRepository.findAll());
	}

	@Override
	public PoderDTO getPoderById(Integer id) {
		return _poderMapper.toDto(_poderRepository.findById(id).get());
	}

}
