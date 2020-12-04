package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.RaceDTO;
import br.com.epicquest.rpg.entity.Race;

@Mapper(componentModel = "spring")
public interface RaceMapper {
	Race toModel(RaceDTO dto);

	RaceDTO toDto(Race model);

	List<RaceDTO> toDtoList(List<Race> modelList);
}
