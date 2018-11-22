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
	 protected String estadoVehiculo;

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String isEstadoVehiculo() {
		return estadoVehiculo;
	}

	public void setEstadoVehiculo(String estadoVehiculo) {
		this.estadoVehiculo = estadoVehiculo;
	}


	 
}
