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
@Table(name = "sectoresdbncadingles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectordbncadingles.findAll", query = "SELECT s FROM Sectordbncadingles s")
    , @NamedQuery(name = "Sectordbncadingles.findByCodsectorIng", query = "SELECT s FROM Sectordbncadingles s WHERE s.codsectorIng = :codsectorIng")
    , @NamedQuery(name = "Sectordbncadingles.findByNomsectorIng", query = "SELECT s FROM Sectordbncadingles s WHERE s.nomsectorIng = :nomsectorIng")
    , @NamedQuery(name = "Sectordbncadingles.findByCodSector", query = "SELECT s FROM Sectordbncadingles s WHERE s.codSector = :codSector")})
public class Sectordbncadingles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_sectorIng")
    private Integer codsectorIng;
    @Size(max = 150)
    @Column(name = "nom_sectorIng")
    private String nomsectorIng;
    @Column(name = "cod_sector")
    private Integer codSector;

    public Sectordbncadingles() {
    }

    public Sectordbncadingles(Integer codsectorIng) {
        this.codsectorIng = codsectorIng;
    }

    public Integer getCodsectorIng() {
        return codsectorIng;
    }

    public void setCodsectorIng(Integer codsectorIng) {
        this.codsectorIng = codsectorIng;
    }

    public String getNomsectorIng() {
        return nomsectorIng;
    }

    public void setNomsectorIng(String nomsectorIng) {
        this.nomsectorIng = nomsectorIng;
    }

    public Integer getCodSector() {
        return codSector;
    }

    public void setCodSector(Integer codSector) {
        this.codSector = codSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsectorIng != null ? codsectorIng.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectordbncadingles)) {
            return false;
        }
        Sectordbncadingles other = (Sectordbncadingles) object;
        if ((this.codsectorIng == null && other.codsectorIng != null) || (this.codsectorIng != null && !this.codsectorIng.equals(other.codsectorIng))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sectordbncadingles[ codsectorIng=" + codsectorIng + " ]";
    }
    
}
