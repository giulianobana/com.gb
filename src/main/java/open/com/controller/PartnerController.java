package open.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import open.com.dao.PartnerDAO;
import open.com.model.PartnerModel;

@RestController
public class PartnerController {

	
	@Autowired
	@Qualifier("PartnerDAOImpl")
	private PartnerDAO x;
	
	@RequestMapping(value = "/partner/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> getPartner(@PathVariable("id") int id) {	
	return ResponseEntity.ok(x.getEntity(id , PartnerModel.class) );
	}
	
	//create
	@RequestMapping(value = "/partner/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody PartnerModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}

	// searchByName
	@RequestMapping(value = "/partner" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> searchByName(@RequestParam("name") String p) {	
	return ResponseEntity.ok(x.searchPartnerByName(p));
	}
	
	@RequestMapping(value = "/partner/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody PartnerModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
				
}
