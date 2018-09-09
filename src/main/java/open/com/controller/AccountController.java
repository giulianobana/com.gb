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

import open.com.bl.AccountBusiness;
import open.com.bl.CardBusiness;
import open.com.bl.PaymentBusiness;
import open.com.dao.AccountDAO;
import open.com.model.object.AccountModel;
import open.com.model.object.BankingRelationModel;
import open.com.model.object.CardModel;
import open.com.model.object.PaymentModel;
import open.com.model.object.SecTransactionModel;
import open.com.model.type.Criteria;
import open.com.model.object.CashTransactionModel;



@RestController
@Scope("request")
public class AccountController {

	@Autowired
	@Qualifier("AccountBusiness")
	private AccountBusiness x;
	
	@Autowired
	@Qualifier("CardBusiness")
	private CardBusiness c;
	
	@Autowired
	@Qualifier("PaymentBusiness")
	private PaymentBusiness p;

	
	@RequestMapping(value = "/accounts/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , AccountModel.class) );
	}
	
	
	@RequestMapping(value = "/accounts/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody AccountModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	@RequestMapping(value = "/accounts/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody AccountModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	
//	/*search */ 
	@RequestMapping(value = "/accounts/search" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity(AccountModel.class , search , "bankingrelation"));
	}		
	
	
 /* external entities by account id */
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
		return ResponseEntity.ok(p.searchEntityByAccount(id, CashTransactionModel.class) );
	}

	@RequestMapping(value = "/accounts/{id}/sectransactions" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> listSec(@PathVariable("id") int id) {	
		return ResponseEntity.ok(p.searchEntityByAccount(id, SecTransactionModel.class) );
	}
	
	@RequestMapping(value = "/accounts/{id}/balancecash" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> listBalanceCash(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getCashBalance(id) );
	}
	
	@RequestMapping(value = "/accounts/{id}/balancesec" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> listBalanceSec(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getSecPositions(id) );
	}
}
