package net.warehouse.management.domain.order;

import lombok.RequiredArgsConstructor;
import net.warehouse.management.server.api.OrderApi;
import net.warehouse.management.server.model.Order;
import net.warehouse.management.server.model.OrderCreate;
import net.warehouse.management.server.model.OrderUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController implements OrderApi {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    public ResponseEntity<Order> createOrder(OrderCreate orderCreate) {
        return OrderApi.super.createOrder(orderCreate);
    }

    @Override
    public ResponseEntity<Void> deleteOrder(String orderId) {
        return OrderApi.super.deleteOrder(orderId);
    }

    @Override
    public ResponseEntity<List<Order>> listOrder() {
        return OrderApi.super.listOrder();
    }

    @Override
    public ResponseEntity<Order> retrieveOrder(String orderId) {
        Order order = orderMapper.map(orderService.getByIdOrThrow(orderId));
        return ResponseEntity.ok(order);
    }

    @Override
    public ResponseEntity<Order> updateOrder(String orderId, OrderUpdate orderUpdate) {
        return OrderApi.super.updateOrder(orderId, orderUpdate);
    }
}
