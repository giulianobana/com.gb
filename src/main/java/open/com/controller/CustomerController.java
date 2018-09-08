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

import open.com.dao.AccessDAOImpl;
import open.com.dao.CustomerDAO;
import open.com.dao.KycDAO;
import open.com.model.object.BankingRelationModel;
import open.com.model.object.CustomerModel;
import open.com.model.object.CustomerModelSimplied;
import open.com.model.object.KycModel;
import open.com.model.type.Criteria;
import open.com.model.type.Search;

@RestController
@Scope("request")
public class CustomerController {
//	private static org.apache.log4j.Logger log = Logger.getLogger(CustomerController.class);
	
	@Autowired
	@Qualifier("CustomerBusiness")
	private CustomerDAO x;
	
	
//	@RequestMapping(value = "/customers/{id}" ,  method = RequestMethod.GET)
//	public ResponseEntity<Object> getCustomer(@PathVariable("id") int id) {	
//		 return ResponseEntity.ok(x.getEntity(id , CustomerModel.class) );
//	}
	
	//create
	@RequestMapping(value = "/customers/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody CustomerModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}

	// searchByName
	@RequestMapping(value = "/customers" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> searchByName(@RequestParam("nickname") String p) {	
	return ResponseEntity.ok(x.searchCustomerByName(p));
	}
	
	// searchByName
	@RequestMapping(value = "/customers/all" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> searchAll() {	
	return ResponseEntity.ok(x.listAll( CustomerModelSimplied.class));
	}
	
	// searchByName
	@RequestMapping(value = "/customers/search" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.listAll( CustomerModel.class , search));
	}
	
	@RequestMapping(value = "/customers/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody CustomerModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
				
}
