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
import javax.persistence.Lob;
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
@Table(name = "servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio"),
    @NamedQuery(name = "Servicio.findByIdPersonal", query = "SELECT s FROM Servicio s WHERE s.idPersonal = :idPersonal"),
    @NamedQuery(name = "Servicio.findByIdVehiculo", query = "SELECT s FROM Servicio s WHERE s.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Servicio.findByFechaServicio", query = "SELECT s FROM Servicio s WHERE s.fechaServicio = :fechaServicio"),
    @NamedQuery(name = "Servicio.findByPrecioServicio", query = "SELECT s FROM Servicio s WHERE s.precioServicio = :precioServicio"),
    @NamedQuery(name = "Servicio.findByServicioPagado", query = "SELECT s FROM Servicio s WHERE s.servicioPagado = :servicioPagado")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Column(name = "id_personal")
    private Integer idPersonal;
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Column(name = "fecha_servicio")
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_servicio")
    private Float precioServicio;
    @Lob
    @Column(name = "descripcion_servicio")
    private String descripcionServicio;
    @Basic(optional = false)
    @Column(name = "servicio_pagado")
    private boolean servicioPagado;

    public Servicio() {
    }

    public Servicio(Integer idPersonal, Integer idVehiculo, Date fechaServicio, Float precioServicio, String descripcionServicio, boolean servicioPagado) {
        this.idPersonal = idPersonal;
        this.idVehiculo = idVehiculo;
        this.fechaServicio = fechaServicio;
        this.precioServicio = precioServicio;
        this.descripcionServicio = descripcionServicio;
        this.servicioPagado = servicioPagado;
    }

    
    
    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(Integer idServicio, boolean servicioPagado) {
        this.idServicio = idServicio;
        this.servicioPagado = servicioPagado;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public Float getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(Float precioServicio) {
        this.precioServicio = precioServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public boolean getServicioPagado() {
        return servicioPagado;
    }

    public void setServicioPagado(boolean servicioPagado) {
        this.servicioPagado = servicioPagado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.modelo.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}
