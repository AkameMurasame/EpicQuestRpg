package br.com.epicquest.rpg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.epicquest.rpg.dto.ItemDTO;
import br.com.epicquest.rpg.service.ItenService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Item")
public class ItemController {
	@NonNull
	private ItenService _itenService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	@PostMapping("/create")
	public ItemDTO createItem(@RequestBody ItemDTO deus) {
		return _itenService.createIten(deus);
	}
	
	@PostMapping("/createAll")
	public List<ItemDTO> createAllItem(@RequestBody List<ItemDTO> item) {
		return _itenService.createAllIten(item);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getAll")
	public List<ItemDTO> getAllItems() {
		return _itenService.getAllItens();
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	@GetMapping("/getById/{id}")
	public ItemDTO getItemById(@PathVariable long id) {
		return _itenService.getItenById(id);
	}
}
