/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculo.findByKilometraje", query = "SELECT v FROM Vehiculo v WHERE v.kilometraje = :kilometraje"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiculo.findByNSerie", query = "SELECT v FROM Vehiculo v WHERE v.nSerie = :nSerie"),
    @NamedQuery(name = "Vehiculo.findByNServicios", query = "SELECT v FROM Vehiculo v WHERE v.nServicios = :nServicios"),
    @NamedQuery(name = "Vehiculo.findByFechaFabricacion", query = "SELECT v FROM Vehiculo v WHERE v.fechaFabricacion = :fechaFabricacion"),
    @NamedQuery(name = "Vehiculo.findByNChasis", query = "SELECT v FROM Vehiculo v WHERE v.nChasis = :nChasis")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Column(name = "placa")
    private String placa;
    @Column(name = "kilometraje")
    private Integer kilometraje;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "color")
    private String color;
    @Column(name = "n_serie")
    private Integer nSerie;
    @Column(name = "n_servicios")
    private Integer nServicios;
    @Column(name = "fecha_fabricacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFabricacion;
    @Column(name = "n_chasis")
    private String nChasis;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String placa, Integer kilometraje, String modelo, String marca, String color, Integer nSerie, Integer nServicios, Date fechaFabricacion, String nChasis) {
        this.placa = placa;
        this.kilometraje = kilometraje;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.nSerie = nSerie;
        this.nServicios = nServicios;
        this.fechaFabricacion = fechaFabricacion;
        this.nChasis = nChasis;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Integer kilometraje) {
        this.kilometraje = kilometraje;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNSerie() {
        return nSerie;
    }

    public void setNSerie(Integer nSerie) {
        this.nSerie = nSerie;
    }

    public Integer getNServicios() {
        return nServicios;
    }

    public void setNServicios(Integer nServicios) {
        this.nServicios = nServicios;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getNChasis() {
        return nChasis;
    }

    public void setNChasis(String nChasis) {
        this.nChasis = nChasis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.modelo.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
