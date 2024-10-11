package net.warehouse.management.domain.customer;

import net.warehouse.management.domain.common.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseCrudService<CustomerEntity, CustomerRepository> {

    protected CustomerService(CustomerRepository repository) {
        super(repository);
    }

    @Override
    protected Class<CustomerEntity> entityClass() {
        return CustomerEntity.class;
    }
}
