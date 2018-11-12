package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Chofer;

public interface ChoferService {

	Chofer findChoferById(int id) throws DataAccessException;
	Collection<Chofer> findAllChoferes() throws DataAccessException;
	void saveChofer(Chofer chofer) throws DataAccessException;
	void deleteChofer(Chofer chofer) throws DataAccessException;
}
