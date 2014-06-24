package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the observador database table.
 * 
 */
@Entity
@NamedQuery(name="Observador.findAll", query="SELECT o FROM Observador o")
public class Observador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_observador")
	private int idObservador;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="observador")
	private List<Evaluacion> evaluacions;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="persona_dni")
	private Persona persona;

	public Observador() {
	}

	public int getIdObservador() {
		return this.idObservador;
	}

	public void setIdObservador(int idObservador) {
		this.idObservador = idObservador;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setObservador(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setObservador(null);

		return evaluacion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}