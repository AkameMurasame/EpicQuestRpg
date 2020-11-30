package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.PlayerDTO;
import br.com.epicquest.rpg.entity.Player;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
	Player toModel(PlayerDTO dto);

	PlayerDTO toDto(Player model);

	List<PlayerDTO> toDtoList(List<Player> modelList);
}
