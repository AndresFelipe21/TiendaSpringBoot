package com.demo.Tienda.services;

import com.demo.Tienda.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final List<CustomerEntity> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        customers.add(new CustomerEntity(UUID.randomUUID(), "Juan Pérez", "juan.perez@example.com"));
        customers.add(new CustomerEntity(UUID.randomUUID(), "Ana Gómez", "ana.gomez@example.com"));
    }

    public List<CustomerEntity> getAllCustomers() {
        return customers;
    }

    public Optional<CustomerEntity> getCustomerById(UUID id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public UUID createCustomer(CustomerEntity customer) {
        customers.setId(UUID.randomUUID());
        customers.add(customer);
        return customer.getId();
    }


}
