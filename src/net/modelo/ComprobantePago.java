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
@Table(name = "comprobante_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobantePago.findAll", query = "SELECT c FROM ComprobantePago c"),
    @NamedQuery(name = "ComprobantePago.findByIdComprobante", query = "SELECT c FROM ComprobantePago c WHERE c.idComprobante = :idComprobante"),
    @NamedQuery(name = "ComprobantePago.findByTipoComprobante", query = "SELECT c FROM ComprobantePago c WHERE c.tipoComprobante = :tipoComprobante")})
public class ComprobantePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comprobante")
    private Integer idComprobante;
    @Column(name = "tipo_comprobante")
    private String tipoComprobante;

    public ComprobantePago() {
    }

    public ComprobantePago(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComprobante != null ? idComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantePago)) {
            return false;
        }
        ComprobantePago other = (ComprobantePago) object;
        if ((this.idComprobante == null && other.idComprobante != null) || (this.idComprobante != null && !this.idComprobante.equals(other.idComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.modelo.ComprobantePago[ idComprobante=" + idComprobante + " ]";
    }
    
}
