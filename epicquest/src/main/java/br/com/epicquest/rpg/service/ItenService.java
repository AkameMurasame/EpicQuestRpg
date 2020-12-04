package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.epicquest.rpg.dto.ItemDTO;

@Component
public interface ItenService {
	public ItemDTO createIten(ItemDTO deus);

	public List<ItemDTO> getAllItens();

	public ItemDTO getItenById(long id);
}
