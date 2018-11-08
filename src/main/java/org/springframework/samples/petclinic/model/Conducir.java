package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Conducir {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 @Column(name = "Patente")
	 private Vehiculo vh;
	 
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 @Column(name = "id_chofer")
	 private Chofer ch;
	
	 @Column(name = "fecha_conduccion")
	 @Temporal(TemporalType.TIMESTAMP)
	 @DateTimeFormat(pattern = "yyyy/MM/dd")
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd")
	 private Date fecha_conduccion;
	 
	 public Conducir() {
		 this.fecha_conduccion= new Date();
	 }
	 
	 //Getter and Setter

	public Vehiculo getVh() {
		return vh;
	}

	public void setVh(Vehiculo vh) {
		this.vh = vh;
	}

	public Chofer getCh() {
		return ch;
	}

	public void setCh(Chofer ch) {
		this.ch = ch;
	}

	public Date getFecha_conduccion() {
		return fecha_conduccion;
	}

	public void setFecha_conduccion(Date fecha_conduccion) {
		this.fecha_conduccion = fecha_conduccion;
	}
	 
}
