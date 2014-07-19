package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */
@Entity
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_clase")
	private int idClase;

	@Temporal(TemporalType.DATE)
	@Column(name="clase_ffin")
	private Date claseFfin;

	@Temporal(TemporalType.DATE)
	@Column(name="clase_finicio")
	private Date claseFinicio;

	@Column(name="clase_nhinclusivos")
	private int claseNhinclusivos;

	@Column(name="clase_nhombres")
	private int claseNhombres;

	@Column(name="clase_nminclusivos")
	private int claseNminclusivos;

	@Column(name="clase_nmujeres")
	private int claseNmujeres;

	//bi-directional many-to-one association to ACargo
	@OneToMany(mappedBy="clase")
	private List<ACargo> ACargos;

	//bi-directional many-to-one association to PeriodoAcademico
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private PeriodoAcademico periodoAcademico;

	//bi-directional many-to-one association to Seccion
	@ManyToOne
	@JoinColumn(name="id_seccion")
	private Seccion seccion;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="id_turno")
	private Turno turno;

	//bi-directional many-to-many association to Desenvuelve
	@ManyToMany(mappedBy="clases")
	private List<Desenvuelve> desenvuelves;

	//bi-directional many-to-one association to Evaluacion
	@OneToMany(mappedBy="clase")
	private List<Evaluacion> evaluacions;

	public Clase() {
	}

	public int getIdClase() {
		return this.idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public Date getClaseFfin() {
		return this.claseFfin;
	}

	public void setClaseFfin(Date claseFfin) {
		this.claseFfin = claseFfin;
	}

	public Date getClaseFinicio() {
		return this.claseFinicio;
	}

	public void setClaseFinicio(Date claseFinicio) {
		this.claseFinicio = claseFinicio;
	}

	public int getClaseNhinclusivos() {
		return this.claseNhinclusivos;
	}

	public void setClaseNhinclusivos(int claseNhinclusivos) {
		this.claseNhinclusivos = claseNhinclusivos;
	}

	public int getClaseNhombres() {
		return this.claseNhombres;
	}

	public void setClaseNhombres(int claseNhombres) {
		this.claseNhombres = claseNhombres;
	}

	public int getClaseNminclusivos() {
		return this.claseNminclusivos;
	}

	public void setClaseNminclusivos(int claseNminclusivos) {
		this.claseNminclusivos = claseNminclusivos;
	}

	public int getClaseNmujeres() {
		return this.claseNmujeres;
	}

	public void setClaseNmujeres(int claseNmujeres) {
		this.claseNmujeres = claseNmujeres;
	}

	public List<ACargo> getACargos() {
		return this.ACargos;
	}

	public void setACargos(List<ACargo> ACargos) {
		this.ACargos = ACargos;
	}

	public ACargo addACargo(ACargo ACargo) {
		getACargos().add(ACargo);
		ACargo.setClase(this);

		return ACargo;
	}

	public ACargo removeACargo(ACargo ACargo) {
		getACargos().remove(ACargo);
		ACargo.setClase(null);

		return ACargo;
	}

	public PeriodoAcademico getPeriodoAcademico() {
		return this.periodoAcademico;
	}

	public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
		this.periodoAcademico = periodoAcademico;
	}

	public Seccion getSeccion() {
		return this.seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Desenvuelve> getDesenvuelves() {
		return this.desenvuelves;
	}

	public void setDesenvuelves(List<Desenvuelve> desenvuelves) {
		this.desenvuelves = desenvuelves;
	}

	public List<Evaluacion> getEvaluacions() {
		return this.evaluacions;
	}

	public void setEvaluacions(List<Evaluacion> evaluacions) {
		this.evaluacions = evaluacions;
	}

	public Evaluacion addEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().add(evaluacion);
		evaluacion.setClase(this);

		return evaluacion;
	}

	public Evaluacion removeEvaluacion(Evaluacion evaluacion) {
		getEvaluacions().remove(evaluacion);
		evaluacion.setClase(null);

		return evaluacion;
	}

}