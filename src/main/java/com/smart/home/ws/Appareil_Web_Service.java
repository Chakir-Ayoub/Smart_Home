package com.smart.home.ws;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.home.beans.Appareil;
import com.smart.home.service.copy.ApperialService;

@RestController
@RequestMapping("appareil")
public class Appareil_Web_Service {
	
	private ApperialService appService;
	
	public Appareil_Web_Service(ApperialService apperialService) {
		this.appService=apperialService;
	}
	
	@GetMapping(path = "/{id}")
	public Appareil GetById(@PathVariable Long id) {
		return this.appService.GetById(id);
	}
	
	@GetMapping
	public List<Appareil> GetAll(){
		return this.appService.GetAll();
	}
	
	@PostMapping
	public Appareil Add(@RequestBody Appareil appareil) {
		return this.appService.addAppareil(appareil);
	}
	
	@PutMapping(path = "/{id}")
	public Appareil Update(@RequestBody Appareil appareil,@PathVariable Long id) {
		return this.appService.UpdateAppareil(appareil, id);
	}
	
	
	@DeleteMapping(path = "/{id}")
	public void Delete(@PathVariable Long id) {
		this.appService.Delete(id);
	}
	
}
