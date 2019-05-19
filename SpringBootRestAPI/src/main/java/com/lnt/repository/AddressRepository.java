package com.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lnt.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
