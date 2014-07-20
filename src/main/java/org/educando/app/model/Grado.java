package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the grado database table.
 * 
 */
@Entity
@NamedQuery(name="Grado.findAll", query="SELECT g FROM Grado g")
public class Grado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_grado")
	private int idGrado;

	@Column(name="grado_nombre")
	private String gradoNombre;

	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="grado")
	private List<Area> areas;

	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="id_nivel")
	private Nivel nivel;

	//bi-directional many-to-one association to Seccion
	@JsonIgnore
	@OneToMany(mappedBy="grado")
	private List<Seccion> seccions;

	public Grado() {
	}

	public int getIdGrado() {
		return this.idGrado;
	}

	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public String getGradoNombre() {
		return this.gradoNombre;
	}

	public void setGradoNombre(String gradoNombre) {
		this.gradoNombre = gradoNombre;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area addArea(Area area) {
		getAreas().add(area);
		area.setGrado(this);

		return area;
	}

	public Area removeArea(Area area) {
		getAreas().remove(area);
		area.setGrado(null);

		return area;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Seccion> getSeccions() {
		return this.seccions;
	}

	public void setSeccions(List<Seccion> seccions) {
		this.seccions = seccions;
	}

	public Seccion addSeccion(Seccion seccion) {
		getSeccions().add(seccion);
		seccion.setGrado(this);

		return seccion;
	}

	public Seccion removeSeccion(Seccion seccion) {
		getSeccions().remove(seccion);
		seccion.setGrado(null);

		return seccion;
	}

}