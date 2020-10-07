package br.com.epicquest.rpg.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	@NotBlank(message = "UserName is required")
	private String userName;

	@NotBlank(message = "UserName is required")
	private String userPassword;
}
