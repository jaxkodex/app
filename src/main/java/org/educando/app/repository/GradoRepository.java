package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.Grado;
import org.educando.app.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradoRepository extends JpaRepository<Grado, Integer> {
	
	public List<Grado> findByNivel (Nivel nivel);

}
