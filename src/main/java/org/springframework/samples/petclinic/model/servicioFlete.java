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
    protected Integer idServicio;
	
	@Column(name = "Monto_Servicio")
	@NotEmpty
	protected int montoServicio;
	 
	

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer id_servicio) {
		this.idServicio = id_servicio;
	}

	public int getMontoServicio() {
		return montoServicio;
	}

	public void setMontoServicio(int montoServicio) {
		this.montoServicio = montoServicio;
	}

	//@JsonIgnore
    public boolean isNew() {
        return this.idServicio == null;
    }
    
    

}
