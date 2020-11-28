package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.AnotationDTO;
import br.com.epicquest.rpg.entity.Anotation;

@Mapper(componentModel = "spring")
public interface AnotationMapper {
	Anotation toModel(AnotationDTO dto);

	AnotationDTO toDto(Anotation model);

	List<AnotationDTO> toDtoList(List<Anotation> modelList);
}
