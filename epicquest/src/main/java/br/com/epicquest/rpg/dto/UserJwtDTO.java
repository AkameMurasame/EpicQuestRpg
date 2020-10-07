package br.com.epicquest.rpg.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserJwtDTO {
	private UserDTO User;
	
	private String Token;
}
