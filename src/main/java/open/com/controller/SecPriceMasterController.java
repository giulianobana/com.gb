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

import open.com.bl.SecPriceMasterBusiness;
import open.com.bl.SecurityMasterBusiness;
import open.com.model.object.ProductModel;
import open.com.model.object.SecurityMasterModel;
import open.com.model.object.SecurityPriceModel;
import open.com.model.type.Criteria;



@RestController
@Scope("request")
public class SecPriceMasterController {

	@Autowired
	@Qualifier("SecPriceMasterBusiness")
	private SecPriceMasterBusiness x;
	
	//create
	@RequestMapping(value = "/securitiesprice/search" ,  method = RequestMethod.POST)
	public  ResponseEntity<Object> list(@RequestBody Criteria  search) {	
	return ResponseEntity.ok(x.searchEntity(SecurityPriceModel.class , search , "unsecured"));
	}
		
}
