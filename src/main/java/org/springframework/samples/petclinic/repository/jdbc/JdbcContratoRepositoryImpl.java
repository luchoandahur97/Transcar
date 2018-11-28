package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Contrato;
import org.springframework.samples.petclinic.repository.ContratoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jdbc")
public class JdbcContratoRepositoryImpl implements ContratoRepository{

	public JdbcContratoRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Contrato findById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Contrato contrato) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Contrato> findAllContratos() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Contrato contrato) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
