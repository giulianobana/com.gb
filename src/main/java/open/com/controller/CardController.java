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

import open.com.bl.CardBusiness;
import open.com.model.object.BankingRelationModel;
import open.com.model.object.CardModel;
import open.com.model.object.CashTransactionModel;
import open.com.model.type.Criteria;



@RestController
@Scope("request")
public class CardController {

	@Autowired
	@Qualifier("CardBusiness")
	private CardBusiness x;
	
	@RequestMapping(value = "/cards/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , CardModel.class) );
	}
	
	//create
	@RequestMapping(value = "/cards/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody CardModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	
	@RequestMapping(value = "/cards/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody CardModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
	@RequestMapping(value = "/cards/search" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity( CardModel.class , search , "account"));
	}	
	
}
