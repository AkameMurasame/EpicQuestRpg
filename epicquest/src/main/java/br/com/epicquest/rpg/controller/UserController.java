package br.com.epicquest.rpg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.UserDTO;
import br.com.epicquest.rpg.security.CurrentUser;
import br.com.epicquest.rpg.security.UsuarioLogado;
import br.com.epicquest.rpg.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

	@NonNull
	private UserService userService;

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getAll")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@PutMapping("/update")
	public UserDTO updateUser(@RequestBody UserDTO user) {
		return userService.updateUser(user);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{userId}")
	public UserDTO getUserById(@PathVariable long userId) {
		return userService.GetUserById(userId);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/addFriend")
	public void friendlyRequest(@RequestBody UserDTO userFriend, @CurrentUser UsuarioLogado userLogged) {
		userService.AddFriend(userFriend, userLogged);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/aceptInvite")
	public void aceptInvite(@RequestBody UserDTO userFriend, @CurrentUser UsuarioLogado userLogged) {
		userService.aceptInvite(userFriend, userLogged);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getFriends")
	public List<UserDTO> getFriends(@CurrentUser UsuarioLogado userLogged) {
		return userService.getFriends(userLogged);
	}
}
