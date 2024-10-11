package net.warehouse.management.domain.item;

import net.warehouse.management.domain.common.BaseCrudService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService extends BaseCrudService<ItemEntity, ItemRepository> {

    protected ItemService(ItemRepository repository) {
        super(repository);
    }

    public Optional<ItemEntity> update(String itemId, ItemEntity itemUpdate) {
        return getRepository().findById(itemId).map(item -> {
            item.setName(itemUpdate.getName());
            item.setPrice(itemUpdate.getPrice());
            item.setQuantity(itemUpdate.getQuantity());
            return getRepository().save(item);
        });
    }

    @Override
    protected Class<ItemEntity> entityClass() {
        return ItemEntity.class;
    }
}
