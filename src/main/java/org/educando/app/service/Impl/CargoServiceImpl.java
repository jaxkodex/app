package org.educando.app.service.Impl;

import java.util.List;

import org.educando.app.model.Cargo;
import org.educando.app.repository.CargoRepository;
import org.educando.app.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImpl implements CargoService {
	@Autowired
	CargoRepository cargoRepository;

	@Override
	public List<Cargo> search(String query) {
		return cargoRepository.findAll();
	}

	@Override
	public List<Cargo> listActive() {
		return cargoRepository.findByActivo(true);
	}

	@Override
	public Cargo create(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	@Override
	public Cargo update(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	@Override
	public void delete(Integer idCargo) {
		cargoRepository.delete(idCargo);
	}

	@Override
	public Cargo load(Integer idCargo) {
		return cargoRepository.findOne(idCargo);
	}

}
