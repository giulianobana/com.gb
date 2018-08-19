package open.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import open.com.model.CustomerModel;
import open.com.model.DelegationModel;
import open.com.model.KycModel;


@Component("KycDAOImpl")
public class KycDAOImpl extends AccessDAOImpl implements KycDAO {

	@Override
	public Object getKycFromCustomer(int id) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + KycModel.class.getName() + " e " +
             "where e.customerid = :customerid ";
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("customerid", id);
	    return query.getResultList();	
	    
	}



} 
