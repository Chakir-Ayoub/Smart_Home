package com.smart.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.home.beans.Appareil;

public interface ApperialDao extends JpaRepository<Appareil, Long> {
	
}
