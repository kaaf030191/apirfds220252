package com.epiis.app.business;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epiis.app.dataaccess.PersonRepository;
import com.epiis.app.dto.DtoPerson;
import com.epiis.app.entity.Person;

@Service
public class PersonBusiness {
	@Autowired
	private PersonRepository personRepository;
	
	public boolean insert(DtoPerson dtoPerson) {
		dtoPerson.setIdPerson(UUID.randomUUID().toString());
		dtoPerson.setCreatedAt(new Date());
		dtoPerson.setUpdatedAt(dtoPerson.getCreatedAt());
		
		Person person = new Person();
		
		person.setIdPerson(dtoPerson.getIdPerson());
		person.setFirstName(dtoPerson.getFirstName());
		person.setSurName(dtoPerson.getSurName());
		person.setDni(dtoPerson.getDni());
		person.setGender(dtoPerson.isGender());
		person.setBirthDate(new java.sql.Date(dtoPerson.getBirthDate().getTime()));
		person.setCreatedAt(new java.sql.Timestamp(dtoPerson.getCreatedAt().getTime()));
		person.setUpdatedAt(new java.sql.Timestamp(dtoPerson.getUpdatedAt().getTime()));
		
		this.personRepository.save(person);
		
		return true;
	}
}
