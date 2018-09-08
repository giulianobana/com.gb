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

import open.com.dao.PaymentDAO;
import open.com.model.object.CardModel;
import open.com.model.object.PaymentModel;
import open.com.model.type.Criteria;



@RestController
@Scope("request")
public class PaymentController {

	@Autowired
	@Qualifier("PaymentBusiness")
	private PaymentDAO x;
	
	@RequestMapping(value = "/payments/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , PaymentModel.class) );
	}
	
	//create
	@RequestMapping(value = "/payments/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody PaymentModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	//create
	@RequestMapping(value = "/payments/search" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> list() {	
	return ResponseEntity.ok(x.listAll(PaymentModel.class));
	}
	
	@RequestMapping(value = "/payments/search" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.listAll( PaymentModel.class , search));
	}	
	
	@RequestMapping(value = "/payments/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody PaymentModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
}
