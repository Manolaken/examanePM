/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmaic
 */
@Entity
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findByCodStatus", query = "SELECT s FROM Status s WHERE s.codStatus = :codStatus")
    , @NamedQuery(name = "Status.findByNomStatus", query = "SELECT s FROM Status s WHERE s.nomStatus = :nomStatus")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_status")
    private Integer codStatus;
    @Size(max = 50)
    @Column(name = "nom_status")
    private String nomStatus;

    public Status() {
    }

    public Status(Integer codStatus) {
        this.codStatus = codStatus;
    }

    public Integer getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(Integer codStatus) {
        this.codStatus = codStatus;
    }

    public String getNomStatus() {
        return nomStatus;
    }

    public void setNomStatus(String nomStatus) {
        this.nomStatus = nomStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codStatus != null ? codStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.codStatus == null && other.codStatus != null) || (this.codStatus != null && !this.codStatus.equals(other.codStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Status[ codStatus=" + codStatus + " ]";
    }
    
}
