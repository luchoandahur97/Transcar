package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.repository.ChoferRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.Chofer;

@Service
public class ChoferServiceImpl implements ChoferService {
	@Autowired
	private ChoferRepository choferRepository;

	public ChoferServiceImpl(ChoferRepository choferRepository) {
		// TODO Auto-generated constructor stub
		this.choferRepository=choferRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public Chofer findChoferById(int choferId) throws DataAccessException {
		// TODO Auto-generated method stub
		Chofer chofer = null;
		try {
			chofer = choferRepository.findById(choferId);
		}catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return chofer;
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Chofer> findAllChoferes() throws DataAccessException {
		// TODO Auto-generated method stub
		return choferRepository.findAll();
	}

	@Override
	@Transactional
	public void saveChofer(Chofer chofer) throws DataAccessException {
		// TODO Auto-generated method stub
		choferRepository.save(chofer);
	}

	@Override
	@Transactional
	public void deleteChofer(Chofer chofer) throws DataAccessException {
		// TODO Auto-generated method stub
		choferRepository.delete(chofer);
	}

}
