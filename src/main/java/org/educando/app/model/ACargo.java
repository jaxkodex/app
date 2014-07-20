package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the a_cargo database table.
 * 
 */
@Entity
@Table(name="a_cargo")
@NamedQuery(name="ACargo.findAll", query="SELECT a FROM ACargo a")
public class ACargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ACargoPK id;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="id_area", insertable=false, updatable=false)
	private Area area;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="clase_id_clase", insertable=false, updatable=false)
	private Clase clase;

	//bi-directional many-to-one association to Desenvuelve
//@Column(name="persona_dni", insertable=false, updatable=false)	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_cargo", referencedColumnName="id_cargo", insertable=false, updatable=false),
		@JoinColumn(name="persona_dni", referencedColumnName="persona_dni", insertable=false, updatable=false)
		})
	private Desenvuelve desenvuelve;

	public ACargo() {
	}

	public ACargoPK getId() {
		return this.id;
	}

	public void setId(ACargoPK id) {
		this.id = id;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Desenvuelve getDesenvuelve() {
		return this.desenvuelve;
	}

	public void setDesenvuelve(Desenvuelve desenvuelve) {
		this.desenvuelve = desenvuelve;
	}

}