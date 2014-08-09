package org.educando.app.service.Impl;

import org.educando.app.model.Criterio;
import org.educando.app.model.FormatoEvaluacion;
import org.educando.app.model.Opcion;
import org.educando.app.model.SeccionEvaluacion;
import org.educando.app.repository.FormatoEvaluacionRepository;
import org.educando.app.service.FormatoEvaluacionService;
import org.springframework.stereotype.Service;

@Service
public class FormatoEvaluacionServiceImpl extends BaseCrudServiceImpl<FormatoEvaluacion, Integer, FormatoEvaluacionRepository> implements FormatoEvaluacionService {

	@Override
	public FormatoEvaluacion create(FormatoEvaluacion formatoEvaluacion) {
		for (SeccionEvaluacion seccion : formatoEvaluacion.getSeccionEvaluacions()) {
			if (seccion == null) continue;
			seccion.setFormatoEvaluacion(formatoEvaluacion);
			for (Criterio criterio : seccion.getCriterios()) {
				if (criterio == null) continue;
				criterio.setSeccionEvaluacion(seccion);
				for (Opcion opcion : criterio.getOpcions()) {
					if (opcion == null) continue;
					opcion.setCriterio(criterio);
				}
			}
		}
		return repo.save(formatoEvaluacion);
	}

	@Override
	public FormatoEvaluacion update(FormatoEvaluacion formatoEvaluacion) {
		for (SeccionEvaluacion seccion : formatoEvaluacion.getSeccionEvaluacions()) {
			if (seccion == null) continue;
			seccion.setFormatoEvaluacion(formatoEvaluacion);
			for (Criterio criterio : seccion.getCriterios()) {
				if (criterio == null) continue;
				criterio.setSeccionEvaluacion(seccion);
				for (Opcion opcion : criterio.getOpcions()) {
					if (opcion == null) continue;
					opcion.setCriterio(criterio);
				}
			}
		}
		return repo.save(formatoEvaluacion);
	}

}
