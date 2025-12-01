/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmaic
 */
@Entity
@Table(name = "envios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envio.findAll", query = "SELECT e FROM Envio e")
    , @NamedQuery(name = "Envio.findByCodigo", query = "SELECT e FROM Envio e WHERE e.envioPK.codigo = :codigo")
    , @NamedQuery(name = "Envio.findByFecha", query = "SELECT e FROM Envio e WHERE e.envioPK.fecha = :fecha")
    , @NamedQuery(name = "Envio.findByCantidad", query = "SELECT e FROM Envio e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "Envio.findByAcuseReciboMs", query = "SELECT e FROM Envio e WHERE e.acuseReciboMs = :acuseReciboMs")
    , @NamedQuery(name = "Envio.findByAcuseBanco", query = "SELECT e FROM Envio e WHERE e.acuseBanco = :acuseBanco")})
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnvioPK envioPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "acuse_recibo_ms")
    private Boolean acuseReciboMs;
    @Column(name = "acuse_banco")
    private Boolean acuseBanco;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public Envio() {
    }

    public Envio(EnvioPK envioPK) {
        this.envioPK = envioPK;
    }

    public Envio(String codigo, Date fecha) {
        this.envioPK = new EnvioPK(codigo, fecha);
    }

    public EnvioPK getEnvioPK() {
        return envioPK;
    }

    public void setEnvioPK(EnvioPK envioPK) {
        this.envioPK = envioPK;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getAcuseReciboMs() {
        return acuseReciboMs;
    }

    public void setAcuseReciboMs(Boolean acuseReciboMs) {
        this.acuseReciboMs = acuseReciboMs;
    }

    public Boolean getAcuseBanco() {
        return acuseBanco;
    }

    public void setAcuseBanco(Boolean acuseBanco) {
        this.acuseBanco = acuseBanco;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (envioPK != null ? envioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        if ((this.envioPK == null && other.envioPK != null) || (this.envioPK != null && !this.envioPK.equals(other.envioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Envio[ envioPK=" + envioPK + " ]";
    }
    
}
