package br.com.epicquest.rpg.mapper;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.AdventureDTO;
import br.com.epicquest.rpg.entity.Adventure;

@Mapper(componentModel = "spring")
public interface AdventureMapper {

	Adventure toModel(AdventureDTO dto);

	AdventureDTO toDto(Adventure model);
}
