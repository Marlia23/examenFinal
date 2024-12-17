package com.centurion.facturation.infraccion.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centurion.facturation.infraccion.entity.Infraccion;

@Repository
public interface InfraccionRepository extends JpaRepository<Infraccion, Integer>{
	public Infraccion findByFecha(LocalDateTime fecha);
}
