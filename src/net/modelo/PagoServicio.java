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
@Table(name = "pago_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoServicio.findAll", query = "SELECT p FROM PagoServicio p"),
    @NamedQuery(name = "PagoServicio.findByIdPagoServicio", query = "SELECT p FROM PagoServicio p WHERE p.idPagoServicio = :idPagoServicio"),
    @NamedQuery(name = "PagoServicio.findByIdServicio", query = "SELECT p FROM PagoServicio p WHERE p.idServicio = :idServicio"),
    @NamedQuery(name = "PagoServicio.findByIdComprobante", query = "SELECT p FROM PagoServicio p WHERE p.idComprobante = :idComprobante"),
    @NamedQuery(name = "PagoServicio.findByIdMetodo", query = "SELECT p FROM PagoServicio p WHERE p.idMetodo = :idMetodo")})
public class PagoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago_servicio")
    private Integer idPagoServicio;
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Column(name = "id_comprobante")
    private Integer idComprobante;
    @Column(name = "id_metodo")
    private Integer idMetodo;

    public PagoServicio() {
    }

    public PagoServicio(Integer idPagoServicio) {
        this.idPagoServicio = idPagoServicio;
    }

    public PagoServicio(Integer idServicio, Integer idComprobante, Integer idMetodo) {
        this.idServicio = idServicio;
        this.idComprobante = idComprobante;
        this.idMetodo = idMetodo;
    }

    public Integer getIdPagoServicio() {
        return idPagoServicio;
    }

    public void setIdPagoServicio(Integer idPagoServicio) {
        this.idPagoServicio = idPagoServicio;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Integer getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Integer idMetodo) {
        this.idMetodo = idMetodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoServicio != null ? idPagoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoServicio)) {
            return false;
        }
        PagoServicio other = (PagoServicio) object;
        if ((this.idPagoServicio == null && other.idPagoServicio != null) || (this.idPagoServicio != null && !this.idPagoServicio.equals(other.idPagoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.modelo.PagoServicio[ idPagoServicio=" + idPagoServicio + " ]";
    }
    
}
