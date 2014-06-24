package org.educando.app.repository;

import org.educando.app.model.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradoRepository extends JpaRepository<Grado, Integer> {
	
	public Grado findByIdGrado (Integer idGrado);

}
