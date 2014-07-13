package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.Grado;
import org.educando.app.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepository extends JpaRepository<Seccion, Integer> {
	
	public List<Seccion> findByGrado (Grado grado);

}
