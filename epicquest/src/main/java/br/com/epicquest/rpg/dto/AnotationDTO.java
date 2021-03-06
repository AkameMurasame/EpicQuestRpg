package br.com.epicquest.rpg.dto;

import java.io.Serializable;
import java.util.List;

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
public class AnotationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String title;
	private String content;
	private long userId;
	private List<Long> sharedUsersIds;
	private AdventureDTO adventureId;
}
