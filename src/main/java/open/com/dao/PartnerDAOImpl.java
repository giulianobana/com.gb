package open.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import open.com.model.PartnerModel;
import open.com.model.ResponseObject;
import open.com.model.ResponseObject.Messages;

@Component("PartnerDAOImpl")
public class PartnerDAOImpl extends AccessDAOImpl implements PartnerDAO {

	@Override
	public List<Object> searchPartnerByName(String n) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + PartnerModel.class.getName() + " e " +
             "where e.fullName=:fullName  order by e.id ";
		Query<Object> query = session.createQuery(queryString);
		query.setParameter("fullName", n);
	    return query.getResultList();
	}


} 
