package org.educando.app.service;

import java.util.List;

import org.educando.app.model.Persona;

public interface PersonaService {

	public Persona crear (Persona persona);
	public List<Persona> list ();
	public List<Persona> search (String query);
	public Persona findByDni (String personaDni);

}
