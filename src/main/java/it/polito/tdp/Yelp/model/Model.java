package it.polito.tdp.Yelp.model;

import java.util.List;

import it.polito.tdp.Yelp.db.YelpDAO;

public class Model {

	private List<Business> business;
	
	public List<Business> getBusiness(){
		if(this.business==null) {
			YelpDAO dao= new YelpDAO();
			this.business= dao.readAllBusinesses();
		}
		return this.business;
			
	}
}
