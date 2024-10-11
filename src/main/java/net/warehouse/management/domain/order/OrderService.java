package net.warehouse.management.domain.order;

import net.warehouse.management.domain.common.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseCrudService<OrderEntity, OrderRepository> {

    protected OrderService(OrderRepository repository) {
        super(repository);
    }

    @Override
    protected Class<OrderEntity> entityClass() {
        return OrderEntity.class;
    }
}
