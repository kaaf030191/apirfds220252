package com.epiis.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "person")
public class PersonController {
	@GetMapping(path = "insert")	
	public ResponseEntity<String> insert() {
		return new ResponseEntity<>("Hola qué tal?", HttpStatus.OK);
	}
}