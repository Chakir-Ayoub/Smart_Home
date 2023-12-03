package com.smart.home.service.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.home.beans.Appareil;
import com.smart.home.beans.Categorie;
import com.smart.home.dao.CategorieDao;

@Service
public class Categoris {
	private CategorieDao categorieDao;
	
	public Categoris(CategorieDao categorieDao) {
		this.categorieDao=categorieDao;
	}
	
	public Categorie GetById(Long id) {
		return this.categorieDao.findById(id).get();
	}
	
	public List<Categorie> GetAll(){
		return this.categorieDao.findAll();
	}
	
	public void Delete(Long id) {
		Categorie categorie=this.categorieDao.findById(id).get();
		 this.categorieDao.delete(categorie);
	}
	
	public Categorie AddCategorie(Categorie categorie) {
		return this.categorieDao.save(categorie);
	}
	
	public Categorie UpdateCategorie(Categorie categorie,Long id) {
		Categorie categorie2=this.categorieDao.findById(id).get();
		categorie2.setAppareils(categorie.getAppareils());
		categorie2.setLabel(categorie.getLabel());
		return this.categorieDao.save(categorie2);
	}
	
	public Categorie AddAppariel(Categorie categorie,Appareil appareil){
		 categorie.AjouterAppareil(categorie, appareil);
		 return this.categorieDao.save(categorie);
	}
}
