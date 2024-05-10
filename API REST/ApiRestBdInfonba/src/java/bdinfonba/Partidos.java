package bdinfonba;

import java.io.Serializable;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "partidos")
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p"),
    @NamedQuery(name = "Partidos.findById", query = "SELECT p FROM Partidos p WHERE p.id = :id"),
    @NamedQuery(name = "Partidos.findByPuntosLocal", query = "SELECT p FROM Partidos p WHERE p.puntosLocal = :puntosLocal"),
    @NamedQuery(name = "Partidos.findByPuntosVisitante", query = "SELECT p FROM Partidos p WHERE p.puntosVisitante = :puntosVisitante")})
public class Partidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "puntos_local")
    private Integer puntosLocal;
    @Column(name = "puntos_visitante")
    private Integer puntosVisitante;
    @JoinColumn(name = "id_equipo_local", referencedColumnName = "id")
    @ManyToOne
    private Equipos idEquipoLocal;
    @JoinColumn(name = "id_equipo_visitante", referencedColumnName = "id")
    @ManyToOne
    private Equipos idEquipoVisitante;
    @JoinColumn(name = "id_estadio", referencedColumnName = "id")
    @ManyToOne
    private Estadios idEstadio;

    public Partidos() {
    }

    public Partidos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(Integer puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public Integer getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(Integer puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public Equipos getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(Equipos idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public Equipos getIdEquipoVisitante() {
        return idEquipoVisitante;
    }

    public void setIdEquipoVisitante(Equipos idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
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
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdinfonba.Partidos[ id=" + id + " ]";
    }
    
}
