package open.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

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
import open.com.model.object.SecurityPositionModel;
import open.com.model.object.SecurityPriceModel;
import open.com.model.object.CashBalanceModel;
import open.com.model.object.CashTransactionModel;


@Component("AccountDAOImpl")
public class AccountDAOImpl extends AccessDAOImpl implements AccountDAO {

	@Override
	public Object getCashBalance(int accountid) {
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select new open.com.model.object.CashBalanceModel( currency , sum("
	    		+ " CASE when ( e.sign='DEBIT' )  then (e.amount * - 1) else "
	    		+ "e.amount end ) )  from " + CashTransactionModel.class.getName() + " e " +
	    		" where e.accountid=:accountid "
	    		+ " group by currency " ;
	    List<CashBalanceModel> query = (List<CashBalanceModel>) session.createQuery(queryString , CashBalanceModel.class)
	    		.setParameter("accountid", accountid).getResultList();
	    
		addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");
		response.setObject(query);
		return response;	
	}

	@Override
	public Object getSecPositions(int accountid) {
		ArrayList<SecurityPositionModel> posRes = new ArrayList<SecurityPositionModel>();
		ResponseObject response = new ResponseObject();
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select new open.com.model.object.SecurityPositionModel( e.ISIN , sum("
	    		+ " CASE when ( e.sign='SELL' )  then (e.quantity * - 1) else "
	    		+ "e.quantity end ) , p.price  , p.valuedate)  from " + SecTransactionModel.class.getName() + " e ,  "
	    				+ SecurityPriceModel.class.getName() + " p " +
	    		" where e.accountid=:accountid and p.isin = e.ISIN "
	    		+ " and p.isLast = false "
	    		+ " group by e.ISIN , p.price , p.valuedate " ;
	    List<SecurityPositionModel> query = (List<SecurityPositionModel>) session.createQuery(queryString , SecurityPositionModel.class)
	    		.setParameter("accountid", accountid).getResultList();
	    
		addErrorMessage(response, "INFO" , "200" , "Resource succesfully retrieved");
		response.setObject(query);
		return response;	
	}
} 
