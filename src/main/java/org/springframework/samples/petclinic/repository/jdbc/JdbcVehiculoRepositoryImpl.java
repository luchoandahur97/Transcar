package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.Vehiculo;
import org.springframework.samples.petclinic.repository.VehiculoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jdbc")

public class JdbcVehiculoRepositoryImpl implements VehiculoRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private SimpleJdbcInsert insertVehiculo;

    @Autowired
    public JdbcVehiculoRepositoryImpl(DataSource dataSource) {

        this.insertVehiculo = new SimpleJdbcInsert(dataSource)
            .withTableName("vehiculo")
            .usingGeneratedKeyColumns("Patente");

        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }
    
	@Override
	public Vehiculo findVehiculoByPatente(int patente) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Vehiculo> findAll() throws DataAccessException {
		List<Vehiculo> vehiculos = this.namedParameterJdbcTemplate.query(
				"SELECT Patente, Modelo, Marca, Anio, Capacidad, Estado_Vehiculo FROM vehiculo",
				new HashMap<String, Object>(),
				BeanPropertyRowMapper.newInstance(Vehiculo.class));
	    		
		return vehiculos;
	}

	@Override
	public void save(Vehiculo vehiculo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vehiculo vehiculo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Vehiculo> findVehiculosDisponibles() throws DataAccessException {
		List<Vehiculo> vehiculos = this.namedParameterJdbcTemplate.query(
				"SELECT Patente, Modelo, Marca, Anio, Capacidad, Estado_Vehiculo FROM vehiculo WHERE Estado_Vehiculo = 'Disponible'",
				new HashMap<String, Object>(),
				BeanPropertyRowMapper.newInstance(Vehiculo.class));   		
		return vehiculos;
	}
}
