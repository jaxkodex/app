package org.educando.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rol;

	@Column(name="rol_descripcion")
	private String rolDescripcion;

	//bi-directional many-to-many association to Usuario
	@ManyToMany
	@JoinTable(
		name="usuario_has_role"
		, joinColumns={
			@JoinColumn(name="rol")
			}
		, inverseJoinColumns={
			@JoinColumn(name="username")
			}
		)
	private List<Usuario> usuarios;

	public Role() {
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}