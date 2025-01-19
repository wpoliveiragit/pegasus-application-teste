package br.com.pegasus.restful.infra.repository.adapter;

import java.util.List;
import java.util.Optional;

import br.com.pegasus.restful.domain.adapter.ItemServicePersistenceAdapter;
import br.com.pegasus.restful.domain.model.ItemModel;
import br.com.pegasus.restful.infra.mapper.ItemMapper;
import br.com.pegasus.restful.infra.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemRepositoryAdapter implements ItemServicePersistenceAdapter {

	private final ItemRepository itemRepository;
	private ItemMapper mapper = ItemMapper.INSTANCE;

	@Override
	public List<ItemModel> findAll() {
		return itemRepository.findAll().stream().map(e -> mapper.toModel(e)).toList();
	}

	@Override
	public Optional<ItemModel> findById(Long id) {
		return itemRepository.findById(id).map(mapper::toModel);
	}

	@Override
	public Optional<ItemModel> findByName(String name) {
		return itemRepository.findByName(name).map(mapper::toModel);
	}

	@Override
	public ItemModel save(ItemModel item) {
		return mapper.toModel(itemRepository.save(mapper.toEntity(item)));
	}

	@Override
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
}
