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
import open.com.model.ResponseObject;
import open.com.model.ResponseObject.Messages;

@Component("CustomerDAOImpl")
public class CustomerDAOImpl extends AccessDAOImpl implements CustomerDAO {

	public List<Object> searchCustomerByName(String n) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + CustomerModel.class.getName() + " e " +
             "where e.nickname like :searchName  and ( e.creator=:userlogin or"
             + " e.creator in ( select r.username from " + DelegationModel.class.getName() +
             " r where r.delegatedUser =:userlogin) ) "
             + " order by e.nickname ";
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("searchName", "%" + n + "%");
		query.setParameter("userlogin", (String) request.getAttribute("user"));
	    return query.getResultList();
	}


} 
