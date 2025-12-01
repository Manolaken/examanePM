/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmaic
 */
@Entity
@Table(name = "sedesresponsables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sederesponsable.findAll", query = "SELECT s FROM Sederesponsable s")
    , @NamedQuery(name = "Sederesponsable.findByCodSede", query = "SELECT s FROM Sederesponsable s WHERE s.sederesponsablePK.codSede = :codSede")
    , @NamedQuery(name = "Sederesponsable.findByCodResponsable", query = "SELECT s FROM Sederesponsable s WHERE s.sederesponsablePK.codResponsable = :codResponsable")
    , @NamedQuery(name = "Sederesponsable.findByFechaInicio", query = "SELECT s FROM Sederesponsable s WHERE s.sederesponsablePK.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Sederesponsable.findByFechaFin", query = "SELECT s FROM Sederesponsable s WHERE s.fechaFin = :fechaFin")
    , @NamedQuery(name = "Sederesponsable.findByEmail", query = "SELECT s FROM Sederesponsable s WHERE s.email = :email")
    , @NamedQuery(name = "Sederesponsable.findByTelefono", query = "SELECT s FROM Sederesponsable s WHERE s.telefono = :telefono")})
public class Sederesponsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SederesponsablePK sederesponsablePK;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "cod_responsable", referencedColumnName = "cod_responsable", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Responsable responsable;
    @JoinColumn(name = "cod_sede", referencedColumnName = "cod_sede", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sede sede;

    public Sederesponsable() {
    }

    public Sederesponsable(SederesponsablePK sederesponsablePK) {
        this.sederesponsablePK = sederesponsablePK;
    }

    public Sederesponsable(String codSede, int codResponsable, Date fechaInicio) {
        this.sederesponsablePK = new SederesponsablePK(codSede, codResponsable, fechaInicio);
    }

    public SederesponsablePK getSederesponsablePK() {
        return sederesponsablePK;
    }

    public void setSederesponsablePK(SederesponsablePK sederesponsablePK) {
        this.sederesponsablePK = sederesponsablePK;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sederesponsablePK != null ? sederesponsablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sederesponsable)) {
            return false;
        }
        Sederesponsable other = (Sederesponsable) object;
        if ((this.sederesponsablePK == null && other.sederesponsablePK != null) || (this.sederesponsablePK != null && !this.sederesponsablePK.equals(other.sederesponsablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sederesponsable[ sederesponsablePK=" + sederesponsablePK + " ]";
    }
    
}
