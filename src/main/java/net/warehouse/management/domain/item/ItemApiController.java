package net.warehouse.management.domain.item;


import lombok.RequiredArgsConstructor;
import net.warehouse.management.server.api.ItemApi;
import net.warehouse.management.server.model.Item;
import net.warehouse.management.server.model.ItemCreate;
import net.warehouse.management.server.model.ItemUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemApiController implements ItemApi {

    private final ItemMapper itemMapper;
    private final ItemService itemService;

    @Override
    public ResponseEntity<Item> createItem(ItemCreate itemCreate) {
        Item item = itemMapper.map(itemService.create(itemMapper.map(itemCreate)));
        return ResponseEntity.ok(item);
    }

    @Override
    public ResponseEntity<Void> deleteItem(String itemId) {
        itemService.deleteById(itemId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Item>> listItem() {
        List<Item> items = itemMapper.map(itemService.getAll());
        return ResponseEntity.ok(items);
    }

    @Override
    public ResponseEntity<Item> retrieveItem(String itemId) {
        Item item = itemMapper.map(itemService.getByIdOrThrow(itemId));
        return ResponseEntity.ok(item);
    }

    @Override
    public ResponseEntity<Item> updateItem(String itemId, ItemUpdate itemUpdate) {
        return ItemApi.super.updateItem(itemId, itemUpdate);
    }
}
