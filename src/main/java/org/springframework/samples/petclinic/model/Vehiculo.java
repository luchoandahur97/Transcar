package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.samples.petclinic.rest.JacksonCustomOwnerDeserializer;
import org.springframework.samples.petclinic.rest.JacksonCustomOwnerSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "Vehiculo")
@JsonSerialize(using = JacksonCustomOwnerSerializer.class)
@JsonDeserialize(using = JacksonCustomOwnerDeserializer.class)

public class Vehiculo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 @Column(name = "Patente")
	 protected String Patente;
	 
	 @Column(name = "Modelo")
	 @NotEmpty
	 protected String Modelo;
	 
	 @Column(name = "Marca")
	 @NotEmpty
	 protected String Marca;
	 
	 @Column(name = "Anio")
	 @NotEmpty
	 protected int Anio;
	 
	 @Column(name = "Capacidad")
	 @NotEmpty
	 protected int Capacidad;

	 @Column(name = "Estado_Vehiculo")
	 @NotEmpty
	 protected boolean Estado_Vehiculo;



}
