package org.educando.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
	
	@RequestMapping(value={"/auth/login.do", "/auth/login"})
	public String login () {
		return "auth/login";
	}

}
