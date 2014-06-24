package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the formato_evaluacion database table.
 * 
 */
@Entity
@Table(name="formato_evaluacion")
@NamedQuery(name="FormatoEvaluacion.findAll", query="SELECT f FROM FormatoEvaluacion f")
public class FormatoEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_formato")
	private int idFormato;

	@Temporal(TemporalType.DATE)
	@Column(name="formato_fecha")
	private Date formatoFecha;

	@Column(name="formato_version")
	private String formatoVersion;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="formatoEvaluacion")
	private List<Evaluacion> evaluacions;

	//bi-directional many-to-one association to SeccionEvaluacion
	@OneToMany(mappedBy="formatoEvaluacion")
	private List<SeccionEvaluacion> seccionEvaluacions;

	public FormatoEvaluacion() {
	}

	public int getIdFormato() {
		return this.idFormato;
	}

	public void setIdFormato(int idFormato) {
		this.idFormato = idFormato;
	}

	public Date getFormatoFecha() {
		return this.formatoFecha;
	}

	public void setFormatoFecha(Date formatoFecha) {
		this.formatoFecha = formatoFecha;
	}

	public String getFormatoVersion() {
		return this.formatoVersion;
	}

	public void setFormatoVersion(String formatoVersion) {
		this.formatoVersion = formatoVersion;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setFormatoEvaluacion(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setFormatoEvaluacion(null);

		return evaluacion;
	}

	public List<SeccionEvaluacion> getSeccionEvaluacions() {
		return this.seccionEvaluacions;
	}

	public void setSeccionEvaluacions(List<SeccionEvaluacion> seccionEvaluacions) {
		this.seccionEvaluacions = seccionEvaluacions;
	}

	public SeccionEvaluacion addSeccionEvaluacion(SeccionEvaluacion seccionEvaluacion) {
		getSeccionEvaluacions().add(seccionEvaluacion);
		seccionEvaluacion.setFormatoEvaluacion(this);

		return seccionEvaluacion;
	}

	public SeccionEvaluacion removeSeccionEvaluacion(SeccionEvaluacion seccionEvaluacion) {
		getSeccionEvaluacions().remove(seccionEvaluacion);
		seccionEvaluacion.setFormatoEvaluacion(null);

		return seccionEvaluacion;
	}

}