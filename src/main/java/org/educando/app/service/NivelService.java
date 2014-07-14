package org.educando.app.service;

import java.util.List;

import org.educando.app.model.Nivel;

public interface NivelService {
	
	public List<Nivel> listAll ();

	public Nivel create(Nivel nivel);
	public Nivel update(Nivel nivel);

}
