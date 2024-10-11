package net.warehouse.management.domain.customer;

import lombok.RequiredArgsConstructor;
import net.warehouse.management.server.api.CustomerApi;
import net.warehouse.management.server.model.Customer;
import net.warehouse.management.server.model.CustomerCreate;
import net.warehouse.management.server.model.CustomerUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerApiController implements CustomerApi {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @Override
    public ResponseEntity<Customer> createCustomer(CustomerCreate customerCreate) {
        Customer customer = customerMapper.map(customerService.create(customerMapper.map(customerCreate)));
        return ResponseEntity.ok(customer);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(String customerId) {
        customerService.deleteById(customerId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomer() {
        List<Customer> customers = customerMapper.map(customerService.getAll());
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity<Customer> retrieveCustomer(String customerId) {
        Customer customer = customerMapper.map(customerService.getByIdOrThrow(customerId));
        return ResponseEntity.ok(customer);
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(String customerId, CustomerUpdate customerUpdate) {
        return CustomerApi.super.updateCustomer(customerId, customerUpdate);
    }
}
