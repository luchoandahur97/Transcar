package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Chofer;

public interface ChoferRepository {

    Chofer findById(int id) throws DataAccessException;
    void save(Chofer owner) throws DataAccessException;   
	Collection<Chofer> findAll() throws DataAccessException;	
	void delete(Chofer owner) throws DataAccessException;
}