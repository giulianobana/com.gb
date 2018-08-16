package open.com.dao;

import java.util.List;

import open.com.model.ResponseObject.Messages;

public interface AccessDAO {
	public Object getEntity(int id, Class<?> classe);
	public Object createEntity(Object object);
	public Object updateEntity(Object object);
	

}
