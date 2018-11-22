package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.samples.petclinic.model.Vehiculo;
import org.springframework.samples.petclinic.repository.VehiculoRepository;
import org.springframework.stereotype.Repository;
@Repository
@Profile("jdbc")
public class JdbcVehiculoRepositoryImpl implements VehiculoRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
	@Override
	public Vehiculo findVehiculoByPatente(int patente) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Vehiculo> findAllVehiculos() throws DataAccessException {
		List<Vehiculo> vehiculos = this.namedParameterJdbcTemplate.query(
	            "SELECT * FROM vehiculo",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Vehiculo.class));
	    return vehiculos;
	}

	@Override
	public void saveVehiculo(Vehiculo vehiculo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVehiculo(Vehiculo vehiculo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Vehiculo> findVehiculosDisponibles() throws DataAccessException {
		List<Vehiculo> vehiculos = this.namedParameterJdbcTemplate.query(
	            "SELECT * FROM vehiculo where estado_Vehiculo='Disponible'",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Vehiculo.class));
	    return vehiculos;
	}
}
