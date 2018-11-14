package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Cliente;

public interface ClienteService {
	Cliente findClienteById(int id) throws DataAccessException;
	Collection<Cliente> findAllClientes() throws DataAccessException;
	void saveCliente(Cliente cliente) throws DataAccessException;
	void deleteCliente(Cliente cliente) throws DataAccessException;
}
