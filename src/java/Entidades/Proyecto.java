/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmaic
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByCodProyecto", query = "SELECT p FROM Proyecto p WHERE p.codProyecto = :codProyecto")
    , @NamedQuery(name = "Proyecto.findByOng", query = "SELECT p FROM Proyecto p WHERE p.ong = :ong")
    , @NamedQuery(name = "Proyecto.findByCodigo", query = "SELECT p FROM Proyecto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Proyecto.findByParte", query = "SELECT p FROM Proyecto p WHERE p.parte = :parte")
    , @NamedQuery(name = "Proyecto.findByReferencia", query = "SELECT p FROM Proyecto p WHERE p.referencia = :referencia")
    , @NamedQuery(name = "Proyecto.findByNumProyecto", query = "SELECT p FROM Proyecto p WHERE p.numProyecto = :numProyecto")
    , @NamedQuery(name = "Proyecto.findByInstrumento", query = "SELECT p FROM Proyecto p WHERE p.instrumento = :instrumento")
    , @NamedQuery(name = "Proyecto.findByLocalizacion", query = "SELECT p FROM Proyecto p WHERE p.localizacion = :localizacion")
    , @NamedQuery(name = "Proyecto.findByTitulo", query = "SELECT p FROM Proyecto p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Proyecto.findBySocioLocal", query = "SELECT p FROM Proyecto p WHERE p.socioLocal = :socioLocal")
    , @NamedQuery(name = "Proyecto.findByRegionSdb", query = "SELECT p FROM Proyecto p WHERE p.regionSdb = :regionSdb")
    , @NamedQuery(name = "Proyecto.findByResponsableLegal", query = "SELECT p FROM Proyecto p WHERE p.responsableLegal = :responsableLegal")
    , @NamedQuery(name = "Proyecto.findByOpd", query = "SELECT p FROM Proyecto p WHERE p.opd = :opd")
    , @NamedQuery(name = "Proyecto.findByOpdContactoNombre", query = "SELECT p FROM Proyecto p WHERE p.opdContactoNombre = :opdContactoNombre")
    , @NamedQuery(name = "Proyecto.findByOpdContactoMail", query = "SELECT p FROM Proyecto p WHERE p.opdContactoMail = :opdContactoMail")
    , @NamedQuery(name = "Proyecto.findByOpdContactoTelefono", query = "SELECT p FROM Proyecto p WHERE p.opdContactoTelefono = :opdContactoTelefono")
    , @NamedQuery(name = "Proyecto.findByResponsableLocal", query = "SELECT p FROM Proyecto p WHERE p.responsableLocal = :responsableLocal")
    , @NamedQuery(name = "Proyecto.findByCostoTotal", query = "SELECT p FROM Proyecto p WHERE p.costoTotal = :costoTotal")
    , @NamedQuery(name = "Proyecto.findByDineroSolicitado", query = "SELECT p FROM Proyecto p WHERE p.dineroSolicitado = :dineroSolicitado")
    , @NamedQuery(name = "Proyecto.findByAprobado", query = "SELECT p FROM Proyecto p WHERE p.aprobado = :aprobado")
    , @NamedQuery(name = "Proyecto.findByDocConcesion", query = "SELECT p FROM Proyecto p WHERE p.docConcesion = :docConcesion")
    , @NamedQuery(name = "Proyecto.findByFechaConcesion", query = "SELECT p FROM Proyecto p WHERE p.fechaConcesion = :fechaConcesion")
    , @NamedQuery(name = "Proyecto.findByDineroConcedido", query = "SELECT p FROM Proyecto p WHERE p.dineroConcedido = :dineroConcedido")
    , @NamedQuery(name = "Proyecto.findByCd", query = "SELECT p FROM Proyecto p WHERE p.cd = :cd")
    , @NamedQuery(name = "Proyecto.findByCdSedeLocal", query = "SELECT p FROM Proyecto p WHERE p.cdSedeLocal = :cdSedeLocal")
    , @NamedQuery(name = "Proyecto.findByCi", query = "SELECT p FROM Proyecto p WHERE p.ci = :ci")
    , @NamedQuery(name = "Proyecto.findByCiMs", query = "SELECT p FROM Proyecto p WHERE p.ciMs = :ciMs")
    , @NamedQuery(name = "Proyecto.findByCiSocioLocal", query = "SELECT p FROM Proyecto p WHERE p.ciSocioLocal = :ciSocioLocal")
    , @NamedQuery(name = "Proyecto.findByApoCdMs", query = "SELECT p FROM Proyecto p WHERE p.apoCdMs = :apoCdMs")
    , @NamedQuery(name = "Proyecto.findByDuracionReal", query = "SELECT p FROM Proyecto p WHERE p.duracionReal = :duracionReal")
    , @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin")
    , @NamedQuery(name = "Proyecto.findByFechaFinAmpliacion", query = "SELECT p FROM Proyecto p WHERE p.fechaFinAmpliacion = :fechaFinAmpliacion")
    , @NamedQuery(name = "Proyecto.findByDuracionTrasAmpliacion", query = "SELECT p FROM Proyecto p WHERE p.duracionTrasAmpliacion = :duracionTrasAmpliacion")
    , @NamedQuery(name = "Proyecto.findByDuracionIF", query = "SELECT p FROM Proyecto p WHERE p.duracionIF = :duracionIF")
    , @NamedQuery(name = "Proyecto.findByFechamaximaIF", query = "SELECT p FROM Proyecto p WHERE p.fechamaximaIF = :fechamaximaIF")
    , @NamedQuery(name = "Proyecto.findByIngles", query = "SELECT p FROM Proyecto p WHERE p.ingles = :ingles")
    , @NamedQuery(name = "Proyecto.findByTarget", query = "SELECT p FROM Proyecto p WHERE p.target = :target")
    , @NamedQuery(name = "Proyecto.findByTipoProyecto", query = "SELECT p FROM Proyecto p WHERE p.tipoProyecto = :tipoProyecto")
    , @NamedQuery(name = "Proyecto.findByFechaCierre", query = "SELECT p FROM Proyecto p WHERE p.fechaCierre = :fechaCierre")
    , @NamedQuery(name = "Proyecto.findByCerrado", query = "SELECT p FROM Proyecto p WHERE p.cerrado = :cerrado")
    , @NamedQuery(name = "Proyecto.findBySectorJYD", query = "SELECT p FROM Proyecto p WHERE p.sectorJYD = :sectorJYD")
    , @NamedQuery(name = "Proyecto.findBySubsectorJYD", query = "SELECT p FROM Proyecto p WHERE p.subsectorJYD = :subsectorJYD")
    , @NamedQuery(name = "Proyecto.findBySectorCAD", query = "SELECT p FROM Proyecto p WHERE p.sectorCAD = :sectorCAD")
    , @NamedQuery(name = "Proyecto.findByNumBeneficiarios", query = "SELECT p FROM Proyecto p WHERE p.numBeneficiarios = :numBeneficiarios")
    , @NamedQuery(name = "Proyecto.findByNumBeneficiariosMujeres", query = "SELECT p FROM Proyecto p WHERE p.numBeneficiariosMujeres = :numBeneficiariosMujeres")
    , @NamedQuery(name = "Proyecto.findByNumBeneficiariosHombres", query = "SELECT p FROM Proyecto p WHERE p.numBeneficiariosHombres = :numBeneficiariosHombres")
    , @NamedQuery(name = "Proyecto.findByDescripcionBeneficiarios", query = "SELECT p FROM Proyecto p WHERE p.descripcionBeneficiarios = :descripcionBeneficiarios")
    , @NamedQuery(name = "Proyecto.findByNumBeneficiarioInd", query = "SELECT p FROM Proyecto p WHERE p.numBeneficiarioInd = :numBeneficiarioInd")
    , @NamedQuery(name = "Proyecto.findByNumEntidadesBeneficiarias", query = "SELECT p FROM Proyecto p WHERE p.numEntidadesBeneficiarias = :numEntidadesBeneficiarias")
    , @NamedQuery(name = "Proyecto.findByInformeDonante", query = "SELECT p FROM Proyecto p WHERE p.informeDonante = :informeDonante")
    , @NamedQuery(name = "Proyecto.findByCategoria", query = "SELECT p FROM Proyecto p WHERE p.categoria = :categoria")
    , @NamedQuery(name = "Proyecto.findBySubcategoria", query = "SELECT p FROM Proyecto p WHERE p.subcategoria = :subcategoria")
    , @NamedQuery(name = "Proyecto.findByExtinguido", query = "SELECT p FROM Proyecto p WHERE p.extinguido = :extinguido")
    , @NamedQuery(name = "Proyecto.findByInspectoria", query = "SELECT p FROM Proyecto p WHERE p.inspectoria = :inspectoria ORDER BY p.anyo DESC")
    , @NamedQuery(name = "Proyecto.findByPais", query = "SELECT p FROM Proyecto p WHERE p.pais = :pais ORDER BY p.anyo DESC")
    , @NamedQuery(name = "Proyecto.findByAnyo", query = "SELECT p FROM Proyecto p WHERE p.anyo = :anyo ORDER BY p.codigo")
    , @NamedQuery(name = "Proyecto.findByStatus", query = "SELECT p FROM Proyecto p WHERE p.status = :status ORDER BY p.anyo DESC")
    , @NamedQuery(name = "Proyecto.findByPaisAndAnyo", query = "SELECT p FROM Proyecto p WHERE p.pais = :pais AND p.anyo = :anyo ORDER BY p.codigo")
    , @NamedQuery(name = "Proyecto.countByPais", query = "SELECT p.pais, COUNT(p) FROM Proyecto p GROUP BY p.pais ORDER BY COUNT(p) DESC")
    , @NamedQuery(name = "Proyecto.sumDineroByAnyo", query = "SELECT p.anyo, SUM(p.dineroConcedido) FROM Proyecto p GROUP BY p.anyo ORDER BY p.anyo")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_proyecto")
    private Integer codProyecto;
    @Size(max = 3)
    @Column(name = "ong")
    private String ong;
    @Size(max = 15)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "parte")
    private Short parte;
    @Size(max = 20)
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "num_proyecto")
    private Integer numProyecto;
    @Size(max = 20)
    @Column(name = "instrumento")
    private String instrumento;
    @Size(max = 2)
    @Column(name = "pais")
    private String pais;
    @Size(max = 255)
    @Column(name = "localizacion")
    private String localizacion;
    @Column(name = "anyo")
    private Integer anyo;
    @Size(max = 255)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 3)
    @Column(name = "socio_local")
    private String socioLocal;
    @Size(max = 255)
    @Column(name = "region_sdb")
    private String regionSdb;
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
    @Column(name = "responsable_local")
    private Integer responsableLocal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_total")
    private Double costoTotal;
    @Column(name = "dinero_solicitado")
    private Double dineroSolicitado;
    @Column(name = "aprobado")
    private Boolean aprobado;
    @Size(max = 255)
    @Column(name = "doc_concesion")
    private String docConcesion;
    @Column(name = "fecha_concesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConcesion;
    @Column(name = "dinero_concedido")
    private Double dineroConcedido;
    @Column(name = "cd")
    private Double cd;
    @Column(name = "cd_sede_local")
    private Double cdSedeLocal;
    @Column(name = "ci")
    private Double ci;
    @Column(name = "ci_ms")
    private Double ciMs;
    @Column(name = "ci_socio_local")
    private Double ciSocioLocal;
    @Column(name = "apo_cd_ms")
    private Double apoCdMs;
    @Column(name = "duracion_real")
    private Integer duracionReal;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "fecha_fin_ampliacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinAmpliacion;
    @Column(name = "duracion_tras_ampliacion")
    private Integer duracionTrasAmpliacion;
    @Column(name = "duracionIF")
    private Integer duracionIF;
    @Column(name = "fecha_maximaIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamaximaIF;
    @Size(max = 255)
    @Column(name = "ingles")
    private String ingles;
    @Column(name = "status")
    private Integer status;
    @Size(max = 4)
    @Column(name = "target")
    private String target;
    @Column(name = "tipo_proyecto")
    private Integer tipoProyecto;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Column(name = "cerrado")
    private Boolean cerrado;
    @Size(max = 3)
    @Column(name = "sectorJYD")
    private String sectorJYD;
    @Size(max = 3)
    @Column(name = "subsectorJYD")
    private String subsectorJYD;
    @Column(name = "sectorCAD")
    private Integer sectorCAD;
    @Column(name = "num_beneficiarios")
    private Integer numBeneficiarios;
    @Column(name = "num_beneficiarios_mujeres")
    private Integer numBeneficiariosMujeres;
    @Column(name = "num_beneficiarios_hombres")
    private Integer numBeneficiariosHombres;
    @Size(max = 255)
    @Column(name = "descripcion_beneficiarios")
    private String descripcionBeneficiarios;
    @Column(name = "num_beneficiario_ind")
    private Integer numBeneficiarioInd;
    @Size(max = 50)
    @Column(name = "num_entidades_beneficiarias")
    private String numEntidadesBeneficiarias;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentarios")
    private String comentarios;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "justificacion")
    private String justificacion;
    @Column(name = "informe_donante")
    private Boolean informeDonante;
    @Column(name = "categoria")
    private Short categoria;
    @Column(name = "subcategoria")
    private Short subcategoria;
    @Column(name = "extinguido")
    private Boolean extinguido;
    @ManyToMany(mappedBy = "proyectoList")
    private List<Odsprincipal> odsprincipalList;
    @ManyToMany(mappedBy = "proyectoList")
    private List<Crs> crsList;
    @JoinColumn(name = "tec_for", referencedColumnName = "cod_tecnico")
    @ManyToOne
    private Tecnico tecFor;
    @JoinColumn(name = "tec_seg", referencedColumnName = "cod_tecnico")
    @ManyToOne
    private Tecnico tecSeg;
    @JoinColumn(name = "tipo_entidad", referencedColumnName = "cod_tipo")
    @ManyToOne
    private Tipoentidad tipoEntidad;
    @JoinColumn(name = "sede", referencedColumnName = "cod_sede")
    @ManyToOne
    private Sede sede;
    @JoinColumn(name = "inspectoria", referencedColumnName = "cod_inspectoria")
    @ManyToOne
    private Inspectoria inspectoria;
    @JoinColumn(name = "sectorMS", referencedColumnName = "cod_sector")
    @ManyToOne
    private Sector sectorMS;
    @JoinColumn(name = "subsectorMS", referencedColumnName = "cod_subsector")
    @ManyToOne
    private Subsector subsectorMS;
    @JoinColumn(name = "entidad", referencedColumnName = "codigo")
    @ManyToOne
    private Entidad entidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<Envio> envioList;

    public Proyecto() {
    }

    public Proyecto(Integer codProyecto) {
        this.codProyecto = codProyecto;
    }

    public Integer getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Integer codProyecto) {
        this.codProyecto = codProyecto;
    }

    public String getOng() {
        return ong;
    }

    public void setOng(String ong) {
        this.ong = ong;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Short getParte() {
        return parte;
    }

    public void setParte(Short parte) {
        this.parte = parte;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getNumProyecto() {
        return numProyecto;
    }

    public void setNumProyecto(Integer numProyecto) {
        this.numProyecto = numProyecto;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Integer getAnyo() {
        return anyo;
    }

    public void setAnyo(Integer anyo) {
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSocioLocal() {
        return socioLocal;
    }

    public void setSocioLocal(String socioLocal) {
        this.socioLocal = socioLocal;
    }

    public String getRegionSdb() {
        return regionSdb;
    }

    public void setRegionSdb(String regionSdb) {
        this.regionSdb = regionSdb;
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

    public Integer getResponsableLocal() {
        return responsableLocal;
    }

    public void setResponsableLocal(Integer responsableLocal) {
        this.responsableLocal = responsableLocal;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Double getDineroSolicitado() {
        return dineroSolicitado;
    }

    public void setDineroSolicitado(Double dineroSolicitado) {
        this.dineroSolicitado = dineroSolicitado;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getDocConcesion() {
        return docConcesion;
    }

    public void setDocConcesion(String docConcesion) {
        this.docConcesion = docConcesion;
    }

    public Date getFechaConcesion() {
        return fechaConcesion;
    }

    public void setFechaConcesion(Date fechaConcesion) {
        this.fechaConcesion = fechaConcesion;
    }

    public Double getDineroConcedido() {
        return dineroConcedido;
    }

    public void setDineroConcedido(Double dineroConcedido) {
        this.dineroConcedido = dineroConcedido;
    }

    public Double getCd() {
        return cd;
    }

    public void setCd(Double cd) {
        this.cd = cd;
    }

    public Double getCdSedeLocal() {
        return cdSedeLocal;
    }

    public void setCdSedeLocal(Double cdSedeLocal) {
        this.cdSedeLocal = cdSedeLocal;
    }

    public Double getCi() {
        return ci;
    }

    public void setCi(Double ci) {
        this.ci = ci;
    }

    public Double getCiMs() {
        return ciMs;
    }

    public void setCiMs(Double ciMs) {
        this.ciMs = ciMs;
    }

    public Double getCiSocioLocal() {
        return ciSocioLocal;
    }

    public void setCiSocioLocal(Double ciSocioLocal) {
        this.ciSocioLocal = ciSocioLocal;
    }

    public Double getApoCdMs() {
        return apoCdMs;
    }

    public void setApoCdMs(Double apoCdMs) {
        this.apoCdMs = apoCdMs;
    }

    public Integer getDuracionReal() {
        return duracionReal;
    }

    public void setDuracionReal(Integer duracionReal) {
        this.duracionReal = duracionReal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFinAmpliacion() {
        return fechaFinAmpliacion;
    }

    public void setFechaFinAmpliacion(Date fechaFinAmpliacion) {
        this.fechaFinAmpliacion = fechaFinAmpliacion;
    }

    public Integer getDuracionTrasAmpliacion() {
        return duracionTrasAmpliacion;
    }

    public void setDuracionTrasAmpliacion(Integer duracionTrasAmpliacion) {
        this.duracionTrasAmpliacion = duracionTrasAmpliacion;
    }

    public Integer getDuracionIF() {
        return duracionIF;
    }

    public void setDuracionIF(Integer duracionIF) {
        this.duracionIF = duracionIF;
    }

    public Date getFechamaximaIF() {
        return fechamaximaIF;
    }

    public void setFechamaximaIF(Date fechamaximaIF) {
        this.fechamaximaIF = fechamaximaIF;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(Integer tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public String getSectorJYD() {
        return sectorJYD;
    }

    public void setSectorJYD(String sectorJYD) {
        this.sectorJYD = sectorJYD;
    }

    public String getSubsectorJYD() {
        return subsectorJYD;
    }

    public void setSubsectorJYD(String subsectorJYD) {
        this.subsectorJYD = subsectorJYD;
    }

    public Integer getSectorCAD() {
        return sectorCAD;
    }

    public void setSectorCAD(Integer sectorCAD) {
        this.sectorCAD = sectorCAD;
    }

    public Integer getNumBeneficiarios() {
        return numBeneficiarios;
    }

    public void setNumBeneficiarios(Integer numBeneficiarios) {
        this.numBeneficiarios = numBeneficiarios;
    }

    public Integer getNumBeneficiariosMujeres() {
        return numBeneficiariosMujeres;
    }

    public void setNumBeneficiariosMujeres(Integer numBeneficiariosMujeres) {
        this.numBeneficiariosMujeres = numBeneficiariosMujeres;
    }

    public Integer getNumBeneficiariosHombres() {
        return numBeneficiariosHombres;
    }

    public void setNumBeneficiariosHombres(Integer numBeneficiariosHombres) {
        this.numBeneficiariosHombres = numBeneficiariosHombres;
    }

    public String getDescripcionBeneficiarios() {
        return descripcionBeneficiarios;
    }

    public void setDescripcionBeneficiarios(String descripcionBeneficiarios) {
        this.descripcionBeneficiarios = descripcionBeneficiarios;
    }

    public Integer getNumBeneficiarioInd() {
        return numBeneficiarioInd;
    }

    public void setNumBeneficiarioInd(Integer numBeneficiarioInd) {
        this.numBeneficiarioInd = numBeneficiarioInd;
    }

    public String getNumEntidadesBeneficiarias() {
        return numEntidadesBeneficiarias;
    }

    public void setNumEntidadesBeneficiarias(String numEntidadesBeneficiarias) {
        this.numEntidadesBeneficiarias = numEntidadesBeneficiarias;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Boolean getInformeDonante() {
        return informeDonante;
    }

    public void setInformeDonante(Boolean informeDonante) {
        this.informeDonante = informeDonante;
    }

    public Short getCategoria() {
        return categoria;
    }

    public void setCategoria(Short categoria) {
        this.categoria = categoria;
    }

    public Short getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Short subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Boolean getExtinguido() {
        return extinguido;
    }

    public void setExtinguido(Boolean extinguido) {
        this.extinguido = extinguido;
    }

    @XmlTransient
    public List<Odsprincipal> getOdsprincipalList() {
        return odsprincipalList;
    }

    public void setOdsprincipalList(List<Odsprincipal> odsprincipalList) {
        this.odsprincipalList = odsprincipalList;
    }

    @XmlTransient
    public List<Crs> getCrsList() {
        return crsList;
    }

    public void setCrsList(List<Crs> crsList) {
        this.crsList = crsList;
    }

    public Tecnico getTecFor() {
        return tecFor;
    }

    public void setTecFor(Tecnico tecFor) {
        this.tecFor = tecFor;
    }

    public Tecnico getTecSeg() {
        return tecSeg;
    }

    public void setTecSeg(Tecnico tecSeg) {
        this.tecSeg = tecSeg;
    }

    public Tipoentidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(Tipoentidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Inspectoria getInspectoria() {
        return inspectoria;
    }

    public void setInspectoria(Inspectoria inspectoria) {
        this.inspectoria = inspectoria;
    }

    public Sector getSectorMS() {
        return sectorMS;
    }

    public void setSectorMS(Sector sectorMS) {
        this.sectorMS = sectorMS;
    }

    public Subsector getSubsectorMS() {
        return subsectorMS;
    }

    public void setSubsectorMS(Subsector subsectorMS) {
        this.subsectorMS = subsectorMS;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    @XmlTransient
    public List<Envio> getEnvioList() {
        return envioList;
    }

    public void setEnvioList(List<Envio> envioList) {
        this.envioList = envioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProyecto != null ? codProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.codProyecto == null && other.codProyecto != null) || (this.codProyecto != null && !this.codProyecto.equals(other.codProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Proyecto[ codProyecto=" + codProyecto + " ]";
    }
    
}
