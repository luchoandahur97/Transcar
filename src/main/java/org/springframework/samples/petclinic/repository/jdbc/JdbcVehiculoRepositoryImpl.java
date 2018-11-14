package org.springframework.samples.petclinic.repository.jdbc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.Vehiculo;
import org.springframework.samples.petclinic.repository.VehiculoRepository;
import org.springframework.samples.petclinic.util.EntityUtils;

public class JdbcVehiculoRepositoryImpl {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertVehiculo;

    private VehiculoRepository vehiculoRepository;
    
    @Autowired
    public Collection<Vehiculo> findAll() throws DataAccessException {
		List<Vehiculo> vehiculos = this.namedParameterJdbcTemplate.query(
	            "SELECT * FROM vehiculo",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Vehiculo.class));
		for(Vehiculo vehiculo : vehiculos) {
            loadVehiculo(vehiculos);
        }
	    return vehiculos;
	}
    
    private void loadVehiculo(List<Vehiculo> vehiculos) {
        for (Vehiculo  vehiculo :  vehiculos) {
            loadVehiculo( vehiculos);
        }
    }


}
