/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.controladores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.controlador.exceptions.NonexistentEntityException;
import net.modelo.HistorialCliente;

/**
 *
 * @author user
 */
public class HistorialClienteJpaController implements Serializable {

    public HistorialClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(HistorialCliente historialCliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historialCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(HistorialCliente historialCliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historialCliente = em.merge(historialCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historialCliente.getIdHistorialCliente();
                if (findHistorialCliente(id) == null) {
                    throw new NonexistentEntityException("The historialCliente with id " + id + " no longer exists.");
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
            HistorialCliente historialCliente;
            try {
                historialCliente = em.getReference(HistorialCliente.class, id);
                historialCliente.getIdHistorialCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historialCliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(historialCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<HistorialCliente> findHistorialClienteEntities() {
        return findHistorialClienteEntities(true, -1, -1);
    }

    public List<HistorialCliente> findHistorialClienteEntities(int maxResults, int firstResult) {
        return findHistorialClienteEntities(false, maxResults, firstResult);
    }

    private List<HistorialCliente> findHistorialClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(HistorialCliente.class));
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

    public HistorialCliente findHistorialCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(HistorialCliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistorialClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<HistorialCliente> rt = cq.from(HistorialCliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
