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
import org.hibernate.exception.SQLGrammarException;
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
import open.com.model.object.ResponseObject2;
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
	
	@Override
	public Object searchEntityByAccount2(int id , Class<?> classe ) {
		ResponseObject2 response = new ResponseObject2();
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

//		addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");
		response.setResult(query.getResultList());
		return response;	
	}
	
	@Override
	public Object searchEntity(Class<?> classe , Criteria search , String level) {
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    StringBuilder outputBuilder = new StringBuilder("");
	    
	    if (search.isUnSecured()) {
	    	level = "unsecured";
	    }
	    
	    switch (level.toLowerCase()) { 
	    case "account" : 
	    outputBuilder.append("Select e from " + classe.getName() + " e " 
	    		+ " , " +  CustomerModel.class.getName() + " cus " +
	    		 " , " +  BankingRelationModel.class.getName() + " br " +
	    		" , " +  AccountModel.class.getName() + " acc " + 
	    		" where e.accountid=acc.id and "
	    		+ " br.id=acc.bankingrelationid and "
	    		+ " cus.id=br.customerid "
//	    		+ " and  e.accountid = :accountid "
	    		+ " and ( cus.creator=:userlogin or"
	    	             + " cus.creator in ( select r.username from " + DelegationModel.class.getName() +
	    	             " r where r.delegatedTo =:userlogin) ) "); 
	    	break;
	    	case "customer" :
		     outputBuilder.append( "Select e from " + classe.getName() + " e " 
		    		+ " , " +  CustomerModel.class.getName() + " cus" +
		    		" where cus.id=e.customerid  " +	
		    		" and ( cus.creator=:userlogin or"
		    	             + " cus.creator in ( select r.username from " + DelegationModel.class.getName() +
		    	             " r where r.delegatedTo =:userlogin) )");
		     	break;
	    	case "bankingrelation" :
	    	    outputBuilder.append("Select e from " + classe.getName() + " e " 
	    	    		+ " , " +  CustomerModel.class.getName() + " cus " +
	    	    		 " , " +  BankingRelationModel.class.getName() + " br " 
	    	    		+ " where   br.id=e.bankingrelationid and "
	    	    		+ " cus.id=br.customerid "
	    	    		+ " and ( cus.creator=:userlogin or"
	    	    	             + " cus.creator in ( select r.username from " + DelegationModel.class.getName() +
	    	    	             " r where r.delegatedTo =:userlogin) ) "); 
	    	    break;
	    	    
	    	case "unsecured" :    
	    	    outputBuilder.append("Select e from " + classe.getName() + " e  where :userlogin =:userlogin " );
	    	    break;
	    	    
	    	default :
	    		outputBuilder.append("");
			
	    }
	    	
		if (search != null) {
			for (Search s1 : search.getFilter()) {
				outputBuilder
						.append(
								(s1.getAndOr() != null ? s1.getAndOr() : " and ") 
								+ " " + s1.getAttribute() + " " + s1.getOperator() + " " + s1.getValue() + " ");
			}
		}
	    
	    String queryString = outputBuilder.toString() + " order by  " + 
	    (search.getSorting() !=	 null ? search.getSorting() : " e.id desc" );

	    
	    try {
	    
	    	
			if (search.getTop() == 0)  search.setTop(10);
	    	if (search.getTop() > 100)  search.setTop(100);
	    	Query<Object> query = session.createQuery(queryString).setMaxResults(search.getTop());

			query.setParameter("userlogin", (String) request.getAttribute("user"));

	    	
			response.setObject(query.getResultList());
			addErrorMessage(response, "INFO", "200", "Resource succesfully retrieved");
		}
		catch (QueryException | IllegalArgumentException | SQLGrammarException  e ) {
			addErrorMessage(response, "ERROR" , "400" ,  e.getCause().getLocalizedMessage());
		}
		return response;	
	}
	
	
	
	
	
	/*support*/
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
