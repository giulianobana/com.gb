package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AccessDAOImpl implements AccessDAO {

	
	@Autowired
	SessionFactory sessionFactory;
	
	public Object getEntity(int id, Class<?> classe ) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    Object h = session.get(classe , id);
	    session.getTransaction().commit();
	    session.close();
		return h;
	}

	public Object createEntity(Object object) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.save(object);
	    session.getTransaction().commit();
	    session.close();	
	    return object;
	}
}
