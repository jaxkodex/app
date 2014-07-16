package org.educando.app.service;

import java.util.List;

public interface BaseService<T, ID> {
	
	public List<T> listAll();
	public T create(T object);
	public T update(T object);
	public T load(ID id);
	public void delete(ID id);

}
