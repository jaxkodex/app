package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {
	
	public List<Clase> findByPeriodoAcademicoIdPeriodo (Integer idPeriodo);

}
