package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Contrato;

public interface ContratoRepository {

	Contrato findById(int id) throws DataAccessException;
    void save(Contrato contrato) throws DataAccessException;   
	Collection<Contrato> findAllContratos() throws DataAccessException;	
	void delete(Contrato contrato) throws DataAccessException;
}
