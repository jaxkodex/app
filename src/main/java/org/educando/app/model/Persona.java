package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="persona_dni")
	private String personaDni;

	@Column(name="persona_amaterno")
	private String personaAmaterno;

	@Column(name="persona_apaterno")
	private String personaApaterno;

	@Column(name="persona_pnombre")
	private String personaPnombre;

	@Column(name="persona_snombre")
	private String personaSnombre;

	//bi-directional many-to-many association to Cargo
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		name="desenvuelve"
		, joinColumns={
			@JoinColumn(name="persona_dni")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_cargo")
			}
		)
	private List<Cargo> cargos;

	//bi-directional many-to-one association to Observador
	@JsonIgnore
	@OneToMany(mappedBy="persona")
	private List<Observador> observadors;

	public Persona() {
	}

	public String getPersonaDni() {
		return this.personaDni;
	}

	public void setPersonaDni(String personaDni) {
		this.personaDni = personaDni;
	}

	public String getPersonaAmaterno() {
		return this.personaAmaterno;
	}

	public void setPersonaAmaterno(String personaAmaterno) {
		this.personaAmaterno = personaAmaterno;
	}

	public String getPersonaApaterno() {
		return this.personaApaterno;
	}

	public void setPersonaApaterno(String personaApaterno) {
		this.personaApaterno = personaApaterno;
	}

	public String getPersonaPnombre() {
		return this.personaPnombre;
	}

	public void setPersonaPnombre(String personaPnombre) {
		this.personaPnombre = personaPnombre;
	}

	public String getPersonaSnombre() {
		return this.personaSnombre;
	}

	public void setPersonaSnombre(String personaSnombre) {
		this.personaSnombre = personaSnombre;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public List<Observador> getObservadors() {
		return this.observadors;
	}

	public void setObservadors(List<Observador> observadors) {
		this.observadors = observadors;
	}

	public Observador addObservador(Observador observador) {
		getObservadors().add(observador);
		observador.setPersona(this);

		return observador;
	}

	public Observador removeObservador(Observador observador) {
		getObservadors().remove(observador);
		observador.setPersona(null);

		return observador;
	}

}