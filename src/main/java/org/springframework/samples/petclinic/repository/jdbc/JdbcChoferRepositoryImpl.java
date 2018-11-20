package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.transaction.Transactional;

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
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.ChoferRepository;
import org.springframework.samples.petclinic.util.EntityUtils;
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
            params.put("id", id);
            chofer = this.namedParameterJdbcTemplate.queryForObject(
            		"SELECT Id_Chofer, Nombre, Apellido_P, Apellido_M, Nro_Licencia, Tipo_Licencia, Telefono FROM chofer WHERE id= :id",
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
	            "SELECT id, Nombre, Apellido_P, Apellido_M, Nro_Licencia, Tipo_Licencia, Telefono FROM chofer",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Chofer.class));
		
	    return chofer;
	}

	@Override
	@Transactional
	public void delete(Chofer chofer) throws DataAccessException {
		Map<String, Object> chofer_params = new HashMap<>();
		chofer_params.put("id", chofer.getId());
        List<Chofer> choferes = chofer.getChoferes();
        // cascade delete choferes
        for (Chofer chofer1 : choferes){
        	Map<String, Object> chofer1_params = new HashMap<>();
        	chofer1_params.put("id", chofer1.getId());
        	// cascade delete visits
        	/*
        	List<Visit> visits = chofer1.getVisits();
            for (Visit visit : visits){
            	Map<String, Object> visit_params = new HashMap<>();
            	visit_params.put("id", visit.getId());
            	this.namedParameterJdbcTemplate.update("DELETE FROM visits WHERE id=:id", visit_params);
            }
            */
            this.namedParameterJdbcTemplate.update("DELETE FROM pets WHERE id=:id", chofer1_params);
        }
        this.namedParameterJdbcTemplate.update("DELETE FROM chofer WHERE id=:id", chofer_params);
	
		
	}
    
   
   
	
}
