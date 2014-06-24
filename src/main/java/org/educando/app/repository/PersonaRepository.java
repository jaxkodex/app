package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
	
	public List<Persona> findAll ();
	public Persona findByPersonaDni (String personaDni);
	@Query("SELECT p FROM Persona p where p.personaDni like %:query% or p.personaNombreCompleto like %:query%")
	public List<Persona> search (@Param("query") String query);
}
