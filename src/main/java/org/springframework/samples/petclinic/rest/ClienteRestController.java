package org.springframework.samples.petclinic.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Chofer;
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.service.ChoferService;
import org.springframework.samples.petclinic.service.ClienteService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/cliente")
public class ClienteRestController {
	@Autowired
	private ClienteService clienteService;
	
	//POR ID
	@PreAuthorize( "hasRole(@roles.CLIENTE_ADMIN)" )
	@RequestMapping(value = "/{clienteId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> getChofer(@PathVariable("clienteId") int clienteId) {
		Cliente cliente = null;
		cliente = this.clienteService.findClienteById(clienteId);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}


}
