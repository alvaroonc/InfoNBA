/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Álvaro
 */
public class EstadiosJpaController implements Serializable {

    public EstadiosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estadios estadios) {
        if (estadios.getEquiposCollection() == null) {
            estadios.setEquiposCollection(new ArrayList<Equipos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Equipos> attachedEquiposCollection = new ArrayList<Equipos>();
            for (Equipos equiposCollectionEquiposToAttach : estadios.getEquiposCollection()) {
                equiposCollectionEquiposToAttach = em.getReference(equiposCollectionEquiposToAttach.getClass(), equiposCollectionEquiposToAttach.getId());
                attachedEquiposCollection.add(equiposCollectionEquiposToAttach);
            }
            estadios.setEquiposCollection(attachedEquiposCollection);
            em.persist(estadios);
            for (Equipos equiposCollectionEquipos : estadios.getEquiposCollection()) {
                Estadios oldIdEstadioOfEquiposCollectionEquipos = equiposCollectionEquipos.getIdEstadio();
                equiposCollectionEquipos.setIdEstadio(estadios);
                equiposCollectionEquipos = em.merge(equiposCollectionEquipos);
                if (oldIdEstadioOfEquiposCollectionEquipos != null) {
                    oldIdEstadioOfEquiposCollectionEquipos.getEquiposCollection().remove(equiposCollectionEquipos);
                    oldIdEstadioOfEquiposCollectionEquipos = em.merge(oldIdEstadioOfEquiposCollectionEquipos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estadios estadios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadios persistentEstadios = em.find(Estadios.class, estadios.getId());
            Collection<Equipos> equiposCollectionOld = persistentEstadios.getEquiposCollection();
            Collection<Equipos> equiposCollectionNew = estadios.getEquiposCollection();
            Collection<Equipos> attachedEquiposCollectionNew = new ArrayList<Equipos>();
            for (Equipos equiposCollectionNewEquiposToAttach : equiposCollectionNew) {
                equiposCollectionNewEquiposToAttach = em.getReference(equiposCollectionNewEquiposToAttach.getClass(), equiposCollectionNewEquiposToAttach.getId());
                attachedEquiposCollectionNew.add(equiposCollectionNewEquiposToAttach);
            }
            equiposCollectionNew = attachedEquiposCollectionNew;
            estadios.setEquiposCollection(equiposCollectionNew);
            estadios = em.merge(estadios);
            for (Equipos equiposCollectionOldEquipos : equiposCollectionOld) {
                if (!equiposCollectionNew.contains(equiposCollectionOldEquipos)) {
                    equiposCollectionOldEquipos.setIdEstadio(null);
                    equiposCollectionOldEquipos = em.merge(equiposCollectionOldEquipos);
                }
            }
            for (Equipos equiposCollectionNewEquipos : equiposCollectionNew) {
                if (!equiposCollectionOld.contains(equiposCollectionNewEquipos)) {
                    Estadios oldIdEstadioOfEquiposCollectionNewEquipos = equiposCollectionNewEquipos.getIdEstadio();
                    equiposCollectionNewEquipos.setIdEstadio(estadios);
                    equiposCollectionNewEquipos = em.merge(equiposCollectionNewEquipos);
                    if (oldIdEstadioOfEquiposCollectionNewEquipos != null && !oldIdEstadioOfEquiposCollectionNewEquipos.equals(estadios)) {
                        oldIdEstadioOfEquiposCollectionNewEquipos.getEquiposCollection().remove(equiposCollectionNewEquipos);
                        oldIdEstadioOfEquiposCollectionNewEquipos = em.merge(oldIdEstadioOfEquiposCollectionNewEquipos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estadios.getId();
                if (findEstadios(id) == null) {
                    throw new NonexistentEntityException("The estadios with id " + id + " no longer exists.");
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
            Estadios estadios;
            try {
                estadios = em.getReference(Estadios.class, id);
                estadios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadios with id " + id + " no longer exists.", enfe);
            }
            Collection<Equipos> equiposCollection = estadios.getEquiposCollection();
            for (Equipos equiposCollectionEquipos : equiposCollection) {
                equiposCollectionEquipos.setIdEstadio(null);
                equiposCollectionEquipos = em.merge(equiposCollectionEquipos);
            }
            em.remove(estadios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estadios> findEstadiosEntities() {
        return findEstadiosEntities(true, -1, -1);
    }

    public List<Estadios> findEstadiosEntities(int maxResults, int firstResult) {
        return findEstadiosEntities(false, maxResults, firstResult);
    }

    private List<Estadios> findEstadiosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estadios.class));
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

    public Estadios findEstadios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estadios.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadiosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estadios> rt = cq.from(Estadios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
