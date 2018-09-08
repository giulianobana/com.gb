package open.com.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import open.com.model.object.AccountModel;
import open.com.model.object.BankingRelationModel;
import open.com.model.object.CustomerModel;
import open.com.model.object.DelegationModel;
import open.com.model.object.KycModel;
import open.com.model.object.ResponseObject;
import open.com.model.object.CashTransactionModel;
import open.com.model.object.ResponseObject.Messages;
import open.com.model.type.Criteria;
import open.com.model.type.Search;

public abstract class AccessDAOImpl implements AccessDAO {
	private static org.apache.log4j.Logger log = Logger.getLogger(AccessDAOImpl.class);

	
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
	// search account
	@Override
	public Object searchEntityByAccount(int id , Class<?> classe ) {
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + classe.getName() + " e " 
	    		+ " , " +  CustomerModel.class.getName() + " cus " +
	    		 " , " +  BankingRelationModel.class.getName() + " br " +
	    		" , " +  AccountModel.class.getName() + " acc " + 
	    		" where e.accountid=acc.id and "
	    		+ " br.id=acc.bankingrelationid and "
	    		+ " cus.id=br.customerid "
	    		+ " and  e.accountid = :accountid " +	
	    		" and ( cus.creator=:userlogin or"
	    	             + " cus.creator in ( select r.username from " + DelegationModel.class.getName() +
	    	             " r where r.delegatedTo =:userlogin) )";
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("accountid", id);
		query.setParameter("userlogin", (String) request.getAttribute("user"));

		addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");
		response.setObject(query.getResultList());
		return response;	
	}
	
	
	//list all
	@Override
	public List<Object> listAll(Class<?> classe) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + classe.getName() + " e " 
             + " order by e.id ";
		Query<Object> query = session.createQuery(queryString);
	    return query.getResultList();

	}
    // 
	@Override
	public Object listAll(Class<?> classe , Criteria search) {
		// TODO Auto-generated method stub 
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    StringBuilder outputBuilder = new StringBuilder("");
	    
	    outputBuilder.append("Select e from " + classe.getName() + " e  where 1=1 " );
	    
		if (search != null) {
			for (Search s1 : search.getFilter()) {
				outputBuilder
						.append(
								(s1.getAndOr() != null ? s1.getAndOr() : " and ") 
								+ " " + s1.getAttribute() + " " + s1.getOperator() + " " + s1.getValue() + " ");
			}
		}
	    
	    String queryString = outputBuilder.toString() + " order by  " + 
	    (search.getSorting() !=	 null ? search.getSorting() : "id desc" );
	    
		try   {
			Query<Object> query = session.createQuery(queryString);
			response.setObject(query.getResultList());
		} catch (IllegalArgumentException  e ) {
			addErrorMessage(response, "ERROR", "400", e.getCause().getMessage());
			
		} 
//	
		
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
