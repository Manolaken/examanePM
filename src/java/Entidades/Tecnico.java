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
@Table(name = "tecnicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t")
    , @NamedQuery(name = "Tecnico.findByCodTecnico", query = "SELECT t FROM Tecnico t WHERE t.codTecnico = :codTecnico")
    , @NamedQuery(name = "Tecnico.findByNomTecnico", query = "SELECT t FROM Tecnico t WHERE t.nomTecnico = :nomTecnico")})
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tecnico")
    private Integer codTecnico;
    @Size(max = 100)
    @Column(name = "nom_tecnico")
    private String nomTecnico;
    @OneToMany(mappedBy = "tecFor")
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "tecSeg")
    private List<Proyecto> proyectoList1;

    public Tecnico() {
    }

    public Tecnico(Integer codTecnico) {
        this.codTecnico = codTecnico;
    }

    public Integer getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(Integer codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList1() {
        return proyectoList1;
    }

    public void setProyectoList1(List<Proyecto> proyectoList1) {
        this.proyectoList1 = proyectoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTecnico != null ? codTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.codTecnico == null && other.codTecnico != null) || (this.codTecnico != null && !this.codTecnico.equals(other.codTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tecnico[ codTecnico=" + codTecnico + " ]";
    }
    
}
