package org.educando.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.educando.app.model.Cargo;
import org.educando.app.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CargoController {
	public static final Logger logger = Logger.getLogger(CargoController.class);
	@Autowired
	CargoService cargoService;

	@RequestMapping(value="/api/admin/cargo", method=RequestMethod.GET)
	@ResponseBody
	public List<Cargo> index (@RequestParam(required=false) String query,
			@RequestParam(required=false, defaultValue="A") String active) {
		if (query == null && active.equals("A")) return cargoService.listActive();
		return cargoService.listActive();
	}


	@RequestMapping(value= "/api/admin/cargo/{idCargo}", method=RequestMethod.GET)
	@ResponseBody
	public Cargo load (@PathVariable Integer idCargo) {
		logger.debug("Load Object");
		return cargoService.load(idCargo);
	}


	@RequestMapping(value= "/api/admin/cargo/{idCargo}", method=RequestMethod.DELETE)
	@ResponseBody
	public void delete (@PathVariable Integer idCargo) {
		cargoService.delete(idCargo);
	}


	@RequestMapping(value= "/api/admin/cargo", method=RequestMethod.POST)
	@ResponseBody
	public Cargo create (@RequestBody Cargo cargo) {
		return cargoService.create(cargo);
	}


	@RequestMapping(value= "{idCargo}", method=RequestMethod.PUT)
	@ResponseBody
	public Cargo update (@RequestBody Cargo cargo) {
		return cargoService.update(cargo);
	}
}
