package bdinfonba;

import bdinfonba.exceptions.NonexistentEntityException;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EquiposJpaController implements Serializable {

    public EquiposJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipos equipos) {
        if (equipos.getJugadoresCollection() == null) {
            equipos.setJugadoresCollection(new ArrayList<Jugadores>());
        }
        if (equipos.getPartidosCollection() == null) {
            equipos.setPartidosCollection(new ArrayList<Partidos>());
        }
        if (equipos.getPartidosCollection1() == null) {
            equipos.setPartidosCollection1(new ArrayList<Partidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadios idEstadio = equipos.getIdEstadio();
            if (idEstadio != null) {
                idEstadio = em.getReference(idEstadio.getClass(), idEstadio.getId());
                equipos.setIdEstadio(idEstadio);
            }
            Collection<Jugadores> attachedJugadoresCollection = new ArrayList<Jugadores>();
            for (Jugadores jugadoresCollectionJugadoresToAttach : equipos.getJugadoresCollection()) {
                jugadoresCollectionJugadoresToAttach = em.getReference(jugadoresCollectionJugadoresToAttach.getClass(), jugadoresCollectionJugadoresToAttach.getId());
                attachedJugadoresCollection.add(jugadoresCollectionJugadoresToAttach);
            }
            equipos.setJugadoresCollection(attachedJugadoresCollection);
            Collection<Partidos> attachedPartidosCollection = new ArrayList<Partidos>();
            for (Partidos partidosCollectionPartidosToAttach : equipos.getPartidosCollection()) {
                partidosCollectionPartidosToAttach = em.getReference(partidosCollectionPartidosToAttach.getClass(), partidosCollectionPartidosToAttach.getId());
                attachedPartidosCollection.add(partidosCollectionPartidosToAttach);
            }
            equipos.setPartidosCollection(attachedPartidosCollection);
            Collection<Partidos> attachedPartidosCollection1 = new ArrayList<Partidos>();
            for (Partidos partidosCollection1PartidosToAttach : equipos.getPartidosCollection1()) {
                partidosCollection1PartidosToAttach = em.getReference(partidosCollection1PartidosToAttach.getClass(), partidosCollection1PartidosToAttach.getId());
                attachedPartidosCollection1.add(partidosCollection1PartidosToAttach);
            }
            equipos.setPartidosCollection1(attachedPartidosCollection1);
            em.persist(equipos);
            if (idEstadio != null) {
                idEstadio.getEquiposCollection().add(equipos);
                idEstadio = em.merge(idEstadio);
            }
            for (Jugadores jugadoresCollectionJugadores : equipos.getJugadoresCollection()) {
                Equipos oldIdEquipoOfJugadoresCollectionJugadores = jugadoresCollectionJugadores.getIdEquipo();
                jugadoresCollectionJugadores.setIdEquipo(equipos);
                jugadoresCollectionJugadores = em.merge(jugadoresCollectionJugadores);
                if (oldIdEquipoOfJugadoresCollectionJugadores != null) {
                    oldIdEquipoOfJugadoresCollectionJugadores.getJugadoresCollection().remove(jugadoresCollectionJugadores);
                    oldIdEquipoOfJugadoresCollectionJugadores = em.merge(oldIdEquipoOfJugadoresCollectionJugadores);
                }
            }
            for (Partidos partidosCollectionPartidos : equipos.getPartidosCollection()) {
                Equipos oldIdEquipoLocalOfPartidosCollectionPartidos = partidosCollectionPartidos.getIdEquipoLocal();
                partidosCollectionPartidos.setIdEquipoLocal(equipos);
                partidosCollectionPartidos = em.merge(partidosCollectionPartidos);
                if (oldIdEquipoLocalOfPartidosCollectionPartidos != null) {
                    oldIdEquipoLocalOfPartidosCollectionPartidos.getPartidosCollection().remove(partidosCollectionPartidos);
                    oldIdEquipoLocalOfPartidosCollectionPartidos = em.merge(oldIdEquipoLocalOfPartidosCollectionPartidos);
                }
            }
            for (Partidos partidosCollection1Partidos : equipos.getPartidosCollection1()) {
                Equipos oldIdEquipoVisitanteOfPartidosCollection1Partidos = partidosCollection1Partidos.getIdEquipoVisitante();
                partidosCollection1Partidos.setIdEquipoVisitante(equipos);
                partidosCollection1Partidos = em.merge(partidosCollection1Partidos);
                if (oldIdEquipoVisitanteOfPartidosCollection1Partidos != null) {
                    oldIdEquipoVisitanteOfPartidosCollection1Partidos.getPartidosCollection1().remove(partidosCollection1Partidos);
                    oldIdEquipoVisitanteOfPartidosCollection1Partidos = em.merge(oldIdEquipoVisitanteOfPartidosCollection1Partidos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipos equipos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipos persistentEquipos = em.find(Equipos.class, equipos.getId());
            Estadios idEstadioOld = persistentEquipos.getIdEstadio();
            Estadios idEstadioNew = equipos.getIdEstadio();
            Collection<Jugadores> jugadoresCollectionOld = persistentEquipos.getJugadoresCollection();
            Collection<Jugadores> jugadoresCollectionNew = equipos.getJugadoresCollection();
            Collection<Partidos> partidosCollectionOld = persistentEquipos.getPartidosCollection();
            Collection<Partidos> partidosCollectionNew = equipos.getPartidosCollection();
            Collection<Partidos> partidosCollection1Old = persistentEquipos.getPartidosCollection1();
            Collection<Partidos> partidosCollection1New = equipos.getPartidosCollection1();
            if (idEstadioNew != null) {
                idEstadioNew = em.getReference(idEstadioNew.getClass(), idEstadioNew.getId());
                equipos.setIdEstadio(idEstadioNew);
            }
            Collection<Jugadores> attachedJugadoresCollectionNew = new ArrayList<Jugadores>();
            for (Jugadores jugadoresCollectionNewJugadoresToAttach : jugadoresCollectionNew) {
                jugadoresCollectionNewJugadoresToAttach = em.getReference(jugadoresCollectionNewJugadoresToAttach.getClass(), jugadoresCollectionNewJugadoresToAttach.getId());
                attachedJugadoresCollectionNew.add(jugadoresCollectionNewJugadoresToAttach);
            }
            jugadoresCollectionNew = attachedJugadoresCollectionNew;
            equipos.setJugadoresCollection(jugadoresCollectionNew);
            Collection<Partidos> attachedPartidosCollectionNew = new ArrayList<Partidos>();
            for (Partidos partidosCollectionNewPartidosToAttach : partidosCollectionNew) {
                partidosCollectionNewPartidosToAttach = em.getReference(partidosCollectionNewPartidosToAttach.getClass(), partidosCollectionNewPartidosToAttach.getId());
                attachedPartidosCollectionNew.add(partidosCollectionNewPartidosToAttach);
            }
            partidosCollectionNew = attachedPartidosCollectionNew;
            equipos.setPartidosCollection(partidosCollectionNew);
            Collection<Partidos> attachedPartidosCollection1New = new ArrayList<Partidos>();
            for (Partidos partidosCollection1NewPartidosToAttach : partidosCollection1New) {
                partidosCollection1NewPartidosToAttach = em.getReference(partidosCollection1NewPartidosToAttach.getClass(), partidosCollection1NewPartidosToAttach.getId());
                attachedPartidosCollection1New.add(partidosCollection1NewPartidosToAttach);
            }
            partidosCollection1New = attachedPartidosCollection1New;
            equipos.setPartidosCollection1(partidosCollection1New);
            equipos = em.merge(equipos);
            if (idEstadioOld != null && !idEstadioOld.equals(idEstadioNew)) {
                idEstadioOld.getEquiposCollection().remove(equipos);
                idEstadioOld = em.merge(idEstadioOld);
            }
            if (idEstadioNew != null && !idEstadioNew.equals(idEstadioOld)) {
                idEstadioNew.getEquiposCollection().add(equipos);
                idEstadioNew = em.merge(idEstadioNew);
            }
            for (Jugadores jugadoresCollectionOldJugadores : jugadoresCollectionOld) {
                if (!jugadoresCollectionNew.contains(jugadoresCollectionOldJugadores)) {
                    jugadoresCollectionOldJugadores.setIdEquipo(null);
                    jugadoresCollectionOldJugadores = em.merge(jugadoresCollectionOldJugadores);
                }
            }
            for (Jugadores jugadoresCollectionNewJugadores : jugadoresCollectionNew) {
                if (!jugadoresCollectionOld.contains(jugadoresCollectionNewJugadores)) {
                    Equipos oldIdEquipoOfJugadoresCollectionNewJugadores = jugadoresCollectionNewJugadores.getIdEquipo();
                    jugadoresCollectionNewJugadores.setIdEquipo(equipos);
                    jugadoresCollectionNewJugadores = em.merge(jugadoresCollectionNewJugadores);
                    if (oldIdEquipoOfJugadoresCollectionNewJugadores != null && !oldIdEquipoOfJugadoresCollectionNewJugadores.equals(equipos)) {
                        oldIdEquipoOfJugadoresCollectionNewJugadores.getJugadoresCollection().remove(jugadoresCollectionNewJugadores);
                        oldIdEquipoOfJugadoresCollectionNewJugadores = em.merge(oldIdEquipoOfJugadoresCollectionNewJugadores);
                    }
                }
            }
            for (Partidos partidosCollectionOldPartidos : partidosCollectionOld) {
                if (!partidosCollectionNew.contains(partidosCollectionOldPartidos)) {
                    partidosCollectionOldPartidos.setIdEquipoLocal(null);
                    partidosCollectionOldPartidos = em.merge(partidosCollectionOldPartidos);
                }
            }
            for (Partidos partidosCollectionNewPartidos : partidosCollectionNew) {
                if (!partidosCollectionOld.contains(partidosCollectionNewPartidos)) {
                    Equipos oldIdEquipoLocalOfPartidosCollectionNewPartidos = partidosCollectionNewPartidos.getIdEquipoLocal();
                    partidosCollectionNewPartidos.setIdEquipoLocal(equipos);
                    partidosCollectionNewPartidos = em.merge(partidosCollectionNewPartidos);
                    if (oldIdEquipoLocalOfPartidosCollectionNewPartidos != null && !oldIdEquipoLocalOfPartidosCollectionNewPartidos.equals(equipos)) {
                        oldIdEquipoLocalOfPartidosCollectionNewPartidos.getPartidosCollection().remove(partidosCollectionNewPartidos);
                        oldIdEquipoLocalOfPartidosCollectionNewPartidos = em.merge(oldIdEquipoLocalOfPartidosCollectionNewPartidos);
                    }
                }
            }
            for (Partidos partidosCollection1OldPartidos : partidosCollection1Old) {
                if (!partidosCollection1New.contains(partidosCollection1OldPartidos)) {
                    partidosCollection1OldPartidos.setIdEquipoVisitante(null);
                    partidosCollection1OldPartidos = em.merge(partidosCollection1OldPartidos);
                }
            }
            for (Partidos partidosCollection1NewPartidos : partidosCollection1New) {
                if (!partidosCollection1Old.contains(partidosCollection1NewPartidos)) {
                    Equipos oldIdEquipoVisitanteOfPartidosCollection1NewPartidos = partidosCollection1NewPartidos.getIdEquipoVisitante();
                    partidosCollection1NewPartidos.setIdEquipoVisitante(equipos);
                    partidosCollection1NewPartidos = em.merge(partidosCollection1NewPartidos);
                    if (oldIdEquipoVisitanteOfPartidosCollection1NewPartidos != null && !oldIdEquipoVisitanteOfPartidosCollection1NewPartidos.equals(equipos)) {
                        oldIdEquipoVisitanteOfPartidosCollection1NewPartidos.getPartidosCollection1().remove(partidosCollection1NewPartidos);
                        oldIdEquipoVisitanteOfPartidosCollection1NewPartidos = em.merge(oldIdEquipoVisitanteOfPartidosCollection1NewPartidos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = equipos.getId();
                if (findEquipos(id) == null) {
                    throw new NonexistentEntityException("The equipos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipos equipos;
            try {
                equipos = em.getReference(Equipos.class, id);
                equipos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipos with id " + id + " no longer exists.", enfe);
            }
            Estadios idEstadio = equipos.getIdEstadio();
            if (idEstadio != null) {
                idEstadio.getEquiposCollection().remove(equipos);
                idEstadio = em.merge(idEstadio);
            }
            Collection<Jugadores> jugadoresCollection = equipos.getJugadoresCollection();
            for (Jugadores jugadoresCollectionJugadores : jugadoresCollection) {
                jugadoresCollectionJugadores.setIdEquipo(null);
                jugadoresCollectionJugadores = em.merge(jugadoresCollectionJugadores);
            }
            Collection<Partidos> partidosCollection = equipos.getPartidosCollection();
            for (Partidos partidosCollectionPartidos : partidosCollection) {
                partidosCollectionPartidos.setIdEquipoLocal(null);
                partidosCollectionPartidos = em.merge(partidosCollectionPartidos);
            }
            Collection<Partidos> partidosCollection1 = equipos.getPartidosCollection1();
            for (Partidos partidosCollection1Partidos : partidosCollection1) {
                partidosCollection1Partidos.setIdEquipoVisitante(null);
                partidosCollection1Partidos = em.merge(partidosCollection1Partidos);
            }
            em.remove(equipos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipos> findEquiposEntities() {
        return findEquiposEntities(true, -1, -1);
    }

    public List<Equipos> findEquiposEntities(int maxResults, int firstResult) {
        return findEquiposEntities(false, maxResults, firstResult);
    }

    private List<Equipos> findEquiposEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Equipos findEquipos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquiposCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipos> rt = cq.from(Equipos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
