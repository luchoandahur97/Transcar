package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.samples.petclinic.rest.JacksonCustomOwnerDeserializer;
import org.springframework.samples.petclinic.rest.JacksonCustomOwnerSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "Chofer")
/*@JsonSerialize(using = JacksonCustomOwnerSerializer.class)
@JsonDeserialize(using = JacksonCustomOwnerDeserializer.class)*/

public class Chofer extends Persona{

	 
	 @Column(name = "nro_licencia")
	 @NotEmpty
	 protected int nro_licencia;
	 
	 @Column(name = "tipo_licencia")
	 @NotEmpty
	 protected String tipo_licencia;
	 
	 @Column(name = "telefono")
	 @NotEmpty
	 protected int telefono;

	 
	//Getters and Setters
	public int getNro_licencia() {
		return nro_licencia;
	}

	public void setNro_licencia(int nro_licencia) {
		this.nro_licencia = nro_licencia;
	}

	public String getTipo_licencia() {
		return tipo_licencia;
	}

	public void setTipo_licencia(String tipo_licencia) {
		this.tipo_licencia = tipo_licencia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	 
	 

}
