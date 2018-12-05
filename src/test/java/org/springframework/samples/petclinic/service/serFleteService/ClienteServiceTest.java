package org.springframework.samples.petclinic.service.serFleteService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.service.ClienteService;
import org.springframework.samples.petclinic.util.EntityUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc, mysql")
public class ClienteServiceTest {

	@Autowired
    protected ClienteService clienteService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void shouldFindClientesByLastName() {
        Cliente clientes = this.clienteService.findClienteById(1);
        assertThat(clientes.getApellido_m()).startsWith("Andahur");
        
    }

	  @Test
	    public void shouldFindAllClientes(){
	        Collection<Cliente> clientes = this.clienteService.findAllClientes();
	        Cliente petType1 = EntityUtils.getByIdCliente(clientes, Cliente.class, 1);
	        assertThat(petType1.getNombre()).isEqualTo("Luis");
	        
	    }
}
