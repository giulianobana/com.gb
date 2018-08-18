package open.com.bl;

import org.springframework.stereotype.Component;

import open.com.dao.CustomerDAOImpl;
import open.com.model.Auth0User;
import open.com.model.CustomerModel;
import open.com.model.ResponseObject;


 @Component("DelegationBusiness")
	public class DelegationBusiness extends CustomerDAOImpl {
	 // validation on create	
		@Override
		public boolean onCreateChecks(ResponseObject response , Object o) {
			// setting username
					boolean sta = false;	
			return sta;
			
		}
		
	//Validation on update
		@Override
		public boolean onUpdateChecks(ResponseObject response , Object o) {
			// setting username
			boolean sta = false;
			return sta;
			
		}
	
	}

