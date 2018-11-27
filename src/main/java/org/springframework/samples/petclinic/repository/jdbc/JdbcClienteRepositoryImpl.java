package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jdbc")
public class JdbcClienteRepositoryImpl implements ClienteRepository {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertCliente;

	public JdbcClienteRepositoryImpl(DataSource dataSource)  {
		// TODO Auto-generated constructor stub
		this.insertCliente = new SimpleJdbcInsert(dataSource)
	            .withTableName("cliente")
	            .usingGeneratedKeyColumns("Id_Cliente");

	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	}

	@Override
	public void save(Cliente cliente) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	public Collection<Cliente> findAll() throws DataAccessException {
		List<Cliente> cliente = this.namedParameterJdbcTemplate.query(
	            "SELECT * FROM cliente",
	            new HashMap<String, Object>(),
	            BeanPropertyRowMapper.newInstance(Cliente.class));
		
	    return cliente;
	}
	/*
	public Chofer findById(int id) throws DataAccessException {
        Chofer chofer;
        return chofer;
    }*/

}
