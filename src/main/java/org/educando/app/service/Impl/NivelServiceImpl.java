package org.educando.app.service.Impl;

import java.util.List;

import org.educando.app.model.Nivel;
import org.educando.app.repository.NivelRepository;
import org.educando.app.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelServiceImpl implements NivelService {
	@Autowired
	NivelRepository nivelRepository;

	@Override
	public List<Nivel> listAll() {
		return nivelRepository.findAll();
	}

}