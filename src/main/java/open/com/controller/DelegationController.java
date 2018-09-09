package open.com.controller;

import javax.servlet.http.HttpServletRequest;

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

import open.com.bl.DelegationBusiness;
import open.com.dao.CustomerDAO;
import open.com.dao.DelegationDAO;
import open.com.model.object.CustomerModel;
import open.com.model.object.DelegationModel;
import open.com.model.type.Criteria;

@RestController
@Scope("request")
public class DelegationController {

	@Autowired
	@Qualifier("DelegationBusiness")
	private DelegationBusiness x;
	
	//create
	@RequestMapping(value = "/delegations/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody DelegationModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}

	// searchByName
	@RequestMapping(value = "/delegations/search" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> searchMyDelegate() {	
	return ResponseEntity.ok(x.searchMyDelegation());
	}
	
	
	@RequestMapping(value = "/delegations/{id}" ,  method = RequestMethod.DELETE)
	public  ResponseEntity<Object> delete(@PathVariable("id") int id) {	
	return ResponseEntity.ok(x.deleteEntity(id, DelegationModel.class));
	}		
	
	// search delegated not secured
	@RequestMapping(value = "/delegations/search/unsecured" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity( DelegationModel.class , search , "unsecured"));
	}
}
