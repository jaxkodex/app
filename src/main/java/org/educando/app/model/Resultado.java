package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
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
	@Column(name="id_resultado")
	private int idResultado;

	@Column(name="resultado_valor")
	private int resultadoValor;

	//bi-directional many-to-one association to Evaluacion
	@ManyToOne
	@JoinColumn(name="id_evaluacion")
	private Evaluacion evaluacion;

	//bi-directional many-to-one association to Criterio
	@ManyToOne
	@JoinColumn(name="id_criterio")
	private Criterio criterio;

	//bi-directional many-to-many association to Opcion
	@ManyToMany(mappedBy="resultados")
	private List<Opcion> opcions;

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

	public Evaluacion getEvaluacion() {
		return this.evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Criterio getCriterio() {
		return this.criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

}