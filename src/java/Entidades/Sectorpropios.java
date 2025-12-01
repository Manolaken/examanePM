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
@Table(name = "sectorespropios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectorpropios.findAll", query = "SELECT s FROM Sectorpropios s")
    , @NamedQuery(name = "Sectorpropios.findByCodSector", query = "SELECT s FROM Sectorpropios s WHERE s.codSector = :codSector")
    , @NamedQuery(name = "Sectorpropios.findByNomSector", query = "SELECT s FROM Sectorpropios s WHERE s.nomSector = :nomSector")})
public class Sectorpropios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_sector")
    private String codSector;
    @Size(max = 50)
    @Column(name = "nom_sector")
    private String nomSector;

    public Sectorpropios() {
    }

    public Sectorpropios(String codSector) {
        this.codSector = codSector;
    }

    public String getCodSector() {
        return codSector;
    }

    public void setCodSector(String codSector) {
        this.codSector = codSector;
    }

    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSector != null ? codSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectorpropios)) {
            return false;
        }
        Sectorpropios other = (Sectorpropios) object;
        if ((this.codSector == null && other.codSector != null) || (this.codSector != null && !this.codSector.equals(other.codSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sectorpropios[ codSector=" + codSector + " ]";
    }
    
}
