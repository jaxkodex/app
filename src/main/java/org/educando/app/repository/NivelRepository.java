package org.educando.app.repository;

import org.educando.app.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NivelRepository extends JpaRepository<Nivel, Integer> {
	
	public Nivel findByIdNivel (Integer idNivel);

}
