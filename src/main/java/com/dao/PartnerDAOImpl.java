package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.model.PartnerModel;

@Repository
@Component("PartnerDAOImpl")
public class PartnerDAOImpl implements PartnerDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addPartner(PartnerModel p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePartner(PartnerModel p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PartnerModel> listPartner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartnerModel getPartnerById(int id , Class<?> classe) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    PartnerModel h = (PartnerModel) session.get(classe , id);
	    session.getTransaction().commit();
	    session.close();
		return h;
	}

	@Override
	public void removePartner(int id) {
		// TODO Auto-generated method stub
		
	}


}
