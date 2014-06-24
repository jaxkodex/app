package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_opcion")
	private int idOpcion;

	@Column(name="opcion_descripcion")
	private String opcionDescripcion;

	//bi-directional many-to-one association to Criterio
	@ManyToOne
	@JoinColumn(name="id_criterio")
	private Criterio criterio;

	//bi-directional many-to-many association to Resultado
	@ManyToMany
	@JoinTable(
		name="resultado_has_opcion"
		, joinColumns={
			@JoinColumn(name="id_opcion")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_resultado")
			}
		)
	private List<Resultado> resultados;

	public Opcion() {
	}

	public int getIdOpcion() {
		return this.idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getOpcionDescripcion() {
		return this.opcionDescripcion;
	}

	public void setOpcionDescripcion(String opcionDescripcion) {
		this.opcionDescripcion = opcionDescripcion;
	}

	public Criterio getCriterio() {
		return this.criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public List<Resultado> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

}