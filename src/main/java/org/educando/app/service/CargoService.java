package org.educando.app.service;

import java.util.List;

import org.educando.app.model.Cargo;

public interface CargoService {
	
	public List<Cargo> search (String query);
	public List<Cargo> listActive ();
	public Cargo load (Integer idCargo);
	public Cargo create (Cargo cargo);
	public Cargo update (Cargo cargo);
	public void delete (Integer idCargo); 

}
