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

import open.com.bl.ProductBusiness;
import open.com.model.object.ProductModel;
import open.com.model.type.Criteria;



@RestController
@Scope("request")
public class ProductController {

	@Autowired
	@Qualifier("ProductBusiness")
	private ProductBusiness x;
	
	@RequestMapping(value = "/products/{id}" ,  method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") int id) {	
		return ResponseEntity.ok(x.getEntity(id , ProductModel.class) );
	}
	
	//create
	@RequestMapping(value = "/products/" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> add(@RequestBody ProductModel p) {	
	return ResponseEntity.ok(x.createEntity(p));
	}
	
	@RequestMapping(value = "/products/{id}" ,  method = RequestMethod.PUT)
	public  ResponseEntity<Object> update(@RequestBody ProductModel p) {	
	return ResponseEntity.ok(x.updateEntity(p));
	}
	//create
	@RequestMapping(value = "/products/search" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> list(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity(ProductModel.class , search , "unsecured"));
	}
	

	
}
