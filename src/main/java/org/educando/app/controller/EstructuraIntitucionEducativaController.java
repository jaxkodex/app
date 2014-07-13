package org.educando.app.controller;

import java.util.List;

import org.educando.app.model.Nivel;
import org.educando.app.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/estructuraie")
public class EstructuraIntitucionEducativaController {
	@Autowired
	NivelService nivelService;
	
	@RequestMapping(value="/nivel", method=RequestMethod.GET)
	public @ResponseBody List<Nivel> indexNivel () {
		return nivelService.listAll();
	}

}
