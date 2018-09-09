package open.com.bl;

import java.util.Date;

import org.springframework.stereotype.Component;

import open.com.dao.AccessDAOImpl;
import open.com.model.object.CardModel;
import open.com.model.object.CustomerModel;
import open.com.model.object.ResponseObject;



 @Component("CardBusiness")
	public class CardBusiness extends AccessDAOImpl {

		@Override
		public boolean onCreateChecks(ResponseObject response , Object o) {
			// error
			boolean inError = false;
			CardModel card = (CardModel) o;
			// 
			// generation of credit card
			card.setCardnumber(String.valueOf(new Date().getTime()));
			return inError;
			
		}
		
	}

