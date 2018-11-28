package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sv_transporte")
public class servicioFlete {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id_servicio;
	
	@Column(name = "Monto_Servicio")
	@NotEmpty
	protected int montoServicio;
	 
	@ManyToOne
    @JoinColumn(name = "id_socio")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "Patente")
    private Vehiculo vehiculo;

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public int getMontoServicio() {
		return montoServicio;
	}

	public void setMontoServicio(int montoServicio) {
		this.montoServicio = montoServicio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	//@JsonIgnore
    public boolean isNew() {
        return this.id_servicio == null;
    }
    
    

}
