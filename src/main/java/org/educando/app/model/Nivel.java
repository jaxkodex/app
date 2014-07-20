package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nivel")
	private int idNivel;

	@Column(name="nivel_nombre")
	private String nivelNombre;

	//bi-directional many-to-one association to Grado
	@JsonIgnore
	@OneToMany(mappedBy="nivel")
	private List<Grado> grados;

	//bi-directional many-to-one association to InstitucionEducativa
	@ManyToOne
	@JoinColumn(name="id_institucion")
	private InstitucionEducativa institucionEducativa;

	public Nivel() {
	}

	public int getIdNivel() {
		return this.idNivel;
	}

	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}

	public String getNivelNombre() {
		return this.nivelNombre;
	}

	public void setNivelNombre(String nivelNombre) {
		this.nivelNombre = nivelNombre;
	}

	public List<Grado> getGrados() {
		return this.grados;
	}

	public void setGrados(List<Grado> grados) {
		this.grados = grados;
	}

	public Grado addGrado(Grado grado) {
		getGrados().add(grado);
		grado.setNivel(this);

		return grado;
	}

	public Grado removeGrado(Grado grado) {
		getGrados().remove(grado);
		grado.setNivel(null);

		return grado;
	}

	public InstitucionEducativa getInstitucionEducativa() {
		return this.institucionEducativa;
	}

	public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
		this.institucionEducativa = institucionEducativa;
	}

}