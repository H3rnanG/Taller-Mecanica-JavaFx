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
@Table(name = "historial_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialCliente.findAll", query = "SELECT h FROM HistorialCliente h"),
    @NamedQuery(name = "HistorialCliente.findByIdHistorialCliente", query = "SELECT h FROM HistorialCliente h WHERE h.idHistorialCliente = :idHistorialCliente"),
    @NamedQuery(name = "HistorialCliente.findByIdCliente", query = "SELECT h FROM HistorialCliente h WHERE h.idCliente = :idCliente"),
    @NamedQuery(name = "HistorialCliente.findByFechaHistorialCliente", query = "SELECT h FROM HistorialCliente h WHERE h.fechaHistorialCliente = :fechaHistorialCliente")})
public class HistorialCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial_cliente")
    private Integer idHistorialCliente;
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "fecha_historial_cliente")
    @Temporal(TemporalType.DATE)
    private Date fechaHistorialCliente;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    public HistorialCliente() {
    }

    public HistorialCliente(Integer idHistorialCliente) {
        this.idHistorialCliente = idHistorialCliente;
    }

    public HistorialCliente(Integer idCliente, Date fechaHistorialCliente, String descripcion) {
        this.idCliente = idCliente;
        this.fechaHistorialCliente = fechaHistorialCliente;
        this.descripcion = descripcion;
    }
    
    public Integer getIdHistorialCliente() {
        return idHistorialCliente;
    }

    public void setIdHistorialCliente(Integer idHistorialCliente) {
        this.idHistorialCliente = idHistorialCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaHistorialCliente() {
        return fechaHistorialCliente;
    }

    public void setFechaHistorialCliente(Date fechaHistorialCliente) {
        this.fechaHistorialCliente = fechaHistorialCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorialCliente != null ? idHistorialCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialCliente)) {
            return false;
        }
        HistorialCliente other = (HistorialCliente) object;
        if ((this.idHistorialCliente == null && other.idHistorialCliente != null) || (this.idHistorialCliente != null && !this.idHistorialCliente.equals(other.idHistorialCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.modelo.HistorialCliente[ idHistorialCliente=" + idHistorialCliente + " ]";
    }
    
}
