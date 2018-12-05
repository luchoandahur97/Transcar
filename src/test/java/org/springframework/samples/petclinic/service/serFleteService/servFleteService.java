package org.springframework.samples.petclinic.service.serFleteService;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.servicioFlete;
import org.springframework.samples.petclinic.service.servicioFleteService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc, mysql")
public class servFleteService {

	@Autowired
    protected servicioFleteService fleteService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void shouldFindOwnersByLastName() {
        servicioFlete choferes = this.fleteService.findServicioFleteById(1000);
        assertThat(choferes.getCliente().getApellido_m().startsWith("Andahur"));
        
       
    }

}
