package org.educando.app.service;

import java.util.List;

import org.educando.app.model.Grado;
import org.educando.app.model.Seccion;

public interface SeccionService extends BaseService<Seccion, Integer> {
	
	public List<Seccion> getSeccionByGrado (Grado grado);

}
