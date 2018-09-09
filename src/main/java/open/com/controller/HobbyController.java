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

import open.com.bl.HobbyBusiness;
import open.com.model.object.HobbyModel;
import open.com.model.type.Criteria;



@RestController
@Scope("request")
public class HobbyController {

	@Autowired
	@Qualifier("HobbyBusiness")
	private HobbyBusiness x;
	
	
	@RequestMapping(value = "/hobbies/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , HobbyModel.class) );
	}

	@RequestMapping(value = "/hobbies/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody HobbyModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	@RequestMapping(value = "/hobbies/{id}" ,  method = RequestMethod.DELETE)
	public  ResponseEntity<Object> update(@PathVariable("id") int id) {	
	return ResponseEntity.ok(x.deleteEntity(id, HobbyModel.class));
	}
	
	@RequestMapping(value = "/hobbies/search" ,  method = RequestMethod.POST ,
			 consumes = "application/json")
	public  ResponseEntity<Object> searchAllFilter(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity( HobbyModel.class , search, "customer"));
	}	
}
