package com.example.order_exercise.service;

import com.example.order_exercise.domain.Customer;
import com.example.order_exercise.dto.CreateCustomerDTO;
import com.example.order_exercise.dto.CustomerDTO;
import com.example.order_exercise.mapper.CustomerMapper;
import com.example.order_exercise.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CustomerDTO> findAll() {
       return repository.findAll()
               .stream()
               .map(mapper::toDTO)
               .toList();
    }

    public CustomerDTO findById(String id) {
        return mapper.toDTO(repository.findByEmail(id));
    }

    public CustomerDTO create(CreateCustomerDTO newCustomer) {
        Customer customerToSave = mapper.toDomain(newCustomer);
        return mapper.toDTO(repository.create(customerToSave));
    }
}
