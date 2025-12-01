/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "responsables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r")
    , @NamedQuery(name = "Responsable.findByCodResponsable", query = "SELECT r FROM Responsable r WHERE r.codResponsable = :codResponsable")
    , @NamedQuery(name = "Responsable.findByNomResponsable", query = "SELECT r FROM Responsable r WHERE r.nomResponsable = :nomResponsable")
    , @NamedQuery(name = "Responsable.findByTratamiento", query = "SELECT r FROM Responsable r WHERE r.tratamiento = :tratamiento")
    , @NamedQuery(name = "Responsable.findByTipoMisionero", query = "SELECT r FROM Responsable r WHERE r.tipoMisionero = :tipoMisionero")})
public class Responsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_responsable")
    private Integer codResponsable;
    @Size(max = 100)
    @Column(name = "nom_responsable")
    private String nomResponsable;
    @Size(max = 50)
    @Column(name = "tratamiento")
    private String tratamiento;
    @Size(max = 3)
    @Column(name = "tipo_misionero")
    private String tipoMisionero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsable")
    private List<Sederesponsable> sederesponsableList;

    public Responsable() {
    }

    public Responsable(Integer codResponsable) {
        this.codResponsable = codResponsable;
    }

    public Integer getCodResponsable() {
        return codResponsable;
    }

    public void setCodResponsable(Integer codResponsable) {
        this.codResponsable = codResponsable;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getTipoMisionero() {
        return tipoMisionero;
    }

    public void setTipoMisionero(String tipoMisionero) {
        this.tipoMisionero = tipoMisionero;
    }

    @XmlTransient
    public List<Sederesponsable> getSederesponsableList() {
        return sederesponsableList;
    }

    public void setSederesponsableList(List<Sederesponsable> sederesponsableList) {
        this.sederesponsableList = sederesponsableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codResponsable != null ? codResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.codResponsable == null && other.codResponsable != null) || (this.codResponsable != null && !this.codResponsable.equals(other.codResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Responsable[ codResponsable=" + codResponsable + " ]";
    }
    
}
