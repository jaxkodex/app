package org.educando.app.repository;

import org.educando.app.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	public Cargo findByIdCargo (Integer idCargo);

}
