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
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.model.servicioFlete;
import org.springframework.samples.petclinic.repository.servicioFleteRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jdbc")
public class JdbcServicioFleteImpl implements servicioFleteRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertServicioFlete;
    
    @Autowired
    public JdbcServicioFleteImpl(DataSource dataSource) {

        this.insertServicioFlete = new SimpleJdbcInsert(dataSource)
            .withTableName("sv_transporte")
            .usingGeneratedKeyColumns("id_servicio");

        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }
	
	@Override
	  public servicioFlete findServicioFleteById(int idservicio) throws DataAccessException {
        servicioFlete servicioF;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("id_servicio", idservicio);
            servicioF = this.namedParameterJdbcTemplate.queryForObject(
            		"SELECT id_servicio, monto_servicio FROM sv_transporte",
                params,
                BeanPropertyRowMapper.newInstance(servicioFlete.class)
            );
        } catch (EmptyResultDataAccessException ex) {
            throw new ObjectRetrievalFailureException(servicioFlete.class, idservicio);
        }
        
        return servicioF;
    }

	@Override
	public Collection<servicioFlete> findAllServicioFlete() throws DataAccessException {
		// TODO Auto-generated method stub
		List<servicioFlete> sFlete = this.namedParameterJdbcTemplate.query(
	            "SELECT id_servicio, monto_servicio FROM sv_transporte",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(servicioFlete.class));
		
	    return sFlete;
	}

	@Override
	  public void saveServicioFlete(servicioFlete servicioF) throws DataAccessException {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(servicioF);
        if (servicioF.isNew()) {
            Number newKey = this.insertServicioFlete.executeAndReturnKey(parameterSource);
            servicioF.setIdServicio(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                "UPDATE sv_transporte SET Monto_Servicio=:Monto_Servicio " +
                    " WHERE id_servicio=:id",
                parameterSource);
        }
    }

	@Override
	public void deleteServicioFlete(servicioFlete serivicioF) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
