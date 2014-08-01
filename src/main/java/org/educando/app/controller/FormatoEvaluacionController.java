package org.educando.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.educando.app.model.FormatoEvaluacion;
import org.educando.app.service.FormatoEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class FormatoEvaluacionController implements BaseCrudApiController<FormatoEvaluacion, Integer> {
	private final Logger logger = Logger.getLogger(FormatoEvaluacion.class);
	@Autowired
	FormatoEvaluacionService formatoEvaluacionService;

	@RequestMapping(value={"/admin/fichamonitoreo"}, method=RequestMethod.GET)
	@Override
	public @ResponseBody List<FormatoEvaluacion> list() {
		logger.info(new Date());
		List<FormatoEvaluacion> formatos = formatoEvaluacionService.listAll();
		logger.info(new Date());
		return formatos;
	}

	@RequestMapping(value={"/admin/fichamonitoreo/{idFormato}"}, method=RequestMethod.GET)
	@Override
	public @ResponseBody FormatoEvaluacion load(@PathVariable Integer idFormato) {
		return formatoEvaluacionService.load(idFormato);
	}

	@RequestMapping(value={"/admin/fichamonitoreo"}, method=RequestMethod.POST)
	@Override
	public @ResponseBody FormatoEvaluacion create(@RequestBody FormatoEvaluacion formatoEvaluacion) {
		return formatoEvaluacionService.create(formatoEvaluacion);
	}

	@RequestMapping(value={"/admin/fichamonitoreo/{idFormato}"}, method=RequestMethod.PUT)
	@Override
	public @ResponseBody FormatoEvaluacion update(@PathVariable Integer idFormato, @RequestBody FormatoEvaluacion formatoEvaluacion) {
		return formatoEvaluacionService.update(formatoEvaluacion);
	}

	@RequestMapping(value={"/admin/fichamonitoreo/{idFormato}"}, method=RequestMethod.DELETE)
	@Override
	public @ResponseBody Map<String, Object> delete(@PathVariable Integer idFormato) {
		Map<String, Object> m = new HashMap<String, Object>();
		formatoEvaluacionService.delete(idFormato);
		m.put("success", true);
		return m;
	}
}
