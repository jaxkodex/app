package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.InstitucionEducativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstitucionEducativaRepository extends JpaRepository<InstitucionEducativa, Integer> {
	
	
	List<InstitucionEducativa> findByIdInstitucion (Integer idInstitucion);
	
	@Query("SELECT i FROM InstitucionEducativa i where i.institucionNombre like %:nombre%")
	List<InstitucionEducativa> findByInstitucionNombre (@Param("nombre") String nombre);
	
}
