package org.educando.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.educando.app.model.InstitucionEducativa;
import org.educando.app.service.InstitucionEducativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InstitucionEducativaController {
	public static final Logger logger = Logger.getLogger(InstitucionEducativaController.class);
	@Autowired
	InstitucionEducativaService institucionEducativaService;

	@RequestMapping(value= "/api/admin/institucion", method=RequestMethod.POST)
	@ResponseBody
	public InstitucionEducativa create (@RequestBody InstitucionEducativa institucionEducativa) {
		logger.debug("Guardando objeto "+institucionEducativa);
		institucionEducativaService.crear(institucionEducativa);
		return institucionEducativa;
	}

	@RequestMapping(value= "/api/admin/institucion/{idInstitucion}", method=RequestMethod.GET)
	@ResponseBody
	public InstitucionEducativa load (@PathVariable Integer idInstitucion) {
		logger.debug("Load Object");
		return institucionEducativaService.loadById(idInstitucion);
	}

	@RequestMapping(value= "/api/admin/institucion", method=RequestMethod.GET)
	@ResponseBody
	public List<InstitucionEducativa> list (@RequestParam(defaultValue="", required=false) String query) {
		logger.debug("Listando objetos");
		return institucionEducativaService.buscaPorNombre(query);
	}

	@RequestMapping(value= "/api/admin/institucion/{idInstitucion}", method=RequestMethod.PUT)
	@ResponseBody
	public InstitucionEducativa update (@RequestBody InstitucionEducativa institucionEducativa, @PathVariable Integer idInstitucion) {
		logger.debug("Actualizando ie");
		institucionEducativaService.update(institucionEducativa);
		return institucionEducativa;
	}

	@RequestMapping(value= "/api/admin/institucion/{idInstitucion}", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete (@PathVariable Integer idInstitucion) {
		logger.debug("Actualizando ie");
		institucionEducativaService.delete(idInstitucion);
	}
}
