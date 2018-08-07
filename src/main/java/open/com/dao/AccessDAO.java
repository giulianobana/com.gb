package open.com.dao;


public interface AccessDAO {
	public Object getEntity(int id, Class<?> classe);
	public Object createEntity(Object object);
	public Object updateEntity(Object object);

}
