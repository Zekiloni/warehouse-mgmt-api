package net.warehouse.management.domain.item;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "items")
public class ItemEntity {
    @Id
    private String id;
    private String name;
    private Integer quantity;
    private double price;
}
