package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the desenvuelve database table.
 * 
 */
@Embeddable
public class DesenvuelvePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_cargo", insertable=false, updatable=false)
	private int idCargo;

	@Column(name="persona_dni", insertable=false, updatable=false)
	private String personaDni;

	public DesenvuelvePK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DesenvuelvePK)) {
			return false;
		}
		DesenvuelvePK castOther = (DesenvuelvePK)other;
		return 
			(this.idCargo == castOther.idCargo)
			&& this.personaDni.equals(castOther.personaDni);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCargo;
		hash = hash * prime + this.personaDni.hashCode();
		
		return hash;
	}
}