package org.educando.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.educando.app.model.InstitucionEducativa;
import org.educando.app.service.InstitucionEducativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/institucion")
public class InstitucionEducativaController {
	public static final Logger logger = Logger.getLogger(InstitucionEducativaController.class);
	@Autowired
	InstitucionEducativaService institucionEducativaService;

	@RequestMapping(value= "", method=RequestMethod.POST)
	@ResponseBody
	public InstitucionEducativa create (@RequestBody InstitucionEducativa institucionEducativa) {
		logger.debug("Guardando objeto "+institucionEducativa);
		institucionEducativaService.crear(institucionEducativa);
		return institucionEducativa;
	}

	@RequestMapping(value= "", method=RequestMethod.GET)
	@ResponseBody
	public List<InstitucionEducativa> list () {
		logger.debug("Listando objetos");
		return institucionEducativaService.buscaPorNombre("");
	}

	@RequestMapping(value= "", method=RequestMethod.PUT)
	@ResponseBody
	public InstitucionEducativa update (@RequestBody InstitucionEducativa institucionEducativa) {
		logger.debug("Actualizando ie");
		return institucionEducativa;
	}

	@RequestMapping(value= "", method=RequestMethod.DELETE)
	@ResponseBody
	public boolean update (@RequestParam(required=true) Integer id) {
		logger.debug("Actualizando ie");
		return true;
	}
}
