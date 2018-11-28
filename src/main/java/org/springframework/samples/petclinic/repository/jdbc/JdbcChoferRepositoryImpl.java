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
import org.springframework.samples.petclinic.repository.ChoferRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jdbc")

public class JdbcChoferRepositoryImpl implements ChoferRepository{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertChofer;

    @Autowired
    public JdbcChoferRepositoryImpl(DataSource dataSource) {

        this.insertChofer = new SimpleJdbcInsert(dataSource)
            .withTableName("chofer")
            .usingGeneratedKeyColumns("Id_Chofer");

        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }
    
    @Override
    public Chofer findById(int id) throws DataAccessException {
        Chofer chofer;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("Id_Chofer", id);
            chofer = this.namedParameterJdbcTemplate.queryForObject(
            		"SELECT Id_Chofer, Nombre, Apellido_P, Apellido_M, Nro_Licencia, Tipo_Licencia, Telefono FROM chofer WHERE Id_Chofer = :Id_Chofer",
                params,
                BeanPropertyRowMapper.newInstance(Chofer.class)
            );
        } catch (EmptyResultDataAccessException ex) {
            throw new ObjectRetrievalFailureException(Chofer.class, id);
        }
        
        return chofer;
    }
    @Override
    public void save(Chofer chofer) throws DataAccessException {
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(chofer);
        if (chofer.isNew()) {
            Number newKey = this.insertChofer.executeAndReturnKey(parameterSource);
            chofer.setId(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                "UPDATE chofer SET Nombre=:Nombre, Apellido_P=:Apellido_P, Apellido_M=:Apellido_M, Nro_Licencia=:Nro_Licencia,Tipo_Licencia=:Tipo_Licencia, " +
                    "Telefono=:Telefono WHERE id=:id",
                parameterSource);
        }
    }

	@Override
	public Collection<Chofer> findAll() throws DataAccessException {
		List<Chofer> chofer = this.namedParameterJdbcTemplate.query(
	            "SELECT Id_Chofer, Nombre, Apellido_P, Apellido_M, Nro_Licencia, Tipo_Licencia, Telefono FROM chofer",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Chofer.class));
		
	    return chofer;
	}
	
	@Override
	public void delete(Chofer chofer) throws DataAccessException {
		
	}
}
