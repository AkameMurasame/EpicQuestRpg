package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.ClasseDTO;
import br.com.epicquest.rpg.entity.Classe;

@Mapper(componentModel = "spring")
public interface ClasseMapper {
	Classe toModel(ClasseDTO dto);

	ClasseDTO toDto(Classe model);

	List<ClasseDTO> toDtoList(List<Classe> modelList);
}
