package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the criterio database table.
 * 
 */
@Entity
@NamedQuery(name="Criterio.findAll", query="SELECT c FROM Criterio c")
public class Criterio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_criterio")
	private int idCriterio;

	@Column(name="criterio_descripcion")
	private String criterioDescripcion;

	//bi-directional many-to-one association to SeccionEvaluacion
	@ManyToOne
	@JoinColumn(name="id_seccion")
	private SeccionEvaluacion seccionEvaluacion;

	//bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy="criterio")
	private List<Opcion> opcions;

	//bi-directional many-to-one association to Resultado
	@OneToMany(mappedBy="criterio")
	private List<Resultado> resultados;

	public Criterio() {
	}

	public int getIdCriterio() {
		return this.idCriterio;
	}

	public void setIdCriterio(int idCriterio) {
		this.idCriterio = idCriterio;
	}

	public String getCriterioDescripcion() {
		return this.criterioDescripcion;
	}

	public void setCriterioDescripcion(String criterioDescripcion) {
		this.criterioDescripcion = criterioDescripcion;
	}

	public SeccionEvaluacion getSeccionEvaluacion() {
		return this.seccionEvaluacion;
	}

	public void setSeccionEvaluacion(SeccionEvaluacion seccionEvaluacion) {
		this.seccionEvaluacion = seccionEvaluacion;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public Opcion addOpcion(Opcion opcion) {
		getOpcions().add(opcion);
		opcion.setCriterio(this);

		return opcion;
	}

	public Opcion removeOpcion(Opcion opcion) {
		getOpcions().remove(opcion);
		opcion.setCriterio(null);

		return opcion;
	}

	public List<Resultado> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public Resultado addResultado(Resultado resultado) {
		getResultados().add(resultado);
		resultado.setCriterio(this);

		return resultado;
	}

	public Resultado removeResultado(Resultado resultado) {
		getResultados().remove(resultado);
		resultado.setCriterio(null);

		return resultado;
	}

}