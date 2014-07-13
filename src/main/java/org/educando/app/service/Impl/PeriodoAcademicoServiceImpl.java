package org.educando.app.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.educando.app.model.PeriodoAcademico;
import org.educando.app.repository.PeriodoAcademicoRepository;
import org.educando.app.service.PeriodoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
	
	public static final Logger logger = Logger.getLogger(PeriodoAcademicoServiceImpl.class);
	
	@Autowired
	PeriodoAcademicoRepository periodoAcademicoRepository;

	@Override
	public List<PeriodoAcademico> listAll() {
		return periodoAcademicoRepository.findAll();
	}

	@Override
	public List<PeriodoAcademico> getActive(boolean active) {
		return periodoAcademicoRepository.findByPeriodoActivo(active);
	}

	@Override
	public PeriodoAcademico save(PeriodoAcademico periodoAcademico) {
		return periodoAcademicoRepository.save(periodoAcademico);
	}

	@Override
	public PeriodoAcademico update(PeriodoAcademico periodoAcademico) {
		return periodoAcademicoRepository.save(periodoAcademico);
	}

	@Override
	public void delete(Integer idPeriodo) {
		logger.debug("Eliminando Periodo Academico ID: "+idPeriodo);
		periodoAcademicoRepository.delete(idPeriodo);
	}

	@Override
	public PeriodoAcademico load(Integer idPeriodo) {
		logger.debug("Cargando datos de Periodo Academico ID: "+idPeriodo);
		return periodoAcademicoRepository.findOne(idPeriodo);
	}

}
