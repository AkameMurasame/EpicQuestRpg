package br.com.epicquest.rpg.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.epicquest.rpg.dto.UserDTO;
import br.com.epicquest.rpg.entity.User;
import br.com.epicquest.rpg.security.UsuarioLogado;

@Mapper(componentModel = "spring")
public interface UserMapper {

	User toModel(UserDTO dto);

	UserDTO toDto(User model);

	User toModelByLoggedUser(UsuarioLogado user);

	List<UserDTO> toDtoList(List<User> modelList);
}
