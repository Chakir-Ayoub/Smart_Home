package com.smart.home.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.home.beans.Categorie;
import com.smart.home.service.copy.Categoris;

@RestController
@RequestMapping("categorie")
public class Categorie_Web_Service {
	
	private Categoris categoris;
	
	public Categorie_Web_Service(Categoris categoris) {
		this.categoris=categoris;
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
}
