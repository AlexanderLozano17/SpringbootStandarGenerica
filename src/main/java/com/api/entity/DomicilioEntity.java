package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "domicilios")
public class DomicilioEntity extends BaseEntity{
	
	@Column
	private String calle;
	@Column
	private int numero;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "localidad_id")
	private LocalidadEntity localidad;
	
	public DomicilioEntity() {
		super();
	}

	public DomicilioEntity(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalidadEntity getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEntity localidad) {
		this.localidad = localidad;
	}

	
}
