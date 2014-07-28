package org.educando.app.service.Impl;

import java.util.List;

import org.educando.app.model.Evaluacion;
import org.educando.app.repository.EvaluacionRepository;
import org.educando.app.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {
	@Autowired EvaluacionRepository evaluacionRepository;

	@Override
	public List<Evaluacion> listAll() {
		return evaluacionRepository.findAll();
	}

	@Override
	public Evaluacion create(Evaluacion evaluacion) {
		return evaluacionRepository.save(evaluacion);
	}

	@Override
	public Evaluacion update(Evaluacion evaluacion) {
		return evaluacionRepository.save(evaluacion);
	}

	@Override
	public Evaluacion load(Integer id) {
		return evaluacionRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		evaluacionRepository.delete(id);
	}

	@Override
	public List<Evaluacion> listByObservadorId(Integer idObservador) {
		return evaluacionRepository.findByObservadorIdObservador(idObservador);
	}

}
