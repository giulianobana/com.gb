package open.com.bl;

import java.util.Date;

import org.springframework.stereotype.Component;

import open.com.dao.AccountDAOImpl;
import open.com.model.object.AccountModel;
import open.com.model.object.CardModel;
import open.com.model.object.ResponseObject;
import open.com.model.type.AccountType;


 @Component("AccountBusiness")
	public class AccountBusiness extends AccountDAOImpl {

		@Override
		public boolean onCreateChecks(ResponseObject response , Object o) {
			// error
			boolean inError = false;
			AccountModel account = (AccountModel) o;
			// 
			// if CASH calculates IBAN
			if ( account.getType()  == AccountType.CASH )  {
			account.setIban("CH0101" + String.valueOf(new Date().getTime())); 
			}
			else {
				account.setIban(null);
			}
			return inError;
			
		}
	}

