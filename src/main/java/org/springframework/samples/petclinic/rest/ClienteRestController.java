package org.springframework.samples.petclinic.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Cliente;
import org.springframework.samples.petclinic.service.ClienteService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/cliente")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	//REGISTRA LOS DATOS DEL CLIENTE
	@PreAuthorize( "hasRole(@roles.OWNER_ADMIN)" )
	@RequestMapping(value = "/{petId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> updatePet(@PathVariable("petId") int petId, @RequestBody @Valid Cliente cliente, BindingResult bindingResult){
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors() || (cliente == null)){
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<Cliente>(headers, HttpStatus.BAD_REQUEST);
		}
		Cliente currentCliente = this.clienteService.findClienteById(petId);
		if(currentCliente == null){
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		currentCliente.setBirthDate(cliente.getBirthDate());
		currentCliente.setName(cliente.getName());
		currentCliente.setType(cliente.getType());
		currentCliente.setOwner(cliente.getOwner());
		this.clienteService.saveCliente(currentPet);
		return new ResponseEntity<Cliente>(currentPet, HttpStatus.NO_CONTENT);
	}


}
