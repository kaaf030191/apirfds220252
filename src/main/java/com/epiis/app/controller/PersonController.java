package com.epiis.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epiis.app.controller.reqresp.ResponsePersonInsert;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "person")
public class PersonController {
	@GetMapping(path = "insert")	
	public ResponseEntity<ResponsePersonInsert> insert() {
		ResponsePersonInsert responsePersonInsert = new ResponsePersonInsert();
		
		responsePersonInsert.type = "success";
		responsePersonInsert.message = "Operación realizada correctamente";
		
		return new ResponseEntity<>(responsePersonInsert, HttpStatus.OK);
	}
}