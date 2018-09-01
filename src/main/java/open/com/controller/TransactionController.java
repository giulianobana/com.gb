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

import open.com.dao.TransactionDAO;
import open.com.model.TransactionModel;



@RestController
@Scope("request")
public class TransactionController {

	@Autowired
	@Qualifier("TransactionBusiness")
	private TransactionDAO x;
	
	@RequestMapping(value = "/transactions/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , TransactionModel.class) );
	}
	
	//create
	@RequestMapping(value = "/transactions/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody TransactionModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	//create
	@RequestMapping(value = "/transactions/search" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> list() {	
	return ResponseEntity.ok(x.list());
	}
	
	@RequestMapping(value = "/transactions/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody TransactionModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
}
