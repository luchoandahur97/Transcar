package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Contrato;

public interface ContratoService {

	Contrato findContratoById(int id) throws DataAccessException;
	Collection<Contrato> findAllContratos() throws DataAccessException;
	void saveContrato(Contrato contrato) throws DataAccessException;
	void deleteContrato(Contrato contrato) throws DataAccessException;
}
