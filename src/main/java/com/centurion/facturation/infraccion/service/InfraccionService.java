package com.centurion.facturation.infraccion.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.centurion.facturation.infraccion.entity.Infraccion;

public interface InfraccionService {
	public List<Infraccion> findAll(Pageable page);
	public Infraccion findById(int id);
	public Infraccion create(Infraccion obj);
	public Infraccion update(Infraccion obj);
	public boolean delete(int id);
}
