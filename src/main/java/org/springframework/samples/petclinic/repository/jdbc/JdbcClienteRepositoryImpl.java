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
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jdbc")
public class JdbcClienteRepositoryImpl implements ClienteRepository {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertCliente;

    @Autowired
    public JdbcClienteRepositoryImpl(DataSource dataSource) {

        this.insertCliente = new SimpleJdbcInsert(dataSource)
            .withTableName("cliente")
            .usingGeneratedKeyColumns("Id_Cliente");

        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }

	@Override
	public Cliente findById(int id) throws DataAccessException {
		Cliente cliente;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("Id_Cliente", id);
            cliente = this.namedParameterJdbcTemplate.queryForObject(
            		"SELECT Nombre, Apellido_P, Apellido_M, Telefono, Email  FROM Cliente WHERE Id_Cliente= :Id_Cliente",
                params,
                BeanPropertyRowMapper.newInstance(Cliente.class)
            );
        } catch (EmptyResultDataAccessException ex) {
            throw new ObjectRetrievalFailureException(Cliente.class, id);
        }
        
        return cliente;
	}

	@Override
	public void save(Cliente cliente) throws DataAccessException {
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(cliente);
        if (cliente.isNew()) {
            Number newKey = this.insertCliente.executeAndReturnKey(parameterSource);
            cliente.setId(newKey.intValue());
        } else {
            this.namedParameterJdbcTemplate.update(
                "UPDATE cliente SET Nombre=:Nombre, Apellido_P=:Apellido_P, Apellido_M=:Apellido_M, Telefono=:Telefono"
                + "Email:Email WHERE Id_Cliente=:Id_Cliente",
                parameterSource);
        }
	}

	@Override
	public Collection<Cliente> findAll() throws DataAccessException {
		List<Cliente> cliente = this.namedParameterJdbcTemplate.query(
	            "SELECT Id_Cliente, Nombre, Apellido_P, Apellido_M, Telefono, Email FROM Cliente",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Cliente.class));
		
	    return cliente;
	}

	@Override
	public void delete(Cliente cliente) throws DataAccessException {
		
		
	}

}