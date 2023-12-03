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
import lombok.Data;

@Entity
@Data
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String label;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Appareil.class,fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "category")
	List<Appareil> appareils=new ArrayList<>();
}
