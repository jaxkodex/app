package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AreaPK id;

	@Column(name="area_descripcion")
	private String areaDescripcion;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	@JoinColumn(name="id_grado")
	private Grado grado;

	public Area() {
	}

	public AreaPK getId() {
		return this.id;
	}

	public void setId(AreaPK id) {
		this.id = id;
	}

	public String getAreaDescripcion() {
		return this.areaDescripcion;
	}

	public void setAreaDescripcion(String areaDescripcion) {
		this.areaDescripcion = areaDescripcion;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

}