package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer> {

	public List<Evaluacion> findByObservadorIdObservador(Integer idObservador);
}
