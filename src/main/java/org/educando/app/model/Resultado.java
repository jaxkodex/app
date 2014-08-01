package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the resultado database table.
 * 
 */
@Entity
@NamedQuery(name="Resultado.findAll", query="SELECT r FROM Resultado r")
public class Resultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_resultado")
	private int idResultado;

	@Column(name="resultado_valor")
	private int resultadoValor;

	@Column(name="resultado_text")
	private String resultadoText;

	//bi-directional many-to-many association to Opcion
	@ManyToMany(mappedBy="resultados1")
	private List<Opcion> opcions1;

	//bi-directional many-to-one association to Criterio
	@ManyToOne
	@JoinColumn(name="id_criterio")
	private Criterio criterio;

	//bi-directional many-to-one association to Evaluacion
	@ManyToOne
	@JoinColumn(name="id_evaluacion")
	private Evaluacion evaluacion;

	//bi-directional many-to-many association to Opcion
	@ManyToMany
	@JoinTable(
		name="resultado_has_opcion"
		, joinColumns={
			@JoinColumn(name="id_resultado")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_opcion")
			}
		)
	private List<Opcion> opcions2;

	public Resultado() {
	}

	public int getIdResultado() {
		return this.idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public int getResultadoValor() {
		return this.resultadoValor;
	}

	public void setResultadoValor(int resultadoValor) {
		this.resultadoValor = resultadoValor;
	}

	public List<Opcion> getOpcions1() {
		return this.opcions1;
	}

	public void setOpcions1(List<Opcion> opcions1) {
		this.opcions1 = opcions1;
	}

	public Criterio getCriterio() {
		return this.criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public Evaluacion getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public List<Opcion> getOpcions2() {
		return this.opcions2;
	}

	public void setOpcions2(List<Opcion> opcions2) {
		this.opcions2 = opcions2;
	}

}