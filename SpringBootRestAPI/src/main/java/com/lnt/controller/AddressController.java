package com.lnt.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.model.Address;
import com.lnt.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;

	/**
	 * This method used to get all persons with their address details
	 * 
	 * @return list of address
	 */
	@GetMapping("/all")
	public List<Address> getAllAddress() {
		logger.info("Entering into getAllAddress method {}", System.currentTimeMillis());
		try {
			List<Address> address = addressService.getAllAddress();
			logger.debug("address {}", address);
			return address;
		} finally {
			logger.info("Exiting on getAllAddress method {}", System.currentTimeMillis());
		}

	}

	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable("id") Integer id) {
		logger.info("Entering into getAddressById method {}", System.currentTimeMillis());
		try {
			logger.debug("id {}", id);
			Optional<Address> address = addressService.getAddressById(id);
			logger.debug("address {}", address);
			return address.get();
		} finally {
			logger.info("Exiting on getAddressById method {}", System.currentTimeMillis());
		}
	}
}
