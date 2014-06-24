package org.educando.app.service;

import java.util.List;

import org.educando.app.model.InstitucionEducativa;

public interface InstitucionEducativaService {
	
	public InstitucionEducativa crear (InstitucionEducativa institucionEducativa);
	public List<InstitucionEducativa> buscaPorNombre (String nombre);

}
