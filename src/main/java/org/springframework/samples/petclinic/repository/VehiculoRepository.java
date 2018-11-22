package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vehiculo;

public interface VehiculoRepository {

	Vehiculo findVehiculoByPatente(int patente) throws DataAccessException;
	Collection<Vehiculo> findAllVehiculos() throws DataAccessException;
	Collection<Vehiculo> findVehiculosDisponibles() throws DataAccessException;
	void saveVehiculo(Vehiculo vehiculo) throws DataAccessException;
	void deleteVehiculo(Vehiculo vehiculo) throws DataAccessException;
}
