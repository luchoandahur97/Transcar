package org.springframework.samples.petclinic.rest;

import java.util.Collection;

// MOSTRAR TODOS LOS VEHICULOS()
import org.springframework.samples.petclinic.service.VehiculoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Vehiculo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/vehiculo")
public class VehiculoRestController {
	
	@Autowired
	private VehiculoService VehiculoService;
	
	@PreAuthorize( "hasRole(@roles.VEHICULO_ADMIN)" )
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Vehiculo>> getVehiculo(){
		Collection<Vehiculo> vehiculos = this.VehiculoService.findAllVehiculos();
		if(vehiculos.isEmpty()){
			return new ResponseEntity<Collection<Vehiculo>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Vehiculo>>(vehiculos, HttpStatus.OK);
	}
	
	@PreAuthorize( "hasRole(@roles.VEHICULO_ADMIN)" )
	@RequestMapping(value = "/disponibles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Vehiculo>> getVehiculoDisponible(){
		Collection<Vehiculo> vehiculosDisp = this.VehiculoService.findVehiculosDisponibles();
		if(vehiculosDisp.isEmpty()){
			return new ResponseEntity<Collection<Vehiculo>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Vehiculo>>(vehiculosDisp, HttpStatus.OK);
	}
}
