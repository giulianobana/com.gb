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

import open.com.dao.CashTransactionDAO;
import open.com.model.object.TransactionModel;



@RestController
@Scope("request")
public class CashTransactionController {

	@Autowired
	@Qualifier("CashTransactionBusiness")
	private CashTransactionDAO x;
	
	@RequestMapping(value = "/cashtransactions/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , TransactionModel.class) );
	}
	
	//create
	@RequestMapping(value = "/cashtransactions/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody TransactionModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	//create
	@RequestMapping(value = "/cashtransactions/search" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> list() {	
	return ResponseEntity.ok(x.listAll(TransactionModel.class));
	}
	
	@RequestMapping(value = "/cashtransactions/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody TransactionModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
}
