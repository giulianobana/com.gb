package open.com.bl;

import org.springframework.stereotype.Component;

import open.com.dao.CustomerDAOImpl;
import open.com.model.Auth0User;
import open.com.model.CustomerModel;
import open.com.model.ResponseObject;


@Component("CustomerBusiness")
public class CustomerBusiness extends CustomerDAOImpl {
 // validation on create	
	@Override
	public boolean onCreateChecks(ResponseObject response , Object o) {
		// setting username
				boolean sta = false;
		CustomerModel customer = (CustomerModel) o;
		// setting user
		// customer.setUserName((String) request.getAttribute("user"));
		customer.setCreator((String) request.getAttribute("user"));
//		if (customer.getLastname() == null ) {
//			addErrorMessage(response , "ERROR" , "400" , "Lastname Missing");
//			sta = true;
//		}

		return sta;
		
	}
	
//Validation on update
	@Override
	public boolean onUpdateChecks(ResponseObject response , Object o) {
		// setting username
		
		boolean sta = false;
		CustomerModel customer = (CustomerModel) o;
		// setting user
		
		if (customer.getNickname() != (String) request.getAttribute("user")) {
			addErrorMessage(response , "ERROR" , "400" , "User Name cannot be changed");
		}

		return sta;
		
	}

}
