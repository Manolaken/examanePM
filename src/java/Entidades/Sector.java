/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmaic
 */
@Entity
@Table(name = "sectores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")
    , @NamedQuery(name = "Sector.findByCodSector", query = "SELECT s FROM Sector s WHERE s.codSector = :codSector")
    , @NamedQuery(name = "Sector.findByNomSector", query = "SELECT s FROM Sector s WHERE s.nomSector = :nomSector")
    , @NamedQuery(name = "Sector.findByNomsectorIng", query = "SELECT s FROM Sector s WHERE s.nomsectorIng = :nomsectorIng")
    , @NamedQuery(name = "Sector.findBySectorCad", query = "SELECT s FROM Sector s WHERE s.sectorCad = :sectorCad")})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_sector")
    private Integer codSector;
    @Size(max = 50)
    @Column(name = "nom_sector")
    private String nomSector;
    @Size(max = 50)
    @Column(name = "nom_sectorIng")
    private String nomsectorIng;
    @Size(max = 20)
    @Column(name = "sector_cad")
    private String sectorCad;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "explicacion")
    private String explicacion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "explicacionIng")
    private String explicacionIng;
    @JoinTable(name = "sectoresodsprincipal", joinColumns = {
        @JoinColumn(name = "cod_sector", referencedColumnName = "cod_sector")}, inverseJoinColumns = {
        @JoinColumn(name = "ods_pral", referencedColumnName = "cod_ods")})
    @ManyToMany
    private List<Odsprincipal> odsprincipalList;
    @OneToMany(mappedBy = "sectorMS")
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "codSector")
    private List<Subsector> subsectorList;

    public Sector() {
    }

    public Sector(Integer codSector) {
        this.codSector = codSector;
    }

    public Integer getCodSector() {
        return codSector;
    }

    public void setCodSector(Integer codSector) {
        this.codSector = codSector;
    }

    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    public String getNomsectorIng() {
        return nomsectorIng;
    }

    public void setNomsectorIng(String nomsectorIng) {
        this.nomsectorIng = nomsectorIng;
    }

    public String getSectorCad() {
        return sectorCad;
    }

    public void setSectorCad(String sectorCad) {
        this.sectorCad = sectorCad;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getExplicacionIng() {
        return explicacionIng;
    }

    public void setExplicacionIng(String explicacionIng) {
        this.explicacionIng = explicacionIng;
    }

    @XmlTransient
    public List<Odsprincipal> getOdsprincipalList() {
        return odsprincipalList;
    }

    public void setOdsprincipalList(List<Odsprincipal> odsprincipalList) {
        this.odsprincipalList = odsprincipalList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Subsector> getSubsectorList() {
        return subsectorList;
    }

    public void setSubsectorList(List<Subsector> subsectorList) {
        this.subsectorList = subsectorList;
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
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.codSector == null && other.codSector != null) || (this.codSector != null && !this.codSector.equals(other.codSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sector[ codSector=" + codSector + " ]";
    }
    
}
