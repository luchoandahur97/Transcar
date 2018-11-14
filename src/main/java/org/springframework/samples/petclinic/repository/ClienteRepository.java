package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Persona;
import org.springframework.samples.petclinic.model.Cliente;

public interface ClienteRepository {

	   //Collection<Cliente> findByLastName(String lastName) throws DataAccessException;

	    /**
	     * Retrieve an <code>Owner</code> from the data store by id.
	     *
	     * @param id the id to search for
	     * @return the <code>Owner</code> if found
	     * @throws org.springframework.dao.DataRetrievalFailureException if not found
	     */
	   //Cliente findById(int id) throws DataAccessException;


	    /**
	     * Save an <code>Owner</code> to the data store, either inserting or updating it.
	     *
	     * @param owner the <code>Owner</code> to save
	     * @see BaseEntity#isNew
	     */
	    void save(Cliente cliente) throws DataAccessException;
	    
	    /**
	     * Retrieve <code>Owner</code>s from the data store, returning all owners 
	     *
	     * @return a <code>Collection</code> of <code>Owner</code>s (or an empty <code>Collection</code> if none
	     * found)
	     */
		//Collection<Cliente> findAll() throws DataAccessException;
		
	    /**
	     * Delete an <code>Owner</code> to the data store by <code>Owner</code>.
	     *
	     * @param owner the <code>Owner</code> to delete
	     * 
	     */
		//void delete(Cliente cliente) throws DataAccessException;
}
