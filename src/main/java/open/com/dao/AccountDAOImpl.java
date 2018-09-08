package open.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import open.com.model.object.CustomerModel;
import open.com.model.object.DelegationModel;
import open.com.model.object.ResponseObject;
import open.com.model.object.SecTransactionModel;
import open.com.model.object.CashTransactionModel;


@Component("AccountDAOImpl")
public class AccountDAOImpl extends AccessDAOImpl implements AccountDAO {

	@Override
	public Object getCashBalance(int accountid) {
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select sum("
	    		+ " CASE when ( e.sign='DEBIT' )  then (e.amount * - 1) else "
	    		+ "e.amount end )  from " + CashTransactionModel.class.getName() + " e " +
	    		" where e.accountid=:accountid" ;
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("accountid", accountid);
		addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");
		response.setObject(query.getResultList());
		return response;	
	}

	@Override
	public Object getSecPositions(int accountid) {
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e.ISIN , sum("
	    		+ " CASE when ( e.sign='SELL' )  then (e.quantity * - 1) else "
	    		+ "e.quantity end )  from " + SecTransactionModel.class.getName() + " e " +
	    		" where e.accountid=:accountid "
	    		+ "group by e.ISIN" ;
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("accountid", accountid);
		addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");
		response.setObject(query.getResultList());
		return response;	
	}
} 
