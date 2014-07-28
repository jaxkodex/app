package org.educando.app.service;

import java.util.List;

import org.educando.app.model.Evaluacion;

public interface EvaluacionService extends BaseService<Evaluacion, Integer> {
	
	public List<Evaluacion> listByObservadorId (Integer idObservador);

}
