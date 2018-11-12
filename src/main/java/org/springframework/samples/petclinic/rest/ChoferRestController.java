package org.springframework.samples.petclinic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.samples.petclinic.service.ChoferService;
import org.springframework.samples.petclinic.service.ClinicService;

import java.util.Collection;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/chofer")
public class ChoferRestController {

	@Autowired
	private ChoferService choferService;
	
	@PreAuthorize( "hasRole(@roles.CHOFER_ADMIN)" )
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Chofer>> getChofer() {
		Collection<Chofer> choferes = this.choferService.findAllChoferes();
		if (choferes.isEmpty()) {
			return new ResponseEntity<Collection<Chofer>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Chofer>>(choferes, HttpStatus.OK);
	}
	
	@PreAuthorize( "hasRole(@roles.CHOFER_ADMIN)" )
	@RequestMapping(value = "/{choferId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Chofer> getChofer(@PathVariable("choferId") int choferId) {
		Chofer chofer = null;
		chofer = this.choferService.findChoferById(choferId);
		if (chofer == null) {
			return new ResponseEntity<Chofer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Chofer>(chofer, HttpStatus.OK);
	}
	

}
