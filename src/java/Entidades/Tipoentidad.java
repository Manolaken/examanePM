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
@Table(name = "tiposentidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoentidad.findAll", query = "SELECT t FROM Tipoentidad t")
    , @NamedQuery(name = "Tipoentidad.findByCodTipo", query = "SELECT t FROM Tipoentidad t WHERE t.codTipo = :codTipo")
    , @NamedQuery(name = "Tipoentidad.findByNomTipo", query = "SELECT t FROM Tipoentidad t WHERE t.nomTipo = :nomTipo")
    , @NamedQuery(name = "Tipoentidad.findByTipoOrganismo", query = "SELECT t FROM Tipoentidad t WHERE t.tipoOrganismo = :tipoOrganismo")})
public class Tipoentidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo")
    private Integer codTipo;
    @Size(max = 50)
    @Column(name = "nom_tipo")
    private String nomTipo;
    @Size(max = 3)
    @Column(name = "tipo_organismo")
    private String tipoOrganismo;
    @OneToMany(mappedBy = "tipoEntidad")
    private List<Proyecto> proyectoList;

    public Tipoentidad() {
    }

    public Tipoentidad(Integer codTipo) {
        this.codTipo = codTipo;
    }

    public Integer getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Integer codTipo) {
        this.codTipo = codTipo;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    public String getTipoOrganismo() {
        return tipoOrganismo;
    }

    public void setTipoOrganismo(String tipoOrganismo) {
        this.tipoOrganismo = tipoOrganismo;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipo != null ? codTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoentidad)) {
            return false;
        }
        Tipoentidad other = (Tipoentidad) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tipoentidad[ codTipo=" + codTipo + " ]";
    }
    
}
