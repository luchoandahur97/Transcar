package org.springframework.samples.petclinic.repository.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.repository.ClienteRepository;

public class JdbcClienteRepositoryImpl implements ClienteRepository {

	public JdbcClienteRepositoryImpl()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Cliente cliente) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
