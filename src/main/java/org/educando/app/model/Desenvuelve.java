package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the desenvuelve database table.
 * 
 */
@Entity
@NamedQuery(name="Desenvuelve.findAll", query="SELECT d FROM Desenvuelve d")
public class Desenvuelve implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DesenvuelvePK id;

	//bi-directional many-to-many association to Clase
	@ManyToMany
	@JoinTable(
		name="a_cargo"
		, joinColumns={
			@JoinColumn(name="id_cargo", referencedColumnName="id_cargo"),
			@JoinColumn(name="persona_dni", referencedColumnName="persona_dni")
			}
		, inverseJoinColumns={
			@JoinColumn(name="clase_id_clase")
			}
		)
	private List<Clase> clases;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="desenvuelve")
	private List<Evaluacion> evaluacions;

	public Desenvuelve() {
	}

	public DesenvuelvePK getId() {
		return this.id;
	}

	public void setId(DesenvuelvePK id) {
		this.id = id;
	}

	public List<Clase> getClases() {
		return this.clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setDesenvuelve(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setDesenvuelve(null);

		return evaluacion;
	}

}