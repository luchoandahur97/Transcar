package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.servicioFlete;


public interface servicioFleteService {

	servicioFlete findServicioFleteById(int id) throws DataAccessException;// se busca por id servicio
	Collection<servicioFlete> findAllServicioFlete() throws DataAccessException;
	void saveServicioFlete(servicioFlete servicioF) throws DataAccessException;
	void deleteServicioFlete(servicioFlete serivicioF) throws DataAccessException;
	
	
}
