package org.educando.app.service.Impl;

import org.educando.app.model.FormatoEvaluacion;
import org.educando.app.repository.FormatoEvaluacionRepository;
import org.educando.app.service.FormatoEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatoEvaluacionServiceImpl extends BaseCrudServiceImpl<FormatoEvaluacion, Integer, FormatoEvaluacionRepository> implements FormatoEvaluacionService {

	@Override
	public FormatoEvaluacion create(FormatoEvaluacion formatoEvaluacion) {
		return repo.save(formatoEvaluacion);
	}

	@Override
	public FormatoEvaluacion update(FormatoEvaluacion formatoEvaluacion) {
		return repo.save(formatoEvaluacion);
	}

}
