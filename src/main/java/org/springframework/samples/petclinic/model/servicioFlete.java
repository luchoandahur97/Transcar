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

}
