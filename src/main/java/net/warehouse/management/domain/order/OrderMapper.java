package net.warehouse.management.domain.order;

import net.warehouse.management.domain.order.OrderEntity;
import net.warehouse.management.server.model.Order;
import net.warehouse.management.server.model.OrderCreate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    Order map(OrderEntity order);

    OrderEntity map(OrderCreate orderCreate);

    OrderEntity map(Order order);

    List<Order> map(List<OrderEntity> orders);
}
