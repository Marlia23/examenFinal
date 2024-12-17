package com.centurion.facturation.infraccion.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "infraccion")
public class Infraccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="dni", unique = true, nullable = false, length = 8)
	private String dni;
	
	private LocalDateTime fecha;
	
	@Column(name="tipo_infraccion", nullable = false, length = 20)
	private String tipoInfraccion;
	
	@Column(name="ubicacion", nullable = false, length = 200)
	private String ubicacion;
	
	@Column(name="descripcion", nullable = true, length = 255)
	private String descripcion;
	
	private Double monto_multa;
	
	@Column(name="estado", nullable = false, length = 20)
	private String estado;
}
