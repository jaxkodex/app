package org.educando.app.repository;

import org.educando.app.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno, Integer> {
	
	public Turno findByIdTurno (Integer idTurno);

}
