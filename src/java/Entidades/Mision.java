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
@Table(name = "misiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mision.findAll", query = "SELECT m FROM Mision m")
    , @NamedQuery(name = "Mision.findByCodMision", query = "SELECT m FROM Mision m WHERE m.codMision = :codMision")
    , @NamedQuery(name = "Mision.findByNomMision", query = "SELECT m FROM Mision m WHERE m.nomMision = :nomMision")
    , @NamedQuery(name = "Mision.findByCodInspectoria", query = "SELECT m FROM Mision m WHERE m.codInspectoria = :codInspectoria")
    , @NamedQuery(name = "Mision.findByDireccion1", query = "SELECT m FROM Mision m WHERE m.direccion1 = :direccion1")
    , @NamedQuery(name = "Mision.findByDireccion2", query = "SELECT m FROM Mision m WHERE m.direccion2 = :direccion2")
    , @NamedQuery(name = "Mision.findByProvincia", query = "SELECT m FROM Mision m WHERE m.provincia = :provincia")
    , @NamedQuery(name = "Mision.findByCiudad", query = "SELECT m FROM Mision m WHERE m.ciudad = :ciudad")
    , @NamedQuery(name = "Mision.findByPais", query = "SELECT m FROM Mision m WHERE m.pais = :pais")
    , @NamedQuery(name = "Mision.findByTelefono", query = "SELECT m FROM Mision m WHERE m.telefono = :telefono")})
public class Mision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_mision")
    private Integer codMision;
    @Size(max = 255)
    @Column(name = "nom_mision")
    private String nomMision;
    @Size(max = 3)
    @Column(name = "cod_inspectoria")
    private String codInspectoria;
    @Size(max = 255)
    @Column(name = "direccion1")
    private String direccion1;
    @Size(max = 255)
    @Column(name = "direccion2")
    private String direccion2;
    @Size(max = 100)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 4)
    @Column(name = "pais")
    private String pais;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;

    public Mision() {
    }

    public Mision(Integer codMision) {
        this.codMision = codMision;
    }

    public Integer getCodMision() {
        return codMision;
    }

    public void setCodMision(Integer codMision) {
        this.codMision = codMision;
    }

    public String getNomMision() {
        return nomMision;
    }

    public void setNomMision(String nomMision) {
        this.nomMision = nomMision;
    }

    public String getCodInspectoria() {
        return codInspectoria;
    }

    public void setCodInspectoria(String codInspectoria) {
        this.codInspectoria = codInspectoria;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMision != null ? codMision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mision)) {
            return false;
        }
        Mision other = (Mision) object;
        if ((this.codMision == null && other.codMision != null) || (this.codMision != null && !this.codMision.equals(other.codMision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Mision[ codMision=" + codMision + " ]";
    }
    
}
