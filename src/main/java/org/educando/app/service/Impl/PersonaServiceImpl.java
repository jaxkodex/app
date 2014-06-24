package org.educando.app.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.educando.app.controller.MainController;
import org.educando.app.model.Persona;
import org.educando.app.repository.PersonaRepository;
import org.educando.app.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
	public static final Logger logger = Logger.getLogger(MainController.class);
	@Autowired
	PersonaRepository personaRepository;

	@Override
	public List<Persona> list() {
		return personaRepository.findAll();
	}

	@Override
	public Persona crear(Persona persona) {
		Persona existe = personaRepository.findByPersonaDni(persona.getPersonaDni());
		if (existe == null) {
			personaRepository.save(persona);
			logger.debug("Persona registrada "+persona);
		} else {
			logger.debug("Persona ya existia en la BD, no registrado, obteniendo valor existente "+existe);
			persona = existe;
		}
		return persona;
	}

	@Override
	public List<Persona> search(String query) {
		return personaRepository.search(query);
	}

	@Override
	public Persona findByDni(String personaDni) {
		return personaRepository.findByPersonaDni(personaDni);
	}

}
