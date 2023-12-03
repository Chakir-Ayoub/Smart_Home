package com.smart.home.service.copy;

import java.util.List;

import com.smart.home.beans.Appareil;
import com.smart.home.dao.ApperialDao;

public class ApperialService {
	
	private ApperialDao apperialDao;
	private ApperialService(ApperialDao apperialDao) {
		this.apperialDao=apperialDao;
	}
	
	public Appareil GetById(long id) {
		return this.apperialDao.findById(id).get();
	}
	
	public List<Appareil> GetAll(){
		return this.apperialDao.findAll();
	}
	
	public void Delete(Long id) {
		Appareil appareil=this.GetById(id);
		this.apperialDao.delete(appareil);
	}
	
	public Appareil addAppareil(Appareil appareil) {
		return this.apperialDao.save(appareil);
	}
	
	public Appareil UpdateAppareil(Appareil appareil,long id) {
		Appareil appareil2=this.apperialDao.findById(id).get();
		appareil2.setCategory(appareil.getCategory());
		appareil2.setDescription(appareil.getDescription());
		appareil2.setLabel(appareil.getLabel());
		appareil2.setState(appareil.isState());
		
		return this.apperialDao.save(appareil2);
	}

}
