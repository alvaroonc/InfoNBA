package bdinfonba;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "jugadores")
@NamedQueries({
    @NamedQuery(name = "Jugadores.findAll", query = "SELECT j FROM Jugadores j"),
    @NamedQuery(name = "Jugadores.findById", query = "SELECT j FROM Jugadores j WHERE j.id = :id"),
    @NamedQuery(name = "Jugadores.findByNombre", query = "SELECT j FROM Jugadores j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jugadores.findByApellido", query = "SELECT j FROM Jugadores j WHERE j.apellido = :apellido"),
    @NamedQuery(name = "Jugadores.findByPosicion", query = "SELECT j FROM Jugadores j WHERE j.posicion = :posicion"),
    @NamedQuery(name = "Jugadores.findByAltura", query = "SELECT j FROM Jugadores j WHERE j.altura = :altura"),
    @NamedQuery(name = "Jugadores.findByPeso", query = "SELECT j FROM Jugadores j WHERE j.peso = :peso"),
    @NamedQuery(name = "Jugadores.findByDorsal", query = "SELECT j FROM Jugadores j WHERE j.dorsal = :dorsal"),
    @NamedQuery(name = "Jugadores.findByPartidosJugados", query = "SELECT j FROM Jugadores j WHERE j.partidosJugados = :partidosJugados"),
    @NamedQuery(name = "Jugadores.findByPuntos", query = "SELECT j FROM Jugadores j WHERE j.puntos = :puntos"),
    @NamedQuery(name = "Jugadores.findByAsistencias", query = "SELECT j FROM Jugadores j WHERE j.asistencias = :asistencias"),
    @NamedQuery(name = "Jugadores.findByRebotes", query = "SELECT j FROM Jugadores j WHERE j.rebotes = :rebotes")})
public class Jugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "posicion")
    private String posicion;
    @Column(name = "altura")
    private Integer altura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "dorsal")
    private Integer dorsal;
    @Column(name = "partidos_jugados")
    private Integer partidosJugados;
    @Column(name = "puntos")
    private Integer puntos;
    @Column(name = "asistencias")
    private Integer asistencias;
    @Column(name = "rebotes")
    private Integer rebotes;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id")
    @ManyToOne
    private Equipos idEquipo;

    public Jugadores() {
    }

    public Jugadores(Integer id) {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(Integer partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getRebotes() {
        return rebotes;
    }

    public void setRebotes(Integer rebotes) {
        this.rebotes = rebotes;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos idEquipo) {
        this.idEquipo = idEquipo;
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
        if (!(object instanceof Jugadores)) {
            return false;
        }
        Jugadores other = (Jugadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdinfonba.Jugadores[ id=" + id + " ]";
    }
    
}
