package org.educando.app.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.educando.app.model.InstitucionEducativa;
import org.educando.app.repository.InstitucionEducativaRepository;
import org.educando.app.service.InstitucionEducativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitucionEducativaServiceImpl implements
		InstitucionEducativaService {
	private static final Logger logger = Logger.getLogger(InstitucionEducativaServiceImpl.class);
	
	@Autowired
	InstitucionEducativaRepository institucionEducativaRepository;

	@Override
	public List<InstitucionEducativa> buscaPorNombre(String nombre) {
		return institucionEducativaRepository.findByInstitucionNombre(nombre);
	}

	@Transactional
	@Override
	public InstitucionEducativa crear(InstitucionEducativa institucionEducativa) {
		logger.debug("Registrando Institucion educativa "+institucionEducativa);
		institucionEducativaRepository.save(institucionEducativa);
		return institucionEducativa;
	}

}
