package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.DeusDTO;
import br.com.epicquest.rpg.entity.Deus;

@Mapper(componentModel = "spring")
public interface DeusMapper {
	Deus toModel(DeusDTO dto);

	DeusDTO toDto(Deus model);

	List<DeusDTO> toDtoList(List<Deus> modelList);
}
