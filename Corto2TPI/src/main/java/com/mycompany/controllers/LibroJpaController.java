/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.controllers.exceptions.IllegalOrphanException;
import com.mycompany.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.entity.Ejemplar;
import com.mycompany.entity.Libro;
import java.util.HashSet;
import java.util.Set;
import com.mycompany.entity.Reserva;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cmargueiz
 */
public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) {
        if (libro.getEjemplarSet() == null) {
            libro.setEjemplarSet(new HashSet<Ejemplar>());
        }
        if (libro.getReservaSet() == null) {
            libro.setReservaSet(new HashSet<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Ejemplar> attachedEjemplarSet = new HashSet<Ejemplar>();
            for (Ejemplar ejemplarSetEjemplarToAttach : libro.getEjemplarSet()) {
                ejemplarSetEjemplarToAttach = em.getReference(ejemplarSetEjemplarToAttach.getClass(), ejemplarSetEjemplarToAttach.getId());
                attachedEjemplarSet.add(ejemplarSetEjemplarToAttach);
            }
            libro.setEjemplarSet(attachedEjemplarSet);
            Set<Reserva> attachedReservaSet = new HashSet<Reserva>();
            for (Reserva reservaSetReservaToAttach : libro.getReservaSet()) {
                reservaSetReservaToAttach = em.getReference(reservaSetReservaToAttach.getClass(), reservaSetReservaToAttach.getId());
                attachedReservaSet.add(reservaSetReservaToAttach);
            }
            libro.setReservaSet(attachedReservaSet);
            em.persist(libro);
            for (Ejemplar ejemplarSetEjemplar : libro.getEjemplarSet()) {
                Libro oldLibroIdOfEjemplarSetEjemplar = ejemplarSetEjemplar.getLibroId();
                ejemplarSetEjemplar.setLibroId(libro);
                ejemplarSetEjemplar = em.merge(ejemplarSetEjemplar);
                if (oldLibroIdOfEjemplarSetEjemplar != null) {
                    oldLibroIdOfEjemplarSetEjemplar.getEjemplarSet().remove(ejemplarSetEjemplar);
                    oldLibroIdOfEjemplarSetEjemplar = em.merge(oldLibroIdOfEjemplarSetEjemplar);
                }
            }
            for (Reserva reservaSetReserva : libro.getReservaSet()) {
                Libro oldLibroIdOfReservaSetReserva = reservaSetReserva.getLibroId();
                reservaSetReserva.setLibroId(libro);
                reservaSetReserva = em.merge(reservaSetReserva);
                if (oldLibroIdOfReservaSetReserva != null) {
                    oldLibroIdOfReservaSetReserva.getReservaSet().remove(reservaSetReserva);
                    oldLibroIdOfReservaSetReserva = em.merge(oldLibroIdOfReservaSetReserva);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro persistentLibro = em.find(Libro.class, libro.getId());
            Set<Ejemplar> ejemplarSetOld = persistentLibro.getEjemplarSet();
            Set<Ejemplar> ejemplarSetNew = libro.getEjemplarSet();
            Set<Reserva> reservaSetOld = persistentLibro.getReservaSet();
            Set<Reserva> reservaSetNew = libro.getReservaSet();
            List<String> illegalOrphanMessages = null;
            for (Ejemplar ejemplarSetOldEjemplar : ejemplarSetOld) {
                if (!ejemplarSetNew.contains(ejemplarSetOldEjemplar)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ejemplar " + ejemplarSetOldEjemplar + " since its libroId field is not nullable.");
                }
            }
            for (Reserva reservaSetOldReserva : reservaSetOld) {
                if (!reservaSetNew.contains(reservaSetOldReserva)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reserva " + reservaSetOldReserva + " since its libroId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Set<Ejemplar> attachedEjemplarSetNew = new HashSet<Ejemplar>();
            for (Ejemplar ejemplarSetNewEjemplarToAttach : ejemplarSetNew) {
                ejemplarSetNewEjemplarToAttach = em.getReference(ejemplarSetNewEjemplarToAttach.getClass(), ejemplarSetNewEjemplarToAttach.getId());
                attachedEjemplarSetNew.add(ejemplarSetNewEjemplarToAttach);
            }
            ejemplarSetNew = attachedEjemplarSetNew;
            libro.setEjemplarSet(ejemplarSetNew);
            Set<Reserva> attachedReservaSetNew = new HashSet<Reserva>();
            for (Reserva reservaSetNewReservaToAttach : reservaSetNew) {
                reservaSetNewReservaToAttach = em.getReference(reservaSetNewReservaToAttach.getClass(), reservaSetNewReservaToAttach.getId());
                attachedReservaSetNew.add(reservaSetNewReservaToAttach);
            }
            reservaSetNew = attachedReservaSetNew;
            libro.setReservaSet(reservaSetNew);
            libro = em.merge(libro);
            for (Ejemplar ejemplarSetNewEjemplar : ejemplarSetNew) {
                if (!ejemplarSetOld.contains(ejemplarSetNewEjemplar)) {
                    Libro oldLibroIdOfEjemplarSetNewEjemplar = ejemplarSetNewEjemplar.getLibroId();
                    ejemplarSetNewEjemplar.setLibroId(libro);
                    ejemplarSetNewEjemplar = em.merge(ejemplarSetNewEjemplar);
                    if (oldLibroIdOfEjemplarSetNewEjemplar != null && !oldLibroIdOfEjemplarSetNewEjemplar.equals(libro)) {
                        oldLibroIdOfEjemplarSetNewEjemplar.getEjemplarSet().remove(ejemplarSetNewEjemplar);
                        oldLibroIdOfEjemplarSetNewEjemplar = em.merge(oldLibroIdOfEjemplarSetNewEjemplar);
                    }
                }
            }
            for (Reserva reservaSetNewReserva : reservaSetNew) {
                if (!reservaSetOld.contains(reservaSetNewReserva)) {
                    Libro oldLibroIdOfReservaSetNewReserva = reservaSetNewReserva.getLibroId();
                    reservaSetNewReserva.setLibroId(libro);
                    reservaSetNewReserva = em.merge(reservaSetNewReserva);
                    if (oldLibroIdOfReservaSetNewReserva != null && !oldLibroIdOfReservaSetNewReserva.equals(libro)) {
                        oldLibroIdOfReservaSetNewReserva.getReservaSet().remove(reservaSetNewReserva);
                        oldLibroIdOfReservaSetNewReserva = em.merge(oldLibroIdOfReservaSetNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = libro.getId();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<Ejemplar> ejemplarSetOrphanCheck = libro.getEjemplarSet();
            for (Ejemplar ejemplarSetOrphanCheckEjemplar : ejemplarSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Libro (" + libro + ") cannot be destroyed since the Ejemplar " + ejemplarSetOrphanCheckEjemplar + " in its ejemplarSet field has a non-nullable libroId field.");
            }
            Set<Reserva> reservaSetOrphanCheck = libro.getReservaSet();
            for (Reserva reservaSetOrphanCheckReserva : reservaSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Libro (" + libro + ") cannot be destroyed since the Reserva " + reservaSetOrphanCheckReserva + " in its reservaSet field has a non-nullable libroId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
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

    public Libro findLibro(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
