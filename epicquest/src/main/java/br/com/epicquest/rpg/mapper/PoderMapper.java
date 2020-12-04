package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.PoderDTO;
import br.com.epicquest.rpg.entity.Poder;

@Mapper(componentModel = "spring")
public interface PoderMapper {
	Poder toModel(PoderDTO dto);

	PoderDTO toDto(Poder model);

	List<PoderDTO> toDtoList(List<Poder> modelList);
}
