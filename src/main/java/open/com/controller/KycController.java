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

import open.com.bl.KycBusiness;
import open.com.model.object.CustomerModel;
import open.com.model.object.KycModel;
import open.com.model.type.Criteria;

@RestController
@Scope("request")
public class KycController {

	@Autowired
	@Qualifier("KycBusiness")
	private KycBusiness x;
	
	@RequestMapping(value = "/knowyourcustomer/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , KycModel.class) );
	}
	
	//create
	@RequestMapping(value = "/knowyourcustomer/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody KycModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	@RequestMapping(value = "/knowyourcustomer/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody KycModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
	@RequestMapping(value = "/knowyourcustomer/search" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity( KycModel.class , search , "customer"));
	}
}
