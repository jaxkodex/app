package org.educando.app.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseCrudService<T, IdClass extends Serializable, Repo extends JpaRepository<T, IdClass>> extends BaseService<T, IdClass> {

}
