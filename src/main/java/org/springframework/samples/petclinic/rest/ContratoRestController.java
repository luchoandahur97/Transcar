package org.springframework.samples.petclinic.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Contrato;
import org.springframework.samples.petclinic.service.ContratoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/contrato")
public class ContratoRestController {

	@Autowired
	private ContratoService contratoService;
	
	/*@PreAuthorize( "hasRole(@roles.CHOFER_ADMIN)" )
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Contrato>> getChofer() {
		Collection<Contrato> contratos = this.contratoService.findAllContratos();
		if (contratos.isEmpty()) {
			return new ResponseEntity<Collection<Contrato>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Contrato>>(contratos, HttpStatus.OK);
	}*/
}
