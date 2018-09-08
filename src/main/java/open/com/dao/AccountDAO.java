package open.com.dao;

import java.util.List;

public interface AccountDAO extends AccessDAO{

	public Object getCashBalance(int accountid);
	public Object getSecPositions(int accountid);

}
