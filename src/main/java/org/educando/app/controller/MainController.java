package org.educando.app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	public static final Logger logger = Logger.getLogger(MainController.class);

	@RequestMapping(value= {"", "index", "index.do"})
	public String index () {
		return "index";
	}
}