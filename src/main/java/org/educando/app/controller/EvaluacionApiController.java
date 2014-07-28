package org.educando.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.educando.app.model.Evaluacion;
import org.educando.app.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvaluacionApiController {
	@Autowired EvaluacionService evaluacionService;

	@RequestMapping(value="/api/evaluacion", method=RequestMethod.GET)
	public @ResponseBody List<Evaluacion> publicApiList (@RequestParam(required=false) Integer idObservador) {
		if (idObservador != null) return evaluacionService.listByObservadorId(idObservador);
		return evaluacionService.listAll();
	}

	@RequestMapping(value="/api/admin/evaluacion", method=RequestMethod.POST)
	public @ResponseBody Evaluacion privateApiCreate (@RequestBody Evaluacion evaluacion) {
		return evaluacionService.create(evaluacion);
	}

	@RequestMapping(value="/api/admin/evaluacion/{idEvaluacion}", method=RequestMethod.PUT)
	public @ResponseBody Evaluacion privateApiUpdate (@RequestBody Evaluacion evaluacion, @PathVariable Integer idEvaluacion) {
		return evaluacionService.create(evaluacion);
	}

	@RequestMapping(value="/api/admin/evaluacion/{idEvaluacion}", method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> privateApiDelete (@PathVariable Integer idEvaluacion) {
		Map<String, Object> map = new HashMap<String, Object>();
		evaluacionService.delete(idEvaluacion);
		map.put("success", true);
		return map;
	}
}
