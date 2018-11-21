package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Vehiculo")
/*@JsonSerialize(using = JacksonCustomOwnerSerializer.class)
@JsonDeserialize(using = JacksonCustomOwnerDeserializer.class)*/

public class Vehiculo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 @Column(name = "Patente")
	 protected String patente;
	 
	 @Column(name = "Modelo")
	 @NotEmpty
	 protected String modelo;
	 
	 @Column(name = "Marca")
	 @NotEmpty
	 protected String marca;
	 
	 @Column(name = "Anio")
	 @NotEmpty
	 protected int anio;
	 
	 @Column(name = "Capacidad")
	 @NotEmpty
	 protected int capacidad;

	 @Column(name = "Estado_Vehiculo")
	 @NotEmpty
	 protected boolean estadoVehiculo;


	 
}
