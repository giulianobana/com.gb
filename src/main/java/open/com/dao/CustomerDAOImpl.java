package open.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import open.com.model.object.AccountModel;
import open.com.model.object.BankingRelationModel;
import open.com.model.object.CustomerModel;
import open.com.model.object.DelegationModel;
import open.com.model.object.ResponseObject;
import open.com.model.object.ResponseObject.Messages;
import open.com.model.type.Criteria;
import open.com.model.type.Search;

@Component("CustomerDAOImpl")
public class CustomerDAOImpl extends AccessDAOImpl implements CustomerDAO {

	public List<Object> searchCustomerByName(String n) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + CustomerModel.class.getName() + " e " +
             "where  ( e.creator=:userlogin or"
             + " e.creator in ( select r.username from " + DelegationModel.class.getName() +
             " r where r.delegatedTo =:userlogin) ) "
             + 	(n != null && !n.equals("") ? " and e.nickname like :searchName" : "  ") 
             + " order by e.nickname ";

	    Query<Object> query = session.createQuery(queryString);
		if (n!= null && !n.equals("") ) {
		query.setParameter("searchName", "%" + n + "%");
		}
		query.setParameter("userlogin", (String) request.getAttribute("user"));
	    return query.getResultList();
	}

	
	@Override
	public Object searchEntity(Class<?> classe , Criteria search , String level) {
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    StringBuilder outputBuilder = new StringBuilder("");

	    outputBuilder.append("Select "

	    		+ " cus  from " + classe.getName() + "  cus"
	    		+ " where 1=1 " 
	    		); 
	    	
		if (search != null) {
			for (Search s1 : search.getFilter()) {
				outputBuilder
						.append(
								(s1.getAndOr() != null ? s1.getAndOr() : " and ") 
								+ " " + s1.getAttribute() + " " + s1.getOperator() + " " + s1.getValue() + " ");
			}
		}
	    
	    String queryString = outputBuilder.toString() + " order by  " + 
	    (search.getSorting() !=	 null ? search.getSorting() : " cus.id desc" );

	    
	    try {
	    	if (search.getTop() == 0)  search.setTop(10);
	    	if (search.getTop() > 100)  search.setTop(100);

	    	
	    			
			Query<Object> query = session.createQuery(queryString).setMaxResults(search.getTop());

//			query.setParameter("userlogin", (String) request.getAttribute("user"));

			response.setObject(query.getResultList());
			addErrorMessage(response, "INFO", "200", "Resource succesfully retrieved");
		}
		catch (QueryException | IllegalArgumentException | SQLGrammarException  e ) {
			addErrorMessage(response, "ERROR" , "400" ,  e.getCause().getLocalizedMessage());
		}
		return response;	
	}

} 
