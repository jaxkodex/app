package org.educando.app.repository;

import org.educando.app.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepository extends JpaRepository<Seccion, Integer> {
	
	public Seccion findByIdSeccion (Integer idSeccion);

}
