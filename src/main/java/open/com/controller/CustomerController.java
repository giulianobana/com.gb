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

import open.com.dao.CustomerDAO;
import open.com.dao.KycDAO;
import open.com.model.CustomerModel;
import open.com.model.KycModel;

@RestController
@Scope("request")
public class CustomerController {

	@Autowired
	@Qualifier("CustomerBusiness")
	private CustomerDAO x;
	
	@Autowired
	@Qualifier("KycBusiness")
	private KycDAO y;
	
	@RequestMapping(value = "/customers/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> getCustomer(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , CustomerModel.class) );
	}
	
	//create
	@RequestMapping(value = "/customers/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody CustomerModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}

	// searchByName
	@RequestMapping(value = "/customers" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> searchByName(@RequestParam("username") String p) {	
	return ResponseEntity.ok(x.searchCustomerByName(p));
	}
	
	@RequestMapping(value = "/customers/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody CustomerModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
				
	@RequestMapping(value = "/customers/{id}/kyc" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> getKyc(@PathVariable("id") int id) {	
		return ResponseEntity.ok(y.getKycFromCustomer(id) );
	}

}
