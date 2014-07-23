package org.educando.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.educando.app.model.SeccionEvaluacion;
import org.educando.app.service.SeccionFormatoEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class SeccionFormatoMonitoreoController implements BaseCrudApiController<SeccionEvaluacion, Integer> {
	@Autowired SeccionFormatoEvaluacionService seccionFormatoEvaluacionService;

	@RequestMapping(value="/admin/fichamonitoreo/seccion", method=RequestMethod.GET)
	@Override
	public @ResponseBody List<SeccionEvaluacion> list() {
		return seccionFormatoEvaluacionService.listAll();
	}

	@RequestMapping(value="/admin/fichamonitoreo/seccion/{idSeccion}", method=RequestMethod.GET)
	@Override
	public @ResponseBody SeccionEvaluacion load(@PathVariable Integer idSeccion) {
		return seccionFormatoEvaluacionService.load(idSeccion);
	}

	@RequestMapping(value="/admin/fichamonitoreo/seccion", method=RequestMethod.POST)
	@Override
	public @ResponseBody SeccionEvaluacion create(@RequestBody SeccionEvaluacion seccionEvaluacion) {
		return seccionFormatoEvaluacionService.create(seccionEvaluacion);
	}

	@RequestMapping(value="/admin/fichamonitoreo/seccion/{idSeccion}", method=RequestMethod.PUT)
	@Override
	public @ResponseBody SeccionEvaluacion update(@PathVariable Integer idSeccion, @RequestBody SeccionEvaluacion seccionEvaluacion) {
		return seccionFormatoEvaluacionService.update(seccionEvaluacion);
	}

	@RequestMapping(value="/admin/fichamonitoreo/seccion/{idSeccion}", method=RequestMethod.DELETE)
	@Override
	public @ResponseBody Map<String, Object> delete(@PathVariable Integer idSeccion) {
		Map<String, Object> m = new HashMap<String, Object>();
		seccionFormatoEvaluacionService.delete(idSeccion);
		m.put("success", true);
		return m;
	}

}
