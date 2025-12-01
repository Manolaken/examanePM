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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "cadssub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadssub.findAll", query = "SELECT c FROM Cadssub c")
    , @NamedQuery(name = "Cadssub.findByCodSubcad", query = "SELECT c FROM Cadssub c WHERE c.codSubcad = :codSubcad")
    , @NamedQuery(name = "Cadssub.findByNomSubcad", query = "SELECT c FROM Cadssub c WHERE c.nomSubcad = :nomSubcad")
    , @NamedQuery(name = "Cadssub.findByNomsubcadING", query = "SELECT c FROM Cadssub c WHERE c.nomsubcadING = :nomsubcadING")})
public class Cadssub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_subcad")
    private Integer codSubcad;
    @Size(max = 100)
    @Column(name = "nom_subcad")
    private String nomSubcad;
    @Size(max = 100)
    @Column(name = "nom_subcadING")
    private String nomsubcadING;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionESP")
    private String informacionESP;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionING")
    private String informacionING;
    @OneToMany(mappedBy = "codCadsub")
    private List<Crs> crsList;
    @JoinColumn(name = "cod_cad", referencedColumnName = "cod_cad")
    @ManyToOne
    private cad codCad;

    public Cadssub() {
    }

    public Cadssub(Integer codSubcad) {
        this.codSubcad = codSubcad;
    }

    public Integer getCodSubcad() {
        return codSubcad;
    }

    public void setCodSubcad(Integer codSubcad) {
        this.codSubcad = codSubcad;
    }

    public String getNomSubcad() {
        return nomSubcad;
    }

    public void setNomSubcad(String nomSubcad) {
        this.nomSubcad = nomSubcad;
    }

    public String getNomsubcadING() {
        return nomsubcadING;
    }

    public void setNomsubcadING(String nomsubcadING) {
        this.nomsubcadING = nomsubcadING;
    }

    public String getInformacionESP() {
        return informacionESP;
    }

    public void setInformacionESP(String informacionESP) {
        this.informacionESP = informacionESP;
    }

    public String getInformacionING() {
        return informacionING;
    }

    public void setInformacionING(String informacionING) {
        this.informacionING = informacionING;
    }

    @XmlTransient
    public List<Crs> getCrsList() {
        return crsList;
    }

    public void setCrsList(List<Crs> crsList) {
        this.crsList = crsList;
    }

    public cad getCodCad() {
        return codCad;
    }

    public void setCodCad(cad codCad) {
        this.codCad = codCad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubcad != null ? codSubcad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadssub)) {
            return false;
        }
        Cadssub other = (Cadssub) object;
        if ((this.codSubcad == null && other.codSubcad != null) || (this.codSubcad != null && !this.codSubcad.equals(other.codSubcad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cadssub[ codSubcad=" + codSubcad + " ]";
    }
    
}
