package com.smart.home.service.copy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.home.beans.Appareil;
import com.smart.home.dao.ApperialDao;

@Service
public class ApperialService {
	
	private ApperialDao apperialDao;
	public ApperialService(ApperialDao apperialDao) {
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
		appareil2.setDescription(appareil.getDescription());
		appareil2.setLabel(appareil.getLabel());
		appareil2.setState(appareil.isState());
		
		return this.apperialDao.save(appareil2);
	}

}
