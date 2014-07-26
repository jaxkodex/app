package org.educando.app.controller;

import java.util.List;

import org.educando.app.model.PeriodoAcademico;
import org.educando.app.service.PeriodoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeriodoAcademicoController {
	@Autowired
	PeriodoAcademicoService periodoAcademicoService;
	
	@RequestMapping(value={"/api/admin/periodoacademico"}, method=RequestMethod.GET)
	public @ResponseBody List<PeriodoAcademico> index (@RequestParam(required=false, defaultValue="A") String active,
			@RequestParam(required=false) String all) {
		if (all != null && all.equals("all")) {
			return periodoAcademicoService.listAll();
		}
		boolean periodoActivo = true;
		if (!active.equals("A")) {
			periodoActivo = false;
		}
		return periodoAcademicoService.getActive(periodoActivo);
	}
	
	@RequestMapping(value={"/api/admin/periodoacademico"}, method=RequestMethod.POST)
	public @ResponseBody PeriodoAcademico create (@RequestBody PeriodoAcademico periodoAcademico) {
		return periodoAcademicoService.save(periodoAcademico);
	}
	
	@RequestMapping(value={"/api/admin/periodoacademico/{idPeriodo}"}, method=RequestMethod.PUT)
	public @ResponseBody PeriodoAcademico update (@RequestBody PeriodoAcademico periodoAcademico,
			@PathVariable Integer idPeriodo) {
		return periodoAcademicoService.update(periodoAcademico);
	}
	
	 @RequestMapping(value={"/api/admin/periodoacademico/{idPeriodo}"}, method=RequestMethod.GET)
	 public @ResponseBody PeriodoAcademico load (@PathVariable Integer idPeriodo) {
		 return periodoAcademicoService.load(idPeriodo);
	 }
	
	 @RequestMapping(value={"/api/admin/periodoacademico/{idPeriodo}"}, method=RequestMethod.DELETE)
	 public @ResponseBody void delete (@PathVariable Integer idPeriodo) {
		 periodoAcademicoService.delete(idPeriodo);
	 }

}
