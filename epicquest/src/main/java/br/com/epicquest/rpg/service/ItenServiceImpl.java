package br.com.epicquest.rpg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.epicquest.rpg.dto.ItemDTO;
import br.com.epicquest.rpg.mapper.ItenMapper;
import br.com.epicquest.rpg.repository.ItemRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItenServiceImpl implements ItenService {

	@NonNull
	ItemRepository _itenRepository;

	@NonNull
	ItenMapper _itenMapper;

	@Override
	public ItemDTO createIten(ItemDTO iten) {
		try {
			return _itenMapper.toDto(_itenRepository.save(_itenMapper.toModel(iten)));
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ItemDTO> getAllItens() {
		return _itenMapper.toDtoList(_itenRepository.findAll());
	}

	@Override
	public ItemDTO getItenById(long id) {
		return _itenMapper.toDto(_itenRepository.findById(id).get());
	}

}
