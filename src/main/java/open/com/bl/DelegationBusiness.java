package open.com.bl;

import org.springframework.stereotype.Component;

import open.com.dao.DelegationDAOImpl;
import open.com.model.Auth0User;
import open.com.model.DelegationModel;
import open.com.model.ResponseObject;


 @Component("DelegationBusiness")
	public class DelegationBusiness extends DelegationDAOImpl {
	 // validation on create	
		@Override
		public boolean onCreateChecks(ResponseObject response , Object o) {
			// setting username
			boolean sta = false;	

			DelegationModel d = (DelegationModel) o;
			if (!d.getUsername().equals((String) request.getAttribute("user"))) {
				addErrorMessage(response, "ERROR", "400", "Username not valid: only owner can delegate");
				sta= true;
			}
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

