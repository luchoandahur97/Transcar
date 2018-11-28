package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository=clienteRepository;
	}

	@Override
	@Transactional
	public void saveCliente(Cliente cliente) throws DataAccessException {
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findClienteById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Cliente cliente = null;
		try {
			cliente = clienteRepository.findById(id);
		}catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return cliente;
	}

	@Override
	public Collection<Cliente> findAllClientes() throws DataAccessException {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public void deleteCliente(Cliente cliente) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
}
