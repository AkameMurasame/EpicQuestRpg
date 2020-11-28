package br.com.epicquest.rpg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.LoginDTO;
import br.com.epicquest.rpg.dto.UserDTO;
import br.com.epicquest.rpg.dto.UserJwtDTO;
import br.com.epicquest.rpg.service.LoginService;
import br.com.epicquest.rpg.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

	@NonNull
	private LoginService _loginService;

	@NonNull
	private UserService userService;
	
	@PostMapping("/login")
	public UserJwtDTO login(@RequestBody LoginDTO usuarioDto) throws AuthenticationException {
		try {
			return _loginService.login(usuarioDto);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/register")
	public UserDTO registerUser(@RequestBody UserDTO usuario) {
		return userService.registerUser(usuario);
	}
}
