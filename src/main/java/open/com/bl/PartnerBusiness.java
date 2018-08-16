package open.com.bl;

import org.springframework.stereotype.Component;

import open.com.dao.PartnerDAOImpl;
import open.com.model.PartnerModel;
import open.com.model.ResponseObject;


@Component("PartnerBusiness")
public class PartnerBusiness extends PartnerDAOImpl {
	
	@Override
	public boolean onCreateChecks(ResponseObject response , Object o) {
		boolean sta = false;
		PartnerModel partner = (PartnerModel) o;
		if (partner.getEmail() == null ) {
			addErrorMessage(response , "ERROR" , "400" , "Missing email");
			sta = true;
		}
		if (partner.getFullName() == null ) {
			addErrorMessage(response , "ERROR" , "400" , "Missing full name");
			sta = true;
		}
		return sta;
		
	}

}
