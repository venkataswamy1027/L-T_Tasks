package com.lnt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.model.Address;
import com.lnt.repository.AddressRepository;

@Service
public class AddressService {
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

	@Autowired
	public AddressRepository addressRepository;

	/**
	 * @return address list
	 */
	public List<Address> getAllAddress() {
		logger.info("Entering into getAllAddress method {}", System.currentTimeMillis());
		List<Address> address = new ArrayList<>();
		addressRepository.findAll().forEach(address::add);
		logger.debug("address {}", address);
		return address;
	}

	/**
	 * @param id
	 * @return Address
	 */
	public Optional<Address> getAddressById(Integer id) {
		logger.info("Entering into getAddressById method {}", System.currentTimeMillis());
		return addressRepository.findById(id);
	}

}
