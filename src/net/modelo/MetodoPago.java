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
@Table(name = "metodo_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM MetodoPago m"),
    @NamedQuery(name = "MetodoPago.findByIdMetodo", query = "SELECT m FROM MetodoPago m WHERE m.idMetodo = :idMetodo"),
    @NamedQuery(name = "MetodoPago.findByTipoMetodo", query = "SELECT m FROM MetodoPago m WHERE m.tipoMetodo = :tipoMetodo")})
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_metodo")
    private Integer idMetodo;
    @Column(name = "tipo_metodo")
    private String tipoMetodo;

    public MetodoPago() {
    }

    public MetodoPago(Integer idMetodo) {
        this.idMetodo = idMetodo;
    }

    public Integer getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Integer idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getTipoMetodo() {
        return tipoMetodo;
    }

    public void setTipoMetodo(String tipoMetodo) {
        this.tipoMetodo = tipoMetodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetodo != null ? idMetodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.idMetodo == null && other.idMetodo != null) || (this.idMetodo != null && !this.idMetodo.equals(other.idMetodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.modelo.MetodoPago[ idMetodo=" + idMetodo + " ]";
    }
    
}
