package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.NotificationDTO;
import br.com.epicquest.rpg.entity.Notification;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
	Notification toModel(NotificationDTO dto);

	NotificationDTO toDto(Notification model);

	List<NotificationDTO> toDtoList(List<Notification> modelList);
}
