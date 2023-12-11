package com.novel.repository;

import com.novel.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, Integer> {

    public List<Address> findAddressByCustomerId(int customerId);

}