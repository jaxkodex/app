package org.educando.app.repository;

import java.util.List;

import org.educando.app.model.PeriodoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoAcademicoRepository extends JpaRepository<PeriodoAcademico, Integer> {

	public List<PeriodoAcademico> findByPeriodoActivo (boolean periodoActivo);
}
