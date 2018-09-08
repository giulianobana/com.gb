package open.com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import open.com.model.object.ResponseObject.Messages;
import open.com.model.type.Criteria;
import open.com.model.type.Search;

public interface AccessDAO {
	public Object getEntity(int id, Class<?> classe);
	public Object createEntity(Object object);
	public Object updateEntity(Object object);
	public Object deleteEntity(int id , Class<?> classe);
	// No security
	public Object listAll(Class<?> classe);
	public Object listAll(Class<?> classe , Criteria search);
	
	//filter based security
	public Object searchEntityByCustomer(int id , Class<?> classe);
	public Object searchEntityByAccount(int id , Class<?> classe);
	
}
