package org.educando.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.educando.app.model.Grado;
import org.educando.app.model.Nivel;
import org.educando.app.service.GradoService;
import org.educando.app.service.NivelService;
import org.educando.app.service.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/estructuraie")
public class EstructuraIntitucionEducativaController {
	@Autowired NivelService nivelService;
	@Autowired GradoService gradoService;
	@Autowired SeccionService seccionService;
	
	@RequestMapping(value="/nivel", method=RequestMethod.GET)
	public @ResponseBody List<Nivel> indexNivel () {
		return nivelService.listAll();
	}
	
	@RequestMapping(value="/nivel", method=RequestMethod.POST)
	public @ResponseBody Nivel create (@RequestBody Nivel nivel) {
		return nivelService.create(nivel);
	}
	
	@RequestMapping(value="/nivel/{idNivel}", method=RequestMethod.PUT)
	public @ResponseBody Nivel update (@RequestBody Nivel nivel, @PathVariable Integer idNivel) {
		return nivelService.update(nivel);
	}
	
	@RequestMapping(value="/nivel/{idNivel}", method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> apiDelete (@PathVariable Integer idNivel) {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("success", true);
		nivelService.delete(idNivel);
		return m;
	}
	
	@RequestMapping(value="/grado", method=RequestMethod.GET)
	public @ResponseBody List<Grado> indexGrado (@RequestParam(required=false) Integer idNivel) {
		if (idNivel == null) return gradoService.getGradoByNivel(nivelService.load(idNivel));
		return gradoService.listAll();
	}
	
	@RequestMapping(value="/grado", method=RequestMethod.POST)
	public @ResponseBody Grado createGrado (@RequestBody Grado grado) {
		return gradoService.create(grado);
	}
	
	@RequestMapping(value="/grado/{idGrado}", method=RequestMethod.PUT)
	public @ResponseBody Grado updateGrado (@RequestBody Grado grado, @PathVariable Integer idGrado) {
		return gradoService.update(grado);
	}

}
