package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the area database table.
 * 
 */
@Embeddable
public class AreaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_area")
	private int idArea;

	@Column(name="id_grado", insertable=false, updatable=false)
	private int idGrado;

	public AreaPK() {
	}
	public int getIdArea() {
		return this.idArea;
	}
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
	public int getIdGrado() {
		return this.idGrado;
	}
	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AreaPK)) {
			return false;
		}
		AreaPK castOther = (AreaPK)other;
		return 
			(this.idArea == castOther.idArea)
			&& (this.idGrado == castOther.idGrado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idArea;
		hash = hash * prime + this.idGrado;
		
		return hash;
	}
}