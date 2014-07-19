package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_area")
	private int idArea;

	@Column(name="area_descripcion")
	private String areaDescripcion;

	//bi-directional many-to-one association to ACargo
	@OneToMany(mappedBy="area")
	private List<ACargo> ACargos;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	public Area() {
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getAreaDescripcion() {
		return this.areaDescripcion;
	}

	public void setAreaDescripcion(String areaDescripcion) {
		this.areaDescripcion = areaDescripcion;
	}

	public List<ACargo> getACargos() {
		return this.ACargos;
	}

	public void setACargos(List<ACargo> ACargos) {
		this.ACargos = ACargos;
	}

	public ACargo addACargo(ACargo ACargo) {
		getACargos().add(ACargo);
		ACargo.setArea(this);

		return ACargo;
	}

	public ACargo removeACargo(ACargo ACargo) {
		getACargos().remove(ACargo);
		ACargo.setArea(null);

		return ACargo;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

}