package bdinfonba;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipos")
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e"),
    @NamedQuery(name = "Equipos.findById", query = "SELECT e FROM Equipos e WHERE e.id = :id"),
    @NamedQuery(name = "Equipos.findByNombre", query = "SELECT e FROM Equipos e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Equipos.findByCampeonatos", query = "SELECT e FROM Equipos e WHERE e.campeonatos = :campeonatos"),
    @NamedQuery(name = "Equipos.findByEntrenador", query = "SELECT e FROM Equipos e WHERE e.entrenador = :entrenador"),
    @NamedQuery(name = "Equipos.findByFundacion", query = "SELECT e FROM Equipos e WHERE e.fundacion = :fundacion"),
    @NamedQuery(name = "Equipos.findByCiudad", query = "SELECT e FROM Equipos e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Equipos.findByLogo", query = "SELECT e FROM Equipos e WHERE e.logo = :logo"),
    @NamedQuery(name = "Equipos.findByColorPrincipal", query = "SELECT e FROM Equipos e WHERE e.colorPrincipal = :colorPrincipal"),
    @NamedQuery(name = "Equipos.findByConferencia", query = "SELECT e FROM Equipos e WHERE e.conferencia = :conferencia"),
    @NamedQuery(name = "Equipos.findByVictorias", query = "SELECT e FROM Equipos e WHERE e.victorias = :victorias"),
    @NamedQuery(name = "Equipos.findByDerrotas", query = "SELECT e FROM Equipos e WHERE e.derrotas = :derrotas")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "campeonatos")
    private Integer campeonatos;
    @Column(name = "entrenador")
    private String entrenador;
    @Column(name = "fundacion")
    private String fundacion;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "logo")
    private String logo;
    @Column(name = "color_principal")
    private String colorPrincipal;
    @Column(name = "conferencia")
    private String conferencia;
    @Column(name = "victorias")
    private Integer victorias;
    @Column(name = "derrotas")
    private Integer derrotas;
    @OneToMany(mappedBy = "idEquipo")
    @JsonbTransient
    private Collection<Jugadores> jugadoresCollection;
    @OneToMany(mappedBy = "idEquipoLocal")
    @JsonbTransient
    private Collection<Partidos> partidosCollection;
    @OneToMany(mappedBy = "idEquipoVisitante")
    @JsonbTransient
    private Collection<Partidos> partidosCollection1;
    @JoinColumn(name = "id_estadio", referencedColumnName = "id")
    @ManyToOne
    private Estadios idEstadio;

    public Equipos() {
    }

    public Equipos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(Integer campeonatos) {
        this.campeonatos = campeonatos;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public Integer getVictorias() {
        return victorias;
    }

    public void setVictorias(Integer victorias) {
        this.victorias = victorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Collection<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(Collection<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
    }

    public Collection<Partidos> getPartidosCollection() {
        return partidosCollection;
    }

    public void setPartidosCollection(Collection<Partidos> partidosCollection) {
        this.partidosCollection = partidosCollection;
    }

    public Collection<Partidos> getPartidosCollection1() {
        return partidosCollection1;
    }

    public void setPartidosCollection1(Collection<Partidos> partidosCollection1) {
        this.partidosCollection1 = partidosCollection1;
    }

    public Estadios getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(Estadios idEstadio) {
        this.idEstadio = idEstadio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdinfonba.Equipos[ id=" + id + " ]";
    }
    
}
