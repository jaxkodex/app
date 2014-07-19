package org.educando.app.service.Impl;

import java.util.List;

import org.educando.app.model.Grado;
import org.educando.app.model.Seccion;
import org.educando.app.repository.SeccionRepository;
import org.educando.app.service.SeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionServiceImpl implements SeccionService {
	@Autowired
	SeccionRepository seccionRepository;

	@Override
	public List<Seccion> listAll() {
		return seccionRepository.findAll();
	}

	@Override
	public Seccion create(Seccion seccion) {
		return seccionRepository.save(seccion);
	}

	@Override
	public Seccion update(Seccion seccion) {
		return seccionRepository.save(seccion);
	}

	@Override
	public Seccion load(Integer id) {
		return seccionRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		seccionRepository.delete(id);
	}

	@Override
	public List<Seccion> getSeccionByGrado(Grado grado) {
		return seccionRepository.findByGrado(grado);
	}

}
