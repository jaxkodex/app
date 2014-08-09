package org.educando.app.controller;

import org.educando.app.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioApiController {
	
	@RequestMapping(value="/api/me", method=RequestMethod.GET)
	public @ResponseBody Usuario getUsuario () {
		Usuario usuario = null;
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof Usuario) {
			usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return usuario;
	}

}
