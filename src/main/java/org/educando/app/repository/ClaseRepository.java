package org.educando.app.repository;

import org.educando.app.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {
	
	public Clase findByIdClase (Integer idClase);

}
