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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmaic
 */
@Entity
@Table(name = "inspectorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inspectoria.findAll", query = "SELECT i FROM Inspectoria i")
    , @NamedQuery(name = "Inspectoria.findByCodigo", query = "SELECT i FROM Inspectoria i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Inspectoria.findBySocioLocal", query = "SELECT i FROM Inspectoria i WHERE i.socioLocal = :socioLocal")
    , @NamedQuery(name = "Inspectoria.findByCodInspectoria", query = "SELECT i FROM Inspectoria i WHERE i.codInspectoria = :codInspectoria")
    , @NamedQuery(name = "Inspectoria.findByNomInspectoria", query = "SELECT i FROM Inspectoria i WHERE i.nomInspectoria = :nomInspectoria")
    , @NamedQuery(name = "Inspectoria.findByResponsableLegal", query = "SELECT i FROM Inspectoria i WHERE i.responsableLegal = :responsableLegal")
    , @NamedQuery(name = "Inspectoria.findByOpd", query = "SELECT i FROM Inspectoria i WHERE i.opd = :opd")
    , @NamedQuery(name = "Inspectoria.findByOpdContactoNombre", query = "SELECT i FROM Inspectoria i WHERE i.opdContactoNombre = :opdContactoNombre")
    , @NamedQuery(name = "Inspectoria.findByOpdContactoMail", query = "SELECT i FROM Inspectoria i WHERE i.opdContactoMail = :opdContactoMail")
    , @NamedQuery(name = "Inspectoria.findByOpdContactoTelefono", query = "SELECT i FROM Inspectoria i WHERE i.opdContactoTelefono = :opdContactoTelefono")})
public class Inspectoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 4)
    @Column(name = "socio_local")
    private String socioLocal;
    @Size(max = 3)
    @Column(name = "cod_inspectoria")
    private String codInspectoria;
    @Size(max = 100)
    @Column(name = "nom_inspectoria")
    private String nomInspectoria;
    @Column(name = "responsable_legal")
    private Integer responsableLegal;
    @Size(max = 50)
    @Column(name = "opd")
    private String opd;
    @Column(name = "opd_contacto_nombre")
    private Integer opdContactoNombre;
    @Size(max = 100)
    @Column(name = "opd_contacto_mail")
    private String opdContactoMail;
    @Size(max = 20)
    @Column(name = "opd_contacto_telefono")
    private String opdContactoTelefono;
    @OneToMany(mappedBy = "codInspectoria")
    private List<Sede> sedeList;
    @OneToMany(mappedBy = "inspectoria")
    private List<Proyecto> proyectoList;

    public Inspectoria() {
    }

    public Inspectoria(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getSocioLocal() {
        return socioLocal;
    }

    public void setSocioLocal(String socioLocal) {
        this.socioLocal = socioLocal;
    }

    public String getCodInspectoria() {
        return codInspectoria;
    }

    public void setCodInspectoria(String codInspectoria) {
        this.codInspectoria = codInspectoria;
    }

    public String getNomInspectoria() {
        return nomInspectoria;
    }

    public void setNomInspectoria(String nomInspectoria) {
        this.nomInspectoria = nomInspectoria;
    }

    public Integer getResponsableLegal() {
        return responsableLegal;
    }

    public void setResponsableLegal(Integer responsableLegal) {
        this.responsableLegal = responsableLegal;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public Integer getOpdContactoNombre() {
        return opdContactoNombre;
    }

    public void setOpdContactoNombre(Integer opdContactoNombre) {
        this.opdContactoNombre = opdContactoNombre;
    }

    public String getOpdContactoMail() {
        return opdContactoMail;
    }

    public void setOpdContactoMail(String opdContactoMail) {
        this.opdContactoMail = opdContactoMail;
    }

    public String getOpdContactoTelefono() {
        return opdContactoTelefono;
    }

    public void setOpdContactoTelefono(String opdContactoTelefono) {
        this.opdContactoTelefono = opdContactoTelefono;
    }

    @XmlTransient
    public List<Sede> getSedeList() {
        return sedeList;
    }

    public void setSedeList(List<Sede> sedeList) {
        this.sedeList = sedeList;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspectoria)) {
            return false;
        }
        Inspectoria other = (Inspectoria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Inspectoria[ codigo=" + codigo + " ]";
    }
    
}
