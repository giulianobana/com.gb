package open.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import open.com.model.TransactionModel;



@Component("TransactionDAOImpl")
public class TransactionDAOImpl extends AccessDAOImpl implements TransactionDAO {

	public List<Object> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    String queryString =  "Select e from " + TransactionModel.class.getName() + " e " 
             + " order by e.id ";
		Query<Object> query = session.createQuery(queryString);
	    return query.getResultList();

	}


} 
