package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.servicioFlete;

public interface servicioFleteRepository {
	servicioFlete findServicioFleteById(int id) throws DataAccessException;// se busca por id servicio
	Collection<servicioFlete> findAllServicioFlete() throws DataAccessException;
	void saveServicioFlete(servicioFlete servicioF) throws DataAccessException;
	void deleteServicioFlete(servicioFlete serivicioF) throws DataAccessException;
}
