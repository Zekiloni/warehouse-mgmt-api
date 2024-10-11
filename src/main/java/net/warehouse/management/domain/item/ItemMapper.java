package net.warehouse.management.domain.item;

import net.warehouse.management.server.model.Item;
import net.warehouse.management.server.model.ItemCreate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    Item map(ItemEntity item);

    ItemEntity map(ItemCreate itemCreate);

    ItemEntity map(Item item);

    List<Item> map(List<ItemEntity> items);
}
