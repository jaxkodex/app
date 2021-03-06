package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_cargo")
	private int idCargo;

	private boolean activo;

	@Column(name="cargo_codigo")
	private String cargoCodigo;

	@Column(name="cargo_descripcion")
	private String cargoDescripcion;

	//bi-directional many-to-many association to Persona
	@JsonIgnore
	@ManyToMany(mappedBy="cargos")
	private List<Persona> personas;

	public Cargo() {
	}

	public int getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getCargoCodigo() {
		return this.cargoCodigo;
	}

	public void setCargoCodigo(String cargoCodigo) {
		this.cargoCodigo = cargoCodigo;
	}

	public String getCargoDescripcion() {
		return this.cargoDescripcion;
	}

	public void setCargoDescripcion(String cargoDescripcion) {
		this.cargoDescripcion = cargoDescripcion;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}