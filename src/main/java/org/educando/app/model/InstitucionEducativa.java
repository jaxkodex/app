package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the institucion_educativa database table.
 * 
 */
@Entity
@Table(name="institucion_educativa")
@NamedQuery(name="InstitucionEducativa.findAll", query="SELECT i FROM InstitucionEducativa i")
public class InstitucionEducativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_institucion")
	private int idInstitucion;

	@Column(name="institucion_activo")
	private byte institucionActivo;

	@Column(name="institucion_lema")
	private String institucionLema;

	@Column(name="institucion_nombre")
	private String institucionNombre;

	//bi-directional many-to-one association to Nivel
	@JsonIgnore
	@OneToMany(mappedBy="institucionEducativa")
	private List<Nivel> nivels;

	public InstitucionEducativa() {
	}

	public int getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(int idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public byte getInstitucionActivo() {
		return this.institucionActivo;
	}

	public void setInstitucionActivo(byte institucionActivo) {
		this.institucionActivo = institucionActivo;
	}

	public String getInstitucionLema() {
		return this.institucionLema;
	}

	public void setInstitucionLema(String institucionLema) {
		this.institucionLema = institucionLema;
	}

	public String getInstitucionNombre() {
		return this.institucionNombre;
	}

	public void setInstitucionNombre(String institucionNombre) {
		this.institucionNombre = institucionNombre;
	}

	public List<Nivel> getNivels() {
		return this.nivels;
	}

	public void setNivels(List<Nivel> nivels) {
		this.nivels = nivels;
	}

	public Nivel addNivel(Nivel nivel) {
		getNivels().add(nivel);
		nivel.setInstitucionEducativa(this);

		return nivel;
	}

	public Nivel removeNivel(Nivel nivel) {
		getNivels().remove(nivel);
		nivel.setInstitucionEducativa(null);

		return nivel;
	}

}