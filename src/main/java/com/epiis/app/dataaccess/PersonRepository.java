package com.epiis.app.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epiis.app.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String> {}
