package org.educando.app.controller;

import java.util.List;
import java.util.Map;

public interface BaseCrudApiController<T, ID> {
	
	public List<T> list ();
	public T load (ID id);
	public T create (T object);
	public T update (ID id, T object);
	public Map<String, Object> delete (ID id);

}
