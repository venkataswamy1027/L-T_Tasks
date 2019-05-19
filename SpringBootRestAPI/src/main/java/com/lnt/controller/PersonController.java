package com.lnt.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lnt.model.Person;
import com.lnt.repository.PersonRepository;
import com.lnt.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	@Autowired
	public PersonRepository personRepository;

	/**
	 * This method used to get all persons with their address details
	 * 
	 * @return list of persons
	 */
	@GetMapping("/all")
	public List<Person> getAllPersons() {
		logger.info("Entering into getAllPersons method {}", System.currentTimeMillis());
		try {
			List<Person> persons = personService.getAllPersons();
			logger.debug("persons {}", persons);
			return persons;
		} finally {
			logger.info("Exiting on getAllPersons method {}", System.currentTimeMillis());
		}

	}

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable("id") Integer id) {
		logger.info("Entering into getPersonById method {}", System.currentTimeMillis());
		try {
			logger.debug("id {}", id);
			Optional<Person> persons = personService.getPersonById(id);
			logger.debug("persons {}", persons);
			return persons.get();
		} finally {
			logger.info("Exiting on getPersonById method {}", System.currentTimeMillis());
		}

	}

	@PostMapping("/add")
	public void addPerson(@RequestBody Person person) {
		logger.info("Entering into addPerson method {}", System.currentTimeMillis());
		try {
			logger.debug("person {}", person);
			personService.addPerson(person);
		} finally {
			logger.info("Exiting on addPerson method {}", System.currentTimeMillis());
		}
	}

	@GetMapping
	public List<Person> getAllPersonsBetweenDates(@Param("from") String from, @Param("to") String to) {
		logger.info("Entering into getAllPersonsBetweenDates method {}", System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Person> persons = new ArrayList<>();
		try {
			logger.debug("from {} and to {}", from, to);
			Date fromDate = formatter.parse(from);
			logger.debug("from {} and to {}", from, to);
			Date toDate = formatter.parse(to);
			logger.debug("from {} and to {}", from, to);
			persons = personRepository.findOperations(fromDate, toDate);
			logger.debug("persons {}", persons);
		} catch (ParseException e) {
			logger.error("error due to {}", e.getMessage());
		} finally {
			logger.info("Exiting on getAllPersonsBetweenDates method {}", System.currentTimeMillis());
		}
		return persons;
	}
}
