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
import open.com.model.object.ResponseObject.Messages;

@Component("DelegationDAOImpl")
public class DelegationDAOImpl extends AccessDAOImpl implements DelegationDAO {

	public List<Object> searchMyDelegation() {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + DelegationModel.class.getName() + " e " +
             "where e.username = :userlogin "
             + " order by e.delegatedTo ";
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("userlogin", (String) request.getAttribute("user"));
	    return query.getResultList();
	}


} 
