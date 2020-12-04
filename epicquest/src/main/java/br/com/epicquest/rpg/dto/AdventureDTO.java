package br.com.epicquest.rpg.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AdventureDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Photo is required")
	private String photoUrl;

	@NotEmpty(message = "Description is required")
	private String description;

	private UserDTO mestre;
	
	private List<UserDTO> users;

	private List<PlayerDTO> players;
}
