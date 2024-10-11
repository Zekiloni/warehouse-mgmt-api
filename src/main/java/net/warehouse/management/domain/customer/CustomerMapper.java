package net.warehouse.management.domain.customer;

import net.warehouse.management.server.model.Customer;
import net.warehouse.management.server.model.CustomerCreate;
import net.warehouse.management.server.model.CustomerUpdate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerEntity map(CustomerCreate customerCreate);

    CustomerEntity map(CustomerUpdate customerUpdate);

    Customer map(CustomerEntity customer);

    List<Customer> map(List<CustomerEntity> customer);
}
