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
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.idPersonal = :idPersonal"),
    @NamedQuery(name = "Personal.findByNombrePersonal", query = "SELECT p FROM Personal p WHERE p.nombrePersonal = :nombrePersonal"),
    @NamedQuery(name = "Personal.findByApellidoPersonal", query = "SELECT p FROM Personal p WHERE p.apellidoPersonal = :apellidoPersonal"),
    @NamedQuery(name = "Personal.findByOcupacion", query = "SELECT p FROM Personal p WHERE p.ocupacion = :ocupacion"),
    @NamedQuery(name = "Personal.findBySalario", query = "SELECT p FROM Personal p WHERE p.salario = :salario"),
    @NamedQuery(name = "Personal.findByTelefonoPersonal", query = "SELECT p FROM Personal p WHERE p.telefonoPersonal = :telefonoPersonal"),
    @NamedQuery(name = "Personal.findByCorreoPersonal", query = "SELECT p FROM Personal p WHERE p.correoPersonal = :correoPersonal"),
    @NamedQuery(name = "Personal.findByContraPersonal", query = "SELECT p FROM Personal p WHERE p.contraPersonal = :contraPersonal")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personal")
    private Integer idPersonal;
    @Column(name = "nombre_personal")
    private String nombrePersonal;
    @Column(name = "apellido_personal")
    private String apellidoPersonal;
    @Column(name = "ocupacion")
    private String ocupacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Float salario;
    @Column(name = "telefono_personal")
    private String telefonoPersonal;
    @Column(name = "correo_personal")
    private String correoPersonal;
    @Column(name = "contra_personal")
    private String contraPersonal;

    public Personal() {
    }

    public Personal(String nombrePersonal, String apellidoPersonal, String ocupacion, Float salario, String telefonoPersonal, String correoPersonal, String contraPersonal) {
        this.nombrePersonal = nombrePersonal;
        this.apellidoPersonal = apellidoPersonal;
        this.ocupacion = ocupacion;
        this.salario = salario;
        this.telefonoPersonal = telefonoPersonal;
        this.correoPersonal = correoPersonal;
        this.contraPersonal = contraPersonal;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getApellidoPersonal() {
        return apellidoPersonal;
    }

    public void setApellidoPersonal(String apellidoPersonal) {
        this.apellidoPersonal = apellidoPersonal;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getContraPersonal() {
        return contraPersonal;
    }

    public void setContraPersonal(String contraPersonal) {
        this.contraPersonal = contraPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.modelo.Personal[ idPersonal=" + idPersonal + " ]";
    }
    
}
