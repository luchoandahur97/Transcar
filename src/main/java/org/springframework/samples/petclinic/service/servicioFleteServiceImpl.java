package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.repository.ContratoRepository;
import org.springframework.samples.petclinic.repository.servicioFleteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.servicioFlete;

@Service
public class servicioFleteServiceImpl implements servicioFleteService {
	private servicioFleteRepository servicioFleteRepository;
	@Override
	public servicioFlete findServicioFleteById(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return servicioFleteRepository.findServicioFleteById(id);
	}

	@Override
	public Collection<servicioFlete> findAllServicioFlete() throws DataAccessException {
		// TODO Auto-generated method stub
		return servicioFleteRepository.findAllServicioFlete();
	}

	@Override
	public void saveServicioFlete(servicioFlete servicioF) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteServicioFlete(servicioFlete serivicioF) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
