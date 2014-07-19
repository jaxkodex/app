package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evaluacion")
	private int idEvaluacion;

	@Column(name="evaluacion_areas")
	private String evaluacionAreas;

	@Column(name="evaluacion_denominacon")
	private String evaluacionDenominacon;

	@Column(name="evaluacion_nhainclusivo")
	private int evaluacionNhainclusivo;

	@Column(name="evaluacion_nhasistentes")
	private int evaluacionNhasistentes;

	@Column(name="evaluacion_nmainclusivo")
	private int evaluacionNmainclusivo;

	@Column(name="evaluacion_nmasistenetes")
	private int evaluacionNmasistenetes;

	//bi-directional many-to-one association to Conclusion
	@OneToMany(mappedBy="evaluacion")
	private List<Conclusion> conclusions;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="id_clase")
	private Clase clase;

	//bi-directional many-to-one association to Desenvuelve
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_cargo", referencedColumnName="id_cargo"),
		@JoinColumn(name="persona_dni", referencedColumnName="persona_dni")
		})
	private Desenvuelve desenvuelve;

	//bi-directional many-to-one association to FormatoEvaluacion
	@ManyToOne
	@JoinColumn(name="id_formato")
	private FormatoEvaluacion formatoEvaluacion;

	//bi-directional many-to-one association to Observador
	@ManyToOne
	@JoinColumn(name="id_observador")
	private Observador observador;

	//bi-directional many-to-one association to Resultado
	@OneToMany(mappedBy="evaluacion")
	private List<Resultado> resultados;

	public Evaluacion() {
	}

	public int getIdEvaluacion() {
		return this.idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public String getEvaluacionAreas() {
		return this.evaluacionAreas;
	}

	public void setEvaluacionAreas(String evaluacionAreas) {
		this.evaluacionAreas = evaluacionAreas;
	}

	public String getEvaluacionDenominacon() {
		return this.evaluacionDenominacon;
	}

	public void setEvaluacionDenominacon(String evaluacionDenominacon) {
		this.evaluacionDenominacon = evaluacionDenominacon;
	}

	public int getEvaluacionNhainclusivo() {
		return this.evaluacionNhainclusivo;
	}

	public void setEvaluacionNhainclusivo(int evaluacionNhainclusivo) {
		this.evaluacionNhainclusivo = evaluacionNhainclusivo;
	}

	public int getEvaluacionNhasistentes() {
		return this.evaluacionNhasistentes;
	}

	public void setEvaluacionNhasistentes(int evaluacionNhasistentes) {
		this.evaluacionNhasistentes = evaluacionNhasistentes;
	}

	public int getEvaluacionNmainclusivo() {
		return this.evaluacionNmainclusivo;
	}

	public void setEvaluacionNmainclusivo(int evaluacionNmainclusivo) {
		this.evaluacionNmainclusivo = evaluacionNmainclusivo;
	}

	public int getEvaluacionNmasistenetes() {
		return this.evaluacionNmasistenetes;
	}

	public void setEvaluacionNmasistenetes(int evaluacionNmasistenetes) {
		this.evaluacionNmasistenetes = evaluacionNmasistenetes;
	}

	public List<Conclusion> getConclusions() {
		return this.conclusions;
	}

	public void setConclusions(List<Conclusion> conclusions) {
		this.conclusions = conclusions;
	}

	public Conclusion addConclusion(Conclusion conclusion) {
		getConclusions().add(conclusion);
		conclusion.setEvaluacion(this);

		return conclusion;
	}

	public Conclusion removeConclusion(Conclusion conclusion) {
		getConclusions().remove(conclusion);
		conclusion.setEvaluacion(null);

		return conclusion;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Desenvuelve getDesenvuelve() {
		return this.desenvuelve;
	}

	public void setDesenvuelve(Desenvuelve desenvuelve) {
		this.desenvuelve = desenvuelve;
	}

	public FormatoEvaluacion getFormatoEvaluacion() {
		return this.formatoEvaluacion;
	}

	public void setFormatoEvaluacion(FormatoEvaluacion formatoEvaluacion) {
		this.formatoEvaluacion = formatoEvaluacion;
	}

	public Observador getObservador() {
		return this.observador;
	}

	public void setObservador(Observador observador) {
		this.observador = observador;
	}

	public List<Resultado> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public Resultado addResultado(Resultado resultado) {
		getResultados().add(resultado);
		resultado.setEvaluacion(this);

		return resultado;
	}

	public Resultado removeResultado(Resultado resultado) {
		getResultados().remove(resultado);
		resultado.setEvaluacion(null);

		return resultado;
	}

}