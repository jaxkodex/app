package org.educando.app.controller;

import java.util.List;

import org.educando.app.model.FormatoEvaluacion;
import org.educando.app.service.FormatoEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MonitoreoController {
	@Autowired FormatoEvaluacionService formatoEvaluacionService;

	@RequestMapping(value="/monitoreo")
	public String index (Model model) {
		List<FormatoEvaluacion> formatos;
		String formatosJSON;
		formatos = formatoEvaluacionService.listAll();
		formatosJSON = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			formatosJSON = mapper.writeValueAsString(formatos);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		model.addAttribute("formatosJSON", formatosJSON);
		return "monitoreo/index";
	}
}
