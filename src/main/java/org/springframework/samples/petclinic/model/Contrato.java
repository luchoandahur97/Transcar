package org.springframework.samples.petclinic.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Contrato {

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Contratar", joinColumns = @JoinColumn(name = "id_cliente"),
    inverseJoinColumns = @JoinColumn(name = "id_servicio"))
	private Set<servicioFlete> servicioFlete;
	
	 @Column(name = "fecha_entrega")
	 @Temporal(TemporalType.DATE)
	 @DateTimeFormat(pattern = "yyyy/MM/dd")
	 protected Date fechaEntrega;
	 
	 @Column(name = "valoracion")
	 @NotEmpty
	 protected int valoracion;
	 
	 @Column(name = "peso_carga")
	 @NotEmpty
	 protected int pesoCarga;
}