package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

	
	public List<Cargo> findByActivo (boolean activo);

}
