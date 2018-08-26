package open.com.dao;

import java.util.List;

import open.com.model.ProductModel;

public interface ProductDAO extends AccessDAO{
	
	public List<Object> list();

}
