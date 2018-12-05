package org.springframework.samples.petclinic.service.VehiculoSer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.Vehiculo;
import org.springframework.samples.petclinic.service.VehiculoService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc, mysql")
public class VehiculoServiceTest {
	
	@Autowired
    protected VehiculoService vehiculoService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void shouldFindVehicleByPatente() {
        Vehiculo vehiculos = this.vehiculoService.findVehiculoByPatente("XX44XX");
        assertThat(vehiculos.getMarca()).startsWith("Nissan");
        
       
    }

}
