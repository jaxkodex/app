package org.educando.app.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private boolean habilitado;

	private String password;

	@Column(name="persona_dni")
	private String personaDni;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="usuarios", fetch=FetchType.EAGER)
	private List<Role> roles;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="usuarios")
	private List<InstitucionEducativa> institucionEducativas;

	public Usuario() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean getHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonaDni() {
		return this.personaDni;
	}

	public void setPersonaDni(String personaDni) {
		this.personaDni = personaDni;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role rol : this.roles) {
			authorities.add(new SimpleGrantedAuthority(rol.getRol()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return this.habilitado;
	}

}