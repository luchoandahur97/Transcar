package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.servicioFlete;
import org.springframework.samples.petclinic.repository.servicioFleteRepository;
import org.springframework.stereotype.Repository;


public class JdbcServicioFleteImpl implements servicioFleteRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertServicioFlete;
    
    @Autowired
    public JdbcServicioFleteImpl(DataSource dataSource) {

        this.insertServicioFlete = new SimpleJdbcInsert(dataSource)
            .withTableName("servicioFlete")
            .usingGeneratedKeyColumns("id_servicio");

        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }
	
	
	
	

	@Override
	  public servicioFlete findServicioFleteById(int id) throws DataAccessException {
        servicioFlete servicioF;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("id_servicio", id);
            servicioF = this.namedParameterJdbcTemplate.queryForObject(
            		"SELECT * FROM sv_transporte WHERE id_servicio = :id_servicio",
                params,
                BeanPropertyRowMapper.newInstance(servicioFlete.class)
            );
        } catch (EmptyResultDataAccessException ex) {
            throw new ObjectRetrievalFailureException(servicioFlete.class, id);
        }
        
        return servicioF;
    }

	@Override
	public Collection<servicioFlete> findAllServicioFlete() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	  public void saveServicioFlete(servicioFlete servicioF) throws DataAccessException {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(servicioF);
        if (servicioF.isNew()) {
            Number newKey = this.insertServicioFlete.executeAndReturnKey(parameterSource);
            servicioF.setId_servicio(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                "UPDATE sv_transporte SET Monto_Servicio=:Monto_Servicio, id_socio=:id_socio, Patente=:Patente, " +
                    " WHERE id_servicio=:id",
                parameterSource);
        }
    }

	@Override
	public void deleteServicioFlete(servicioFlete serivicioF) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
