package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vehiculo;

public interface VehiculoRepository {

	Collection<Vehiculo> findAll() throws DataAccessException;
}
