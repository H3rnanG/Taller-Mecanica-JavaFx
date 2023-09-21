/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "cliente_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteVehiculo.findAll", query = "SELECT c FROM ClienteVehiculo c"),
    @NamedQuery(name = "ClienteVehiculo.findByIdClienteVehiculo", query = "SELECT c FROM ClienteVehiculo c WHERE c.idClienteVehiculo = :idClienteVehiculo"),
    @NamedQuery(name = "ClienteVehiculo.findByIdCliente", query = "SELECT c FROM ClienteVehiculo c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "ClienteVehiculo.findByIdVehiculo", query = "SELECT c FROM ClienteVehiculo c WHERE c.idVehiculo = :idVehiculo")})
public class ClienteVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente_vehiculo")
    private Integer idClienteVehiculo;
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;

    public ClienteVehiculo() {
    }

    public ClienteVehiculo(Integer idClienteVehiculo) {
        this.idClienteVehiculo = idClienteVehiculo;
    }

    public ClienteVehiculo(Integer idCliente, Integer idVehiculo) {
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdClienteVehiculo() {
        return idClienteVehiculo;
    }

    public void setIdClienteVehiculo(Integer idClienteVehiculo) {
        this.idClienteVehiculo = idClienteVehiculo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteVehiculo != null ? idClienteVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteVehiculo)) {
            return false;
        }
        ClienteVehiculo other = (ClienteVehiculo) object;
        if ((this.idClienteVehiculo == null && other.idClienteVehiculo != null) || (this.idClienteVehiculo != null && !this.idClienteVehiculo.equals(other.idClienteVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.controlador.ClienteVehiculo[ idClienteVehiculo=" + idClienteVehiculo + " ]";
    }
    
}
