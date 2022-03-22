package com.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class AutorEntity extends BaseEntity {

	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column(length = 1500)
	private String biografia;

	public AutorEntity() {
		super();
	}

	public AutorEntity(String nombre, String apellido, String biografia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.biografia = biografia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
}
