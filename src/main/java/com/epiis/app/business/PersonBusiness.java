package com.epiis.app.business;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.epiis.app.dto.DtoPerson;

@Service
public class PersonBusiness {
	public boolean insert(DtoPerson dtoPerson) {
		dtoPerson.setIdPerson(UUID.randomUUID().toString());
		dtoPerson.setCreatedAt(new Date());
		dtoPerson.setUpdatedAt(dtoPerson.getCreatedAt());
		
		return true;
	}
}
