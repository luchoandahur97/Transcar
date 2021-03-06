package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vehiculo;

public interface VehiculoService {
	Vehiculo findVehiculoByPatente(String patente) throws DataAccessException;
	Collection<Vehiculo> findAllVehiculos() throws DataAccessException;
	void saveVehiculo(Vehiculo vehiculo) throws DataAccessException;
	void deleteVehiculo(Vehiculo vehiculo) throws DataAccessException;
	Collection<Vehiculo> findVehiculosDisponibles() throws DataAccessException;
}
