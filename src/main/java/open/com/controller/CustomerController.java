package open.com.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import open.com.bl.CustomerBusiness;

import open.com.model.object.CustomerModel;
import open.com.model.object.CustomerSimpleModel;
import open.com.model.type.Criteria;

@RestController
@Scope("request")
public class CustomerController {
//	private static org.apache.log4j.Logger log = Logger.getLogger(CustomerController.class);
	
	@Autowired
	@Qualifier("CustomerBusiness")
	private CustomerBusiness x;
	
	@RequestMapping(value = "/customers/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody CustomerModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	@RequestMapping(value = "/customers/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody CustomerModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
	// searchByName
	@RequestMapping(value = "/customers" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> searchByName(@RequestParam("nickname") String p) {	
	return ResponseEntity.ok(x.searchCustomerByName(p));
	}
	
	
	// search UNSECURED
	@RequestMapping(value = "/customers/search/unsecured" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity( CustomerModel.class , search , "unsecured"));
	}

	@RequestMapping(value = "/customers/search/unsecuredsimple" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllSimpleFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity( CustomerSimpleModel.class , search , "unsecured"));
	}

}
