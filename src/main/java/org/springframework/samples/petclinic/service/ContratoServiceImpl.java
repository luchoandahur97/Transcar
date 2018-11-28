package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.Contrato;
import org.springframework.samples.petclinic.repository.ClienteRepository;
import org.springframework.samples.petclinic.repository.ContratoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContratoServiceImpl implements ContratoService {

	private ContratoRepository contratoRepository;

	@Autowired
	public ContratoServiceImpl(ContratoRepository contratoRepository) {
		this.contratoRepository=contratoRepository;
	}
	
	@Override
	@Transactional
	public void saveContrato(Contrato contrato) throws DataAccessException {
		contratoRepository.save(contrato);
	}

	@Override
	@Transactional(readOnly = true)
	public Contrato findContratoById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		Contrato cliente = null;
		try {
			cliente = contratoRepository.findById(id);
		}catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return cliente;
	}

	@Override
	public Collection<Contrato> findAllContratos() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteContrato(Contrato contrato) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
