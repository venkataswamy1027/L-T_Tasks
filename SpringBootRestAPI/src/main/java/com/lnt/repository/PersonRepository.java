package com.lnt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lnt.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	@Query("SELECT o FROM Person o WHERE o.createDate BETWEEN :fromDate AND :toDate")
	List<Person> findOperations(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
