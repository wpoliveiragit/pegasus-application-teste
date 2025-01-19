package br.com.pegasus.restful.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.pegasus.restful.domain.model.ItemModel;
import br.com.pegasus.restful.infra.repository.entity.ItemEntity;

@Mapper
public interface ItemMapper {
	ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

	ItemEntity toEntity(ItemModel model);

	ItemModel toModel(ItemEntity entity);

}
