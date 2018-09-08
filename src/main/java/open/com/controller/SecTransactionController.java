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

import open.com.dao.SecTransactionDAO;
import open.com.model.object.CashTransactionModel;
import open.com.model.object.SecTransactionModel;
import open.com.model.type.Criteria;



@RestController
@Scope("request")
public class SecTransactionController {

	@Autowired
	@Qualifier("SecTransactionBusiness")
	private SecTransactionDAO x;
	
	@RequestMapping(value = "/sectransactions/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , SecTransactionModel.class) );
	}
	
	//create
	@RequestMapping(value = "/sectransactions/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody SecTransactionModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	//create
	@RequestMapping(value = "/sectransactions/search" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> list() {	
	return ResponseEntity.ok(x.listAll(SecTransactionModel.class));
	}
	
	@RequestMapping(value = "/sectransactions/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody SecTransactionModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
	@RequestMapping(value = "/sectransactions/search" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.listAll( SecTransactionModel.class , search));
	}	
}
