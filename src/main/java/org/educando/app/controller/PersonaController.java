package org.educando.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.educando.app.model.Persona;
import org.educando.app.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonaController {
	public static final Logger logger = Logger.getLogger(MainController.class);
	@Autowired
	PersonaService personaService;
	

	@RequestMapping(value="/api/admin/persona", method=RequestMethod.POST)
	public @ResponseBody Persona create (@RequestBody Persona persona) {
		personaService.crear(persona);
		return persona;
	}

	@RequestMapping(value="/api/admin/persona", method=RequestMethod.GET)
	public @ResponseBody List<Persona> search (@RequestParam(required=false, defaultValue="") String query) {
		return personaService.search(query);
	}

	@RequestMapping(value="/api/admin/persona/{dni}", method=RequestMethod.GET)
	public @ResponseBody Persona loadPersona (@PathVariable String dni) {
		return personaService.findByDni(dni);
	}
}
