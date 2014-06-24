package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_turno")
	private int idTurno;

	@Column(name="turno_codigo")
	private String turnoCodigo;

	@Column(name="turno_nombre")
	private String turnoNombre;

	//bi-directional many-to-one association to Clase
	@JsonIgnore
	@OneToMany(mappedBy="turno")
	private List<Clase> clases;

	public Turno() {
	}

	public int getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public String getTurnoCodigo() {
		return this.turnoCodigo;
	}

	public void setTurnoCodigo(String turnoCodigo) {
		this.turnoCodigo = turnoCodigo;
	}

	public String getTurnoNombre() {
		return this.turnoNombre;
	}

	public void setTurnoNombre(String turnoNombre) {
		this.turnoNombre = turnoNombre;
	}

	public List<Clase> getClases() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Clase addClas(Clase clas) {
		getClases().add(clas);
		clas.setTurno(this);

		return clas;
	}

	public Clase removeClas(Clase clas) {
		getClases().remove(clas);
		clas.setTurno(null);

		return clas;
	}

}