package br.com.epicquest.rpg.dto;

import java.io.Serializable;

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
public class RequestAdventureDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String photoUrl;

	private String description;

}
