package com.lnt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.model.Person;
import com.lnt.repository.PersonRepository;

@Service
public class PersonService {
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	public PersonRepository personRepository;

	/**
	 * @return persons list
	 */
	public List<Person> getAllPersons() {
		logger.info("Entering into getAllPersons method {}", System.currentTimeMillis());
		List<Person> persons = new ArrayList<>();
		personRepository.findAll().forEach(persons::add);
		logger.debug("persons {}", persons);
		return persons;
	}

	/**
	 * @param id
	 * @return person
	 */
	public Optional<Person> getPersonById(Integer id) {
		logger.info("Entering into getPersonById method {}", System.currentTimeMillis());
		return personRepository.findById(id);
	}

	/**
	 * @param person
	 */
	public void addPerson(Person person) {
		logger.info("Entering into addPerson method {}", System.currentTimeMillis());
		personRepository.save(person);
	}

	public List<Person> getAllPersonsBetweenDates() {
		// TODO Auto-generated method stub
		return null;
	}
}
