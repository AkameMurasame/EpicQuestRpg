package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.PericiaDTO;
import br.com.epicquest.rpg.entity.Pericia;

@Mapper(componentModel = "spring")
public interface PericiaMapper {
	Pericia toModel(PericiaDTO dto);

	PericiaDTO toDto(Pericia model);

	List<PericiaDTO> toDtoList(List<Pericia> modelList);
}
