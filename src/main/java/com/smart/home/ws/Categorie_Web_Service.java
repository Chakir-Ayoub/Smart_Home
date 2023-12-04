package com.smart.home.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.home.beans.Appareil;
import com.smart.home.beans.Categorie;
import com.smart.home.dao.ApperialDao;
import com.smart.home.service.copy.Categoris;

@RestController
@RequestMapping("categorie")
@CrossOrigin("http://localhost:4200/")
public class Categorie_Web_Service {
	
	private Categoris categoris;
	private ApperialDao apperialDao;
	public Categorie_Web_Service(Categoris categoris,ApperialDao apperialDao) {
		this.categoris=categoris;
		this.apperialDao=apperialDao;
	}
	
	@GetMapping("/{id}")
	public Categorie GetById(@PathVariable Long id) {
		return this.categoris.GetById(id);
	}
	
	@GetMapping
	public List<Categorie> GetAll(){
		return this.categoris.GetAll();
	}
	
	@PostMapping
	public Categorie Add(@RequestBody Categorie categorie) {
		return this.categoris.AddCategorie(categorie);
	}
	
	@PutMapping(path = "/{id}")
	public Categorie UpdateCategorie(@RequestBody Categorie categorie,@PathVariable Long id) {
		return this.categoris.UpdateCategorie(categorie, id);
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable long id) {
		this.categoris.Delete(id);
	}
	
	@PostMapping(path = "/{id}")
	public Categorie Add(@PathVariable Long id,@RequestBody Appareil appareil) {
		Categorie categorie=GetById(id);
		return this.categoris.AddAppariel(categorie,appareil);
	}
	
	@DeleteMapping(path = "/{id}/{ida}")
	public Categorie Remove(@PathVariable Long id,@PathVariable Long ida) {
		Categorie categorie=GetById(id);
		Appareil appareil=this.apperialDao.findById(ida).get();
		return this.categoris.DeleteAppariel(categorie, appareil);
	}
	
	
}
