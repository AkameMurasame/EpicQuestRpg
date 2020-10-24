package br.com.epicquest.rpg.dto;

import java.io.Serializable;

import br.com.epicquest.rpg.security.UsuarioLogado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserJwtDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private UsuarioLogado User;
	
	private String Token;
}
