package open.com.dao;

import java.util.List;


public interface CustomerDAO extends AccessDAO{

	public List<Object> searchCustomerByName(String n);
	
}
