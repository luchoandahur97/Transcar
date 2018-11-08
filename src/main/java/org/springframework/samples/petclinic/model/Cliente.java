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
@Table(name = "Cliente")
@JsonSerialize(using = JacksonCustomOwnerSerializer.class)
@JsonDeserialize(using = JacksonCustomOwnerDeserializer.class)

public class Cliente extends BasePersona{

		
	 @Column(name = "telefono")
	 @NotEmpty
	
	 protected int telefono;
	 
	 @Column(name = "email")
	 @NotEmpty
	 protected String email;
	 
	 
	//Getters and Setters
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
