package org.educando.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value={"", "/index.do"})
	public String index () {
		return "admin/index";
	} 
}
