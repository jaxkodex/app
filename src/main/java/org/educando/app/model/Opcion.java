package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;


/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@NamedQuery(name="Opcion.findAll", query="SELECT o FROM Opcion o")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="@id")
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_opcion")
	private int idOpcion;

	@Column(name="opcion_descripcion")
	private String opcionDescripcion;

	//bi-directional many-to-one association to Criterio
	@ManyToOne
	@JoinColumn(name="id_criterio")
	private Criterio criterio;

	//bi-directional many-to-many association to Resultado
	@JsonIgnore
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
	private List<Resultado> resultados1;

	//bi-directional many-to-many association to Resultado
	@JsonIgnore
	@ManyToMany(mappedBy="opcions2")
	private List<Resultado> resultados2;

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

	public List<Resultado> getResultados1() {
		return this.resultados1;
	}

	public void setResultados1(List<Resultado> resultados1) {
		this.resultados1 = resultados1;
	}

	public List<Resultado> getResultados2() {
		return this.resultados2;
	}

	public void setResultados2(List<Resultado> resultados2) {
		this.resultados2 = resultados2;
	}

}
