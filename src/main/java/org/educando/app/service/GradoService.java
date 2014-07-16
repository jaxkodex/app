package org.educando.app.service;

import java.util.List;

import org.educando.app.model.Grado;
import org.educando.app.model.Nivel;

public interface GradoService extends BaseService<Grado, Integer> {

	public List<Grado> getGradoByNivel(Nivel nivel);

}
