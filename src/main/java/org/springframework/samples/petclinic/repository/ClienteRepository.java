package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Cliente;

public interface ClienteRepository {


	Cliente findById(int id) throws DataAccessException;
    void save(Cliente cliente) throws DataAccessException;   
	Collection<Cliente> findAll() throws DataAccessException;	
	void delete(Cliente cliente) throws DataAccessException;
	
}