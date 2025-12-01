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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "crss")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crs.findAll", query = "SELECT c FROM Crs c")
    , @NamedQuery(name = "Crs.findByCodCrs", query = "SELECT c FROM Crs c WHERE c.codCrs = :codCrs")
    , @NamedQuery(name = "Crs.findByNomCrs", query = "SELECT c FROM Crs c WHERE c.nomCrs = :nomCrs")
    , @NamedQuery(name = "Crs.findByNomcrsIngles", query = "SELECT c FROM Crs c WHERE c.nomcrsIngles = :nomcrsIngles")})
public class Crs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_crs")
    private Integer codCrs;
    @Size(max = 100)
    @Column(name = "nom_crs")
    private String nomCrs;
    @Size(max = 100)
    @Column(name = "nom_crsIngles")
    private String nomcrsIngles;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionesESP")
    private String informacionesESP;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionesING")
    private String informacionesING;
    @JoinTable(name = "proyectoscrs", joinColumns = {
        @JoinColumn(name = "cod_crs", referencedColumnName = "cod_crs")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_proyecto", referencedColumnName = "cod_proyecto")})
    @ManyToMany
    private List<Proyecto> proyectoList;
    @JoinColumn(name = "cod_cadsub", referencedColumnName = "cod_subcad")
    @ManyToOne
    private Cadssub codCadsub;

    public Crs() {
    }

    public Crs(Integer codCrs) {
        this.codCrs = codCrs;
    }

    public Integer getCodCrs() {
        return codCrs;
    }

    public void setCodCrs(Integer codCrs) {
        this.codCrs = codCrs;
    }

    public String getNomCrs() {
        return nomCrs;
    }

    public void setNomCrs(String nomCrs) {
        this.nomCrs = nomCrs;
    }

    public String getNomcrsIngles() {
        return nomcrsIngles;
    }

    public void setNomcrsIngles(String nomcrsIngles) {
        this.nomcrsIngles = nomcrsIngles;
    }

    public String getInformacionesESP() {
        return informacionesESP;
    }

    public void setInformacionesESP(String informacionesESP) {
        this.informacionesESP = informacionesESP;
    }

    public String getInformacionesING() {
        return informacionesING;
    }

    public void setInformacionesING(String informacionesING) {
        this.informacionesING = informacionesING;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public Cadssub getCodCadsub() {
        return codCadsub;
    }

    public void setCodCadsub(Cadssub codCadsub) {
        this.codCadsub = codCadsub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCrs != null ? codCrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crs)) {
            return false;
        }
        Crs other = (Crs) object;
        if ((this.codCrs == null && other.codCrs != null) || (this.codCrs != null && !this.codCrs.equals(other.codCrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Crs[ codCrs=" + codCrs + " ]";
    }
    
}
