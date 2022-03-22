package com.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class PersonaEntity extends BaseEntity {

	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private int dni;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "domicilio_id")
	private DomicilioEntity domicilio; 
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name = "persona_libro",
			joinColumns = @JoinColumn(name = "persona_id"),
			inverseJoinColumns = @JoinColumn(name = "libro_id")
	)
	private List<LibroEntity> libros = new ArrayList<LibroEntity>();

	public PersonaEntity() {
		super();
	}

	public PersonaEntity(String nombres, String apellidos, int dni) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public DomicilioEntity getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioEntity domicilio) {
		this.domicilio = domicilio;
	}

	public List<LibroEntity> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroEntity> libros) {
		this.libros = libros;
	}

}
