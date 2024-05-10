/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdinfonba;

import bdinfonba.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 *
 * @author Álvaro
 */
public class JugadoresJpaController implements Serializable {

    public JugadoresJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Jugadores jugadores) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipos idEquipo = jugadores.getIdEquipo();
            if (idEquipo != null) {
                idEquipo = em.getReference(idEquipo.getClass(), idEquipo.getId());
                jugadores.setIdEquipo(idEquipo);
            }
            em.persist(jugadores);
            if (idEquipo != null) {
                idEquipo.getJugadoresCollection().add(jugadores);
                idEquipo = em.merge(idEquipo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Jugadores jugadores) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Jugadores persistentJugadores = em.find(Jugadores.class, jugadores.getId());
            Equipos idEquipoOld = persistentJugadores.getIdEquipo();
            Equipos idEquipoNew = jugadores.getIdEquipo();
            if (idEquipoNew != null) {
                idEquipoNew = em.getReference(idEquipoNew.getClass(), idEquipoNew.getId());
                jugadores.setIdEquipo(idEquipoNew);
            }
            jugadores = em.merge(jugadores);
            if (idEquipoOld != null && !idEquipoOld.equals(idEquipoNew)) {
                idEquipoOld.getJugadoresCollection().remove(jugadores);
                idEquipoOld = em.merge(idEquipoOld);
            }
            if (idEquipoNew != null && !idEquipoNew.equals(idEquipoOld)) {
                idEquipoNew.getJugadoresCollection().add(jugadores);
                idEquipoNew = em.merge(idEquipoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = jugadores.getId();
                if (findJugadores(id) == null) {
                    throw new NonexistentEntityException("The jugadores with id " + id + " no longer exists.");
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
            Jugadores jugadores;
            try {
                jugadores = em.getReference(Jugadores.class, id);
                jugadores.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The jugadores with id " + id + " no longer exists.", enfe);
            }
            Equipos idEquipo = jugadores.getIdEquipo();
            if (idEquipo != null) {
                idEquipo.getJugadoresCollection().remove(jugadores);
                idEquipo = em.merge(idEquipo);
            }
            em.remove(jugadores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Jugadores> findJugadoresEntities() {
        return findJugadoresEntities(true, -1, -1);
    }

    public List<Jugadores> findJugadoresEntities(int maxResults, int firstResult) {
        return findJugadoresEntities(false, maxResults, firstResult);
    }

    private List<Jugadores> findJugadoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Jugadores.class));
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

    public Jugadores findJugadores(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Jugadores.class, id);
        } finally {
            em.close();
        }
    }

    public int getJugadoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Jugadores> rt = cq.from(Jugadores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
