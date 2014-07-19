package org.educando.app.service.Impl;

import java.io.Serializable;
import java.util.List;

import org.educando.app.service.BaseCrudService;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseCrudServiceImpl<T, ID extends Serializable, Repo extends JpaRepository<T, ID>> implements BaseCrudService<T, ID, Repo> {
	Repo repo;

	@Override
	public List<T> listAll() {
		return repo.findAll();
	}

	@Override
	public T load(ID id) {
		return repo.findOne(id);
	}

	@Override
	public void delete(ID id) {
		repo.delete(id);
	}

}
