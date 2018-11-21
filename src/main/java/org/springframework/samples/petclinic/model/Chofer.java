package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;


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
	 
	 /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "chofer", fetch = FetchType.EAGER)
	 private Set<Chofer> choferes;*/
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
	 
	/*protected Set<Chofer> getChoferesInternal() {
        if (this.choferes == null) {
            this.choferes = new HashSet<>();
        }
        return this.choferes;
    }*/
	/*public List<Chofer> getChoferes() {
        List<Chofer> sortedChoferes = new ArrayList<>(getChoferesInternal());
        PropertyComparator.sort(sortedChoferes, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedChoferes);
    }*/

}
