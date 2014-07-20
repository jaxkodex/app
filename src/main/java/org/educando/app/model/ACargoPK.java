package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the a_cargo database table.
 * 
 */
@Embeddable
public class ACargoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

//	@Column(name="clase_id_clase", insertable=false, updatable=false)
	@Column(name="clase_id_clase")
	private int claseIdClase;

//	@Column(name="id_cargo", insertable=false, updatable=false)
	@Column(name="id_cargo")
	private int idCargo;

//	@Column(name="persona_dni", insertable=false, updatable=false)
	@Column(name="persona_dni")
	private String personaDni;

//	@Column(name="id_area", insertable=false, updatable=false)
	@Column(name="id_area")
	private int idArea;

	public ACargoPK() {
	}
	public int getClaseIdClase() {
		return this.claseIdClase;
	}
	public void setClaseIdClase(int claseIdClase) {
		this.claseIdClase = claseIdClase;
	}
	public int getIdCargo() {
		return this.idCargo;
	}
	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}
	public String getPersonaDni() {
		return this.personaDni;
	}
	public void setPersonaDni(String personaDni) {
		this.personaDni = personaDni;
	}
	public int getIdArea() {
		return this.idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ACargoPK)) {
			return false;
		}
		ACargoPK castOther = (ACargoPK)other;
		return 
			(this.claseIdClase == castOther.claseIdClase)
			&& (this.idCargo == castOther.idCargo)
			&& this.personaDni.equals(castOther.personaDni)
			&& (this.idArea == castOther.idArea);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.claseIdClase;
		hash = hash * prime + this.idCargo;
		hash = hash * prime + this.personaDni.hashCode();
		hash = hash * prime + this.idArea;
		
		return hash;
	}
}