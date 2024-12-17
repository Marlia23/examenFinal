package com.centurion.facturation.infraccion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centurion.facturation.infraccion.entity.Infraccion;
import com.centurion.facturation.infraccion.repository.InfraccionRepository;
import com.centurion.facturation.infraccion.service.InfraccionService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfraccionServiceImpl implements InfraccionService{
	
	@Autowired
	private InfraccionRepository repository;
		
	@Override
	public List<Infraccion> findAll(Pageable page) {
		try {
			return repository.findAll(page).getContent();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	
	@Override
	@Transactional(readOnly = true)
	public Infraccion findById(int id) {
		try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
	}

	
	@Override
	@Transactional
	public Infraccion create(Infraccion obj) {
		try {
            return repository.save(obj);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
	}

	
	@Override
	public Infraccion update(Infraccion obj) {
		try {
		Infraccion registro= repository.findById(obj.getId()).orElseThrow();
		registro.setFecha(obj.getFecha());
		registro.setMonto_multa(obj.getMonto_multa());
		return registro;
		} catch (Exception e) {
	        log.error(e.getMessage());
	        return null;
	    }
	}

	
	@Override
	public boolean delete(int id) {
		try {
			Infraccion registro = repository.findById(id).orElseThrow();
            repository.delete(registro);
            return true;
		} catch (Exception e) {
			log.error(e.getMessage());
            return false;
		}
	}

}
