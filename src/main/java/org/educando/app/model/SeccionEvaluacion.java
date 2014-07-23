package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;


/**
 * The persistent class for the seccion_evaluacion database table.
 * 
 */
@Entity
@Table(name="seccion_evaluacion")
@NamedQuery(name="SeccionEvaluacion.findAll", query="SELECT s FROM SeccionEvaluacion s")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="@id")
public class SeccionEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_seccion")
	private int idSeccion;

	@Column(name="seccion_codigo")
	private String seccionCodigo;

	@Column(name="seccion_nombre")
	private String seccionNombre;

	//bi-directional many-to-one association to Criterio
	@OneToMany(mappedBy="seccionEvaluacion", fetch=FetchType.EAGER)
	private List<Criterio> criterios;

	//bi-directional many-to-one association to FormatoEvaluacion
	@ManyToOne
	@JoinColumn(name="id_formato")
	private FormatoEvaluacion formatoEvaluacion;

	public SeccionEvaluacion() {
	}

	public int getIdSeccion() {
		return this.idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getSeccionCodigo() {
		return this.seccionCodigo;
	}

	public void setSeccionCodigo(String seccionCodigo) {
		this.seccionCodigo = seccionCodigo;
	}

	public String getSeccionNombre() {
		return this.seccionNombre;
	}

	public void setSeccionNombre(String seccionNombre) {
		this.seccionNombre = seccionNombre;
	}

	public List<Criterio> getCriterios() {
		return this.criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}

	public Criterio addCriterio(Criterio criterio) {
		getCriterios().add(criterio);
		criterio.setSeccionEvaluacion(this);

		return criterio;
	}

	public Criterio removeCriterio(Criterio criterio) {
		getCriterios().remove(criterio);
		criterio.setSeccionEvaluacion(null);

		return criterio;
	}

	public FormatoEvaluacion getFormatoEvaluacion() {
		return this.formatoEvaluacion;
	}

	public void setFormatoEvaluacion(FormatoEvaluacion formatoEvaluacion) {
		this.formatoEvaluacion = formatoEvaluacion;
	}

}
