package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PartnerDAO;

@RestController
public class PartnerController {

	
	@Autowired
	@Qualifier("partner")
	private PartnerDAO x;
	
	@RequestMapping(value = "/partner/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> getMezzo(@PathVariable("id") int id) {
	
	return ResponseEntity.ok(x.getPartnerById(id));
	}
		
}
