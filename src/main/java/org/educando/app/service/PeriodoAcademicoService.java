package org.educando.app.service;

import java.util.List;

import org.educando.app.model.PeriodoAcademico;

public interface PeriodoAcademicoService {
	
	public PeriodoAcademico load(Integer idPeriodo);
	public List<PeriodoAcademico> listAll();
	public List<PeriodoAcademico> getActive(boolean active);
	public PeriodoAcademico save(PeriodoAcademico periodoAcademico);
	public PeriodoAcademico update(PeriodoAcademico periodoAcademico);
	public void delete(Integer idPeriodo);

}
