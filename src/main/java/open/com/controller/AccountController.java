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

import open.com.dao.AccountDAO;
import open.com.dao.CardDAO;
import open.com.dao.PaymentDAO;
import open.com.model.object.AccountModel;
import open.com.model.object.CardModel;
import open.com.model.object.PaymentModel;
import open.com.model.object.TransactionModel;



@RestController
@Scope("request")
public class AccountController {

	@Autowired
	@Qualifier("AccountBusiness")
	private AccountDAO x;
	
	@Autowired
	@Qualifier("CardBusiness")
	private CardDAO c;
	
	@Autowired
	@Qualifier("PaymentBusiness")
	private PaymentDAO p;

	
	@RequestMapping(value = "/accounts/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , AccountModel.class) );
	}
	
	@RequestMapping(value = "/accounts/{id}/cards" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> listCard(@PathVariable("id") int id) {	
		return ResponseEntity.ok(c.searchEntityByAccount(id, CardModel.class) );
	}
	
	@RequestMapping(value = "/accounts/{id}/payments" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> listPayments(@PathVariable("id") int id) {	
		return ResponseEntity.ok(p.searchEntityByAccount(id, PaymentModel.class) );
	}
	
	@RequestMapping(value = "/accounts/{id}/cashtransactions" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> listCash(@PathVariable("id") int id) {	
		return ResponseEntity.ok(p.searchEntityByAccount(id, TransactionModel.class) );
	}
	
	@RequestMapping(value = "/accounts/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody AccountModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	@RequestMapping(value = "/accounts/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody AccountModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
}
