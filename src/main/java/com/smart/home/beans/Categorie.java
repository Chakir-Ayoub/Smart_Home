package com.smart.home.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;
import lombok.Data;

@Entity
@Data
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String label;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Appareil.class,fetch = FetchType.LAZY,mappedBy = "category")
	List<Appareil> appareils=new ArrayList<>();
	
	
	@Transactional
	public void AjouterAppareil(Categorie categorie,Appareil appareil) {
		appareils.add(appareil);
		appareil.setCategory(categorie);
	}
	
	@Transactional
	public void SupperimerAppareil(Appareil appareil) {
		Appareil appareilSupperimer=null;
		for(Appareil a:appareils) {
			if(a.equals(appareil)) {
				appareilSupperimer=a;
				break;
			}
		}
		if(appareilSupperimer!=null) {
			appareils.remove(appareilSupperimer);
		}
	}
}
