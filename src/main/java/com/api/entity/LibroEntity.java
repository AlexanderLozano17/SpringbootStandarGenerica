package com.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class LibroEntity extends BaseEntity {

	@Column
	private String titulo;
	@Column
	private int fecha;
	@Column
	private String genero;
	@Column
	private int paginas;
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(
				name="libro_autor",
				joinColumns = @JoinColumn(name="libro_id"),
				inverseJoinColumns = @JoinColumn(name="autor_id")
	)
	private List<AutorEntity> autores;
	
	public LibroEntity() { 
		super();
	} 

	public LibroEntity(String titulo, int fecha, String genero, int paginas) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.genero = genero;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public List<AutorEntity> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorEntity> autores) {
		this.autores = autores;
	}
	
}
