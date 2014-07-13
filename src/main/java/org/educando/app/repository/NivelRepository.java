package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.InstitucionEducativa;
import org.educando.app.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NivelRepository extends JpaRepository<Nivel, Integer> {
	
	public List<Nivel> findByInstitucionEducativa (InstitucionEducativa institucionEducativa);

}
