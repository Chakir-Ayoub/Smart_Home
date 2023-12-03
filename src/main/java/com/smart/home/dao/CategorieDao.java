package com.smart.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.home.beans.Categorie;

public interface CategorieDao extends JpaRepository<Categorie, Long> {

}
