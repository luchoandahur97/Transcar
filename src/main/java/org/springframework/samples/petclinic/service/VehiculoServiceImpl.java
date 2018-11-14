package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.samples.petclinic.repository.VehiculoRepository;
import org.springframework.samples.petclinic.repository.ChoferRepository;
import org.springframework.samples.petclinic.model.Vehiculo;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class VehiculoServiceImpl implements VehiculoService{
	private VehiculoRepository vehiculoRepository;
	private ChoferRepository choferRepository;
	
	@Autowired
	
	public VehiculoServiceImpl(
		VehiculoRepository vehiculoRepository,
		ChoferRepository choferRepository) {
		this.vehiculoRepository = vehiculoRepository;
		this.choferRepository = choferRepository;
		
		}
	@Override
	@Transactional(readOnly = true)
	public Collection<Vehiculo> findAllVehiculos() throws DataAccessException {
		return vehiculoRepository.findAllVehiculos();
	}
	@Override
	public Vehiculo findVehiculoByPatente(int patente) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveVehiculo(Vehiculo vehiculo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteVehiculo(Vehiculo vehiculo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
		








}
