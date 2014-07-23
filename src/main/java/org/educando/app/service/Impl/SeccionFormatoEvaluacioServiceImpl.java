package org.educando.app.service.Impl;

import org.educando.app.model.SeccionEvaluacion;
import org.educando.app.repository.SeccionFormatoEvaluacionRepository;
import org.educando.app.service.SeccionFormatoEvaluacionService;
import org.springframework.stereotype.Service;

@Service
public class SeccionFormatoEvaluacioServiceImpl extends BaseCrudServiceImpl<SeccionEvaluacion, Integer, SeccionFormatoEvaluacionRepository> implements SeccionFormatoEvaluacionService {

	@Override
	public SeccionEvaluacion create(SeccionEvaluacion seccionEvaluacion) {
		return repo.save(seccionEvaluacion);
	}

	@Override
	public SeccionEvaluacion update(SeccionEvaluacion seccionEvaluacion) {
		return repo.save(seccionEvaluacion);
	}
	

}
