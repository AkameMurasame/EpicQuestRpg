package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.ClasseDTO;
import br.com.epicquest.rpg.mapper.ClasseMapper;
import br.com.epicquest.rpg.repository.ClasseRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {

	@NonNull
	ClasseRepository _classeRepository;

	@NonNull
	ClasseMapper _classeMapper;

	@Override
	public ClasseDTO createClasse(ClasseDTO classe) {
		try {
			return _classeMapper.toDto(_classeRepository.save(_classeMapper.toModel(classe)));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ClasseDTO> getAllClasses() {
		return _classeMapper.toDtoList(_classeRepository.findAll());
	}

	@Override
	public ClasseDTO getClasseById(Integer id) {
		return _classeMapper.toDto(_classeRepository.findById(id).get());
	}

}
