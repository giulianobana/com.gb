package com.dao;

import java.util.List;

import com.model.PartnerModel;

public interface PartnerDAO {

	
	public void addPartner(PartnerModel p);
	public void updatePerson(PartnerModel p);
	public List<PartnerModel> listPartner();
	public PartnerModel getPartnerById(int id);
	public void removePpartner(int id);
	
}
