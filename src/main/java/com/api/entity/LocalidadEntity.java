package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "localidades")
public class LocalidadEntity extends BaseEntity {

	@Column
	private String denominacion;

	public LocalidadEntity() {
		super();
	}

	public LocalidadEntity(String denominacion) {
		super();
		this.denominacion = denominacion;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
}
