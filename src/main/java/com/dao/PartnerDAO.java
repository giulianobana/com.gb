package com.dao;

import java.util.List;

import com.model.PartnerModel;

public interface PartnerDAO extends AccessDAO{

	public List<Object> searchPartnerByName(String n);
	
}
