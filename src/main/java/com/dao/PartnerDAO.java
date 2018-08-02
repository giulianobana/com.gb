package com.dao;

import java.util.List;

import com.model.PartnerModel;

public interface PartnerDAO {

	
	public void addPartner(PartnerModel p);
	public void updatePartner(PartnerModel p);
	public List<PartnerModel> listPartner();
	public PartnerModel getPartnerById(int id , Class<?> classe);
	public void removePartner(int id);
	
}
