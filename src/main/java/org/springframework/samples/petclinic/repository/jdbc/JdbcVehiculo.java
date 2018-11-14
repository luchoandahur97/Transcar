package org.springframework.samples.petclinic.repository.jdbc;

import org.springframework.samples.petclinic.model.Vehiculo;

public class JdbcVehiculo extends Vehiculo {

    private String patente;

    private int choferId;

    public String getpatente() {
        return this.patente;
    }

    public void setTypeId(String patente) {
        this.patente= patente;
    }

    public int getIdChofer() {
        return this.choferId;
    }

    public void setChoferId(int choferId) {
        this.choferId = choferId;
    }

}
