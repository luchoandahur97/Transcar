package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.samples.petclinic.model.Vehiculo;

public class JdbcVehiculoRepositoryImpl {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    public Collection<Vehiculo> findAll() throws DataAccessException {
		List<Vehiculo> vehiculos = this.namedParameterJdbcTemplate.query(
	            "SELECT * FROM vehiculo",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Vehiculo.class));
		/*for(Vehiculo vehiculo : vehiculos) {
            loadVehiculo(vehiculos);
        }*/
	    return vehiculos;
	}
    
    /*private void loadVehiculo(List<Vehiculo> vehiculos) {
        for (Vehiculo  vehiculo :  vehiculos) {
            loadVehiculo( vehiculos);
        }
    }*/


}
