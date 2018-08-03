package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PlanDAOImpl;
import com.model.PlanModel;

@RestController
public class PlanController {

	
	@Autowired
	@Qualifier("PlanDAOImpl")
	private PlanDAOImpl x;
	
	@RequestMapping(value = "/plan/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> getPlan(@PathVariable("id") int id) {
	
	return ResponseEntity.ok(x.getEntity(id , PlanModel.class) );
	}
	
	@RequestMapping(value = "/plan/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody PlanModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	
	}
		
}
