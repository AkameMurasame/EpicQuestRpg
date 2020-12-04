package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.ItemDTO;
import br.com.epicquest.rpg.entity.Iten;

@Mapper(componentModel = "spring")
public interface ItenMapper {
	Iten toModel(ItemDTO dto);

	ItemDTO toDto(Iten model);

	List<ItemDTO> toDtoList(List<Iten> modelList);
}
