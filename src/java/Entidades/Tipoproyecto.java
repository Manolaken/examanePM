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
@Table(name = "tiposproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoproyecto.findAll", query = "SELECT t FROM Tipoproyecto t")
    , @NamedQuery(name = "Tipoproyecto.findByCodTipo", query = "SELECT t FROM Tipoproyecto t WHERE t.codTipo = :codTipo")
    , @NamedQuery(name = "Tipoproyecto.findByNomTipo", query = "SELECT t FROM Tipoproyecto t WHERE t.nomTipo = :nomTipo")
    , @NamedQuery(name = "Tipoproyecto.findByNomtipoING", query = "SELECT t FROM Tipoproyecto t WHERE t.nomtipoING = :nomtipoING")})
public class Tipoproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo")
    private Integer codTipo;
    @Size(max = 100)
    @Column(name = "nom_tipo")
    private String nomTipo;
    @Size(max = 100)
    @Column(name = "nom_tipoING")
    private String nomtipoING;

    public Tipoproyecto() {
    }

    public Tipoproyecto(Integer codTipo) {
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

    public String getNomtipoING() {
        return nomtipoING;
    }

    public void setNomtipoING(String nomtipoING) {
        this.nomtipoING = nomtipoING;
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
        if (!(object instanceof Tipoproyecto)) {
            return false;
        }
        Tipoproyecto other = (Tipoproyecto) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tipoproyecto[ codTipo=" + codTipo + " ]";
    }
    
}
