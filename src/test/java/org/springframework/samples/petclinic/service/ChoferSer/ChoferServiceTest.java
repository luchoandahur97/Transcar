package org.springframework.samples.petclinic.service.ChoferSer;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collection;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ChoferService;
import org.springframework.samples.petclinic.util.EntityUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc, mysql")
public class ChoferServiceTest {

	@Autowired
    protected ChoferService choferService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void shouldFindOwnersByLastName() {
        Chofer choferes = this.choferService.findChoferById(1);
        assertThat(choferes.getApellido_m()).startsWith("Astudillo");
        
       
    }

}
