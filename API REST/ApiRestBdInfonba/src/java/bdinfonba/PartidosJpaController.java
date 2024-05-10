/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdinfonba;

import apirest.exceptions.NonexistentEntityException;
import bdinfonba.Partidos;
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
public class PartidosJpaController implements Serializable {

    public PartidosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Partidos partidos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(partidos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Partidos partidos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            partidos = em.merge(partidos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = partidos.getId();
                if (findPartidos(id) == null) {
                    throw new NonexistentEntityException("The partidos with id " + id + " no longer exists.");
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
            Partidos partidos;
            try {
                partidos = em.getReference(Partidos.class, id);
                partidos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The partidos with id " + id + " no longer exists.", enfe);
            }
            em.remove(partidos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Partidos> findPartidosEntities() {
        return findPartidosEntities(true, -1, -1);
    }

    public List<Partidos> findPartidosEntities(int maxResults, int firstResult) {
        return findPartidosEntities(false, maxResults, firstResult);
    }

    private List<Partidos> findPartidosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Partidos.class));
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

    public Partidos findPartidos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Partidos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartidosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Partidos> rt = cq.from(Partidos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
