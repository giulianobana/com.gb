package open.com.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import open.com.model.CustomerModel;
import open.com.model.DelegationModel;
import open.com.model.KycModel;
import open.com.model.ResponseObject;
import open.com.model.ResponseObject.Messages;

public abstract class AccessDAOImpl implements AccessDAO {

	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	SessionFactory sessionFactory;
		
	public Object getEntity(int id, Class<?> classe ) {
		ResponseObject response = new ResponseObject();
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    Object h = session.get(classe , id);
	    
	    session.getTransaction().commit();
	    session.close();
	    response.setObject(h);
	    if (checkOnGet(response)) {
			addErrorMessage(response, "ERROR" , "400" , "object not exists");
			response.setObject(null);
	    }else			addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");

	    
		return response;
	}

	
	public Object createEntity(Object object) {
		ResponseObject response = new ResponseObject();
		// se errore ritorno messaggio
		if (!onCreateChecks(response, object)) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			try {
				Object a = session.save(object);
				session.getTransaction().commit();
				addErrorMessage(response, "INFO", "200", "Resource successfully created");
			} catch (ConstraintViolationException e ) {
				addErrorMessage(response, "ERROR", "400", e.getCause().getMessage());
			}
//			 catch (HibernateException he ) {
//					addErrorMessage(response, "ERROR", "400", he.getMessage());
//				}
			session.close();
		}
		response.setObject(object);
		return response;

	}
	
	
	public Object updateEntity(Object object) {
		ResponseObject response = new ResponseObject();
		if (!onUpdateChecks(response , object)) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.update(object);
	    session.getTransaction().commit();
	    session.close();	
		addErrorMessage(response, "INFO" , "200" , "Resource successfully created");
		}
		response.setObject(object);
	    return response;
	}
	
	public Object deleteEntity(int id , Class<?> classe) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.delete(session.load(classe.getName(),id) );
	    session.getTransaction().commit();
	    session.close();	
		ResponseObject response = new ResponseObject();
		addErrorMessage(response, "INFO" , "200" , "Resource successfully deleted");
		response.setObject(id);
		return response;
	}
	//searchbycustomer
	@Override
	public Object searchEntityByCustomer(int id , Class<?> classe ) {
		ResponseObject response = new ResponseObject();

		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + classe.getName() + " e " 
	    		+ " , " +  CustomerModel.class.getName() + " cus" +
	    		" where cus.id=e.customerid and  e.customerid = :customerid " +	
	    		" and ( cus.creator=:userlogin or"
	    	             + " cus.creator in ( select r.username from " + DelegationModel.class.getName() +
	    	             " r where r.delegatedTo =:userlogin) )";
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("customerid", id);
		query.setParameter("userlogin", (String) request.getAttribute("user"));

		addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");
		response.setObject(query.getResultList());
		return response;	
	    
	}

	// errore on create
	public boolean onCreateChecks(ResponseObject res , Object o) {
		return false;
	}
	
	public boolean checkOnGet(ResponseObject response) {
		// TODO Auto-generated method stub
		return false;
	}
	// errore on create
	public boolean onUpdateChecks(ResponseObject res , Object o) {
		return false;
	}
	// adding error messages
	public void addErrorMessage(ResponseObject  response , String level, String code , String message) {
		Messages errore = response.new Messages();
		errore.setLevel(level);
		errore.setCode(code);
		errore.setMessage(message);
		response.addMessage(errore);
		
	}

}
