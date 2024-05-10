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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadios")
@NamedQueries({
    @NamedQuery(name = "Estadios.findAll", query = "SELECT e FROM Estadios e"),
    @NamedQuery(name = "Estadios.findById", query = "SELECT e FROM Estadios e WHERE e.id = :id"),
    @NamedQuery(name = "Estadios.findByNombre", query = "SELECT e FROM Estadios e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estadios.findByCapacidad", query = "SELECT e FROM Estadios e WHERE e.capacidad = :capacidad"),
    @NamedQuery(name = "Estadios.findByCiudad", query = "SELECT e FROM Estadios e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Estadios.findByImagen", query = "SELECT e FROM Estadios e WHERE e.imagen = :imagen")})
public class Estadios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(mappedBy = "idEstadio")
    @JsonbTransient
    private Collection<Equipos> equiposCollection;

    public Estadios() {
    }

    public Estadios(Integer id) {
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

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Collection<Equipos> getEquiposCollection() {
        return equiposCollection;
    }

    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
        this.equiposCollection = equiposCollection;
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
        if (!(object instanceof Estadios)) {
            return false;
        }
        Estadios other = (Estadios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdinfonba.Estadios[ id=" + id + " ]";
    }
    
}
