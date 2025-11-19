package com.epiis.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epiis.app.business.PersonBusiness;
import com.epiis.app.controller.reqresp.RequestPersonInsert;
import com.epiis.app.controller.reqresp.ResponsePersonInsert;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(path = "person")
public class PersonController {
	@Autowired
	private PersonBusiness personBusiness;
	
	@PostMapping(path = "insert", consumes = "multipart/form-data")
	public ResponseEntity<ResponsePersonInsert> insert(@ModelAttribute RequestPersonInsert request) {
		ResponsePersonInsert responsePersonInsert = new ResponsePersonInsert();
		
		this.personBusiness.insert(request.getDto().getPerson());
		
		responsePersonInsert.success();
		responsePersonInsert.listMessage.add("Operación realizada correctamente");
		
		return new ResponseEntity<>(responsePersonInsert, HttpStatus.OK);
	}
}