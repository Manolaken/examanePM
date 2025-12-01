/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dmaic
 */
@Embeddable
public class SederesponsablePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_sede")
    private String codSede;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_responsable")
    private int codResponsable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    public SederesponsablePK() {
    }

    public SederesponsablePK(String codSede, int codResponsable, Date fechaInicio) {
        this.codSede = codSede;
        this.codResponsable = codResponsable;
        this.fechaInicio = fechaInicio;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public int getCodResponsable() {
        return codResponsable;
    }

    public void setCodResponsable(int codResponsable) {
        this.codResponsable = codResponsable;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSede != null ? codSede.hashCode() : 0);
        hash += (int) codResponsable;
        hash += (fechaInicio != null ? fechaInicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SederesponsablePK)) {
            return false;
        }
        SederesponsablePK other = (SederesponsablePK) object;
        if ((this.codSede == null && other.codSede != null) || (this.codSede != null && !this.codSede.equals(other.codSede))) {
            return false;
        }
        if (this.codResponsable != other.codResponsable) {
            return false;
        }
        if ((this.fechaInicio == null && other.fechaInicio != null) || (this.fechaInicio != null && !this.fechaInicio.equals(other.fechaInicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SederesponsablePK[ codSede=" + codSede + ", codResponsable=" + codResponsable + ", fechaInicio=" + fechaInicio + " ]";
    }
    
}
