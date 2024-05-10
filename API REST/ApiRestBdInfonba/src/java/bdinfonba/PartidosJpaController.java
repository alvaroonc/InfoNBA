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
            Equipos idEquipoLocal = partidos.getIdEquipoLocal();
            if (idEquipoLocal != null) {
                idEquipoLocal = em.getReference(idEquipoLocal.getClass(), idEquipoLocal.getId());
                partidos.setIdEquipoLocal(idEquipoLocal);
            }
            Equipos idEquipoVisitante = partidos.getIdEquipoVisitante();
            if (idEquipoVisitante != null) {
                idEquipoVisitante = em.getReference(idEquipoVisitante.getClass(), idEquipoVisitante.getId());
                partidos.setIdEquipoVisitante(idEquipoVisitante);
            }
            em.persist(partidos);
            if (idEquipoLocal != null) {
                idEquipoLocal.getPartidosCollection().add(partidos);
                idEquipoLocal = em.merge(idEquipoLocal);
            }
            if (idEquipoVisitante != null) {
                idEquipoVisitante.getPartidosCollection().add(partidos);
                idEquipoVisitante = em.merge(idEquipoVisitante);
            }
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
            Partidos persistentPartidos = em.find(Partidos.class, partidos.getId());
            Equipos idEquipoLocalOld = persistentPartidos.getIdEquipoLocal();
            Equipos idEquipoLocalNew = partidos.getIdEquipoLocal();
            Equipos idEquipoVisitanteOld = persistentPartidos.getIdEquipoVisitante();
            Equipos idEquipoVisitanteNew = partidos.getIdEquipoVisitante();
            if (idEquipoLocalNew != null) {
                idEquipoLocalNew = em.getReference(idEquipoLocalNew.getClass(), idEquipoLocalNew.getId());
                partidos.setIdEquipoLocal(idEquipoLocalNew);
            }
            if (idEquipoVisitanteNew != null) {
                idEquipoVisitanteNew = em.getReference(idEquipoVisitanteNew.getClass(), idEquipoVisitanteNew.getId());
                partidos.setIdEquipoVisitante(idEquipoVisitanteNew);
            }
            partidos = em.merge(partidos);
            if (idEquipoLocalOld != null && !idEquipoLocalOld.equals(idEquipoLocalNew)) {
                idEquipoLocalOld.getPartidosCollection().remove(partidos);
                idEquipoLocalOld = em.merge(idEquipoLocalOld);
            }
            if (idEquipoLocalNew != null && !idEquipoLocalNew.equals(idEquipoLocalOld)) {
                idEquipoLocalNew.getPartidosCollection().add(partidos);
                idEquipoLocalNew = em.merge(idEquipoLocalNew);
            }
            if (idEquipoVisitanteOld != null && !idEquipoVisitanteOld.equals(idEquipoVisitanteNew)) {
                idEquipoVisitanteOld.getPartidosCollection().remove(partidos);
                idEquipoVisitanteOld = em.merge(idEquipoVisitanteOld);
            }
            if (idEquipoVisitanteNew != null && !idEquipoVisitanteNew.equals(idEquipoVisitanteOld)) {
                idEquipoVisitanteNew.getPartidosCollection().add(partidos);
                idEquipoVisitanteNew = em.merge(idEquipoVisitanteNew);
            }
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
            Equipos idEquipoLocal = partidos.getIdEquipoLocal();
            if (idEquipoLocal != null) {
                idEquipoLocal.getPartidosCollection().remove(partidos);
                idEquipoLocal = em.merge(idEquipoLocal);
            }
            Equipos idEquipoVisitante = partidos.getIdEquipoVisitante();
            if (idEquipoVisitante != null) {
                idEquipoVisitante.getPartidosCollection().remove(partidos);
                idEquipoVisitante = em.merge(idEquipoVisitante);
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
