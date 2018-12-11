package org.springframework.samples.petclinic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.servicioFlete;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.samples.petclinic.service.ChoferService;
import org.springframework.samples.petclinic.service.servicioFleteService;
import java.util.Collection;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/servicioFlete")

public class servicioFleteRestController {

	@Autowired
	private servicioFleteService servicioFService;
	
	@PreAuthorize( "hasRole(@roles.PC_ADMIN)" )
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<servicioFlete>> getServicio() {
		Collection<servicioFlete> serviciosF = this.servicioFService.findAllServicioFlete();
		if (serviciosF.isEmpty()) {
			return new ResponseEntity<Collection<servicioFlete>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<servicioFlete>>(serviciosF, HttpStatus.OK);
	}
	
	@PreAuthorize( "hasRole(@roles.CHOFER_ADMIN)" )
	@RequestMapping(value = "/{id_servicio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<servicioFlete> getServicio(@PathVariable("id_servicio") int servicioId) {
		servicioFlete servicioF= null;
		servicioF = this.servicioFService.findServicioFleteById(servicioId);
		if (servicioF == null) {
			return new ResponseEntity<servicioFlete>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<servicioFlete>(servicioF, HttpStatus.OK);
	}
	
	
}
