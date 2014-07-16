package org.educando.app.service.Impl;

import java.util.List;

import org.educando.app.model.Grado;
import org.educando.app.model.Nivel;
import org.educando.app.repository.GradoRepository;
import org.educando.app.service.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradoServiceImpl implements GradoService {
	@Autowired
	GradoRepository gradoRepository;

	@Override
	public List<Grado> listAll() {
		return gradoRepository.findAll();
	}

	@Override
	public Grado create(Grado grado) {
		return gradoRepository.save(grado);
	}

	@Override
	public Grado update(Grado grado) {
		return gradoRepository.save(grado);
	}

	@Override
	public Grado load(Integer id) {
		return gradoRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		gradoRepository.delete(id);
	}

	@Override
	public List<Grado> getGradoByNivel(Nivel nivel) {
		return gradoRepository.findByNivel(nivel);
	}

}
