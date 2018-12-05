package org.springframework.samples.petclinic.rest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.service.clinicService.ApplicationTestConfig;
import org.springframework.samples.petclinic.service.ClienteService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationTestConfig.class)
@WebAppConfiguration
public class clienteRestControllerTest {
	@Autowired
    private ClienteRestController clienteRestController;

    @MockBean
    private ClienteService clienteService;

    private MockMvc mockMvc;

    private List<Cliente> clientes;

    @Before
    public void initClientes(){
    	this.mockMvc = MockMvcBuilders.standaloneSetup(clienteRestController)
    			.setControllerAdvice(new ExceptionControllerAdvice())
    			.build();
    	clientes = new ArrayList<Cliente>();

    	Cliente cliente = new Cliente();
    	cliente.setId(1);
    	cliente.setNombre("Matias");
    	cliente.setApellido_p("Parra");
    	cliente.setApellido_m("Rivas");
    	cliente.setEmail("matias@gmail.com");
    	cliente.setTelefono(768574636);	
    	clientes.add(cliente);
    }
    
    @Test
    @WithMockUser(roles="CLIENTE_ADMIN")
    public void testGetClienteSuccess() throws Exception {
    	
    	given(this.clienteService.findClienteById(1)).willReturn(clientes.get(0));
        this.mockMvc.perform(get("/api/cliente/1")
        	.accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.Id_Cliente").value(1))
            .andExpect(jsonPath("$.Nombre").value("Luis"));
        
    }
    
    /*@Test
    @WithMockUser(roles="CLIENTE_ADMIN")
    public void testGetClienteNotFound() throws Exception {
    	given(this.clienteService.findClienteById(-1)).willReturn(null);
        this.mockMvc.perform(get("/api/cliente/-1")
        	.accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }*/

}
