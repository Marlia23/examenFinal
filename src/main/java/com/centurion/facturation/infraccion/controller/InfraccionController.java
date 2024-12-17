package com.centurion.facturation.infraccion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centurion.facturation.infraccion.entity.Infraccion;
import com.centurion.facturation.infraccion.service.InfraccionService;


@RestController
@RequestMapping("/v1/infraccion")
public class InfraccionController {
	
	@Autowired
	private InfraccionService service;
	
	@GetMapping
    public ResponseEntity<List<Infraccion>> getAll(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10));
        List<Infraccion> infraccion = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(infraccion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infraccion> getById(@PathVariable("id") int id) {
        Infraccion infraccion = service.findById(id);
        if (infraccion != null) {
            return ResponseEntity.status(HttpStatus.OK).body(infraccion);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Infraccion> create(@RequestBody Infraccion infraccion) {
        Infraccion infraccionDb = service.create(infraccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(infraccionDb);
    }

    @PutMapping
    public ResponseEntity<Infraccion> update(@RequestBody Infraccion infraccion) {
        Infraccion infraccionDb = service.update(infraccion);
        if (infraccionDb != null) {
            return ResponseEntity.status(HttpStatus.OK).body(infraccionDb);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        if (service.delete(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
}
