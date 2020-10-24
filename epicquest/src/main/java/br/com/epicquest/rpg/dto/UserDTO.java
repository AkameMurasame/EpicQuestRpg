package br.com.epicquest.rpg.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "UserName is required")
	private String userName;

	@NotEmpty(message = "FullName is required")
	private String fullName;
	
	@NotEmpty(message = "Description is required")
	private String description;
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@JsonIgnore
	@NotEmpty(message = "UserName is required")
	private String password;
	
	@JsonIgnore
	private String confirmPassword;
}