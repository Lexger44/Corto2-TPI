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
import java.util.HashSet;
import java.util.Set;
import com.mycompany.entity.Multa;
import com.mycompany.entity.Historico;
import com.mycompany.entity.Reserva;
import com.mycompany.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cmargueiz
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getEjemplarSet() == null) {
            usuario.setEjemplarSet(new HashSet<Ejemplar>());
        }
        if (usuario.getMultaSet() == null) {
            usuario.setMultaSet(new HashSet<Multa>());
        }
        if (usuario.getHistoricoSet() == null) {
            usuario.setHistoricoSet(new HashSet<Historico>());
        }
        if (usuario.getReservaSet() == null) {
            usuario.setReservaSet(new HashSet<Reserva>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<Ejemplar> attachedEjemplarSet = new HashSet<Ejemplar>();
            for (Ejemplar ejemplarSetEjemplarToAttach : usuario.getEjemplarSet()) {
                ejemplarSetEjemplarToAttach = em.getReference(ejemplarSetEjemplarToAttach.getClass(), ejemplarSetEjemplarToAttach.getId());
                attachedEjemplarSet.add(ejemplarSetEjemplarToAttach);
            }
            usuario.setEjemplarSet(attachedEjemplarSet);
            Set<Multa> attachedMultaSet = new HashSet<Multa>();
            for (Multa multaSetMultaToAttach : usuario.getMultaSet()) {
                multaSetMultaToAttach = em.getReference(multaSetMultaToAttach.getClass(), multaSetMultaToAttach.getId());
                attachedMultaSet.add(multaSetMultaToAttach);
            }
            usuario.setMultaSet(attachedMultaSet);
            Set<Historico> attachedHistoricoSet = new HashSet<Historico>();
            for (Historico historicoSetHistoricoToAttach : usuario.getHistoricoSet()) {
                historicoSetHistoricoToAttach = em.getReference(historicoSetHistoricoToAttach.getClass(), historicoSetHistoricoToAttach.getId());
                attachedHistoricoSet.add(historicoSetHistoricoToAttach);
            }
            usuario.setHistoricoSet(attachedHistoricoSet);
            Set<Reserva> attachedReservaSet = new HashSet<Reserva>();
            for (Reserva reservaSetReservaToAttach : usuario.getReservaSet()) {
                reservaSetReservaToAttach = em.getReference(reservaSetReservaToAttach.getClass(), reservaSetReservaToAttach.getId());
                attachedReservaSet.add(reservaSetReservaToAttach);
            }
            usuario.setReservaSet(attachedReservaSet);
            em.persist(usuario);
            for (Ejemplar ejemplarSetEjemplar : usuario.getEjemplarSet()) {
                Usuario oldUsuarioIdOfEjemplarSetEjemplar = ejemplarSetEjemplar.getUsuarioId();
                ejemplarSetEjemplar.setUsuarioId(usuario);
                ejemplarSetEjemplar = em.merge(ejemplarSetEjemplar);
                if (oldUsuarioIdOfEjemplarSetEjemplar != null) {
                    oldUsuarioIdOfEjemplarSetEjemplar.getEjemplarSet().remove(ejemplarSetEjemplar);
                    oldUsuarioIdOfEjemplarSetEjemplar = em.merge(oldUsuarioIdOfEjemplarSetEjemplar);
                }
            }
            for (Multa multaSetMulta : usuario.getMultaSet()) {
                Usuario oldUsuarioIdOfMultaSetMulta = multaSetMulta.getUsuarioId();
                multaSetMulta.setUsuarioId(usuario);
                multaSetMulta = em.merge(multaSetMulta);
                if (oldUsuarioIdOfMultaSetMulta != null) {
                    oldUsuarioIdOfMultaSetMulta.getMultaSet().remove(multaSetMulta);
                    oldUsuarioIdOfMultaSetMulta = em.merge(oldUsuarioIdOfMultaSetMulta);
                }
            }
            for (Historico historicoSetHistorico : usuario.getHistoricoSet()) {
                Usuario oldUsuarioIdOfHistoricoSetHistorico = historicoSetHistorico.getUsuarioId();
                historicoSetHistorico.setUsuarioId(usuario);
                historicoSetHistorico = em.merge(historicoSetHistorico);
                if (oldUsuarioIdOfHistoricoSetHistorico != null) {
                    oldUsuarioIdOfHistoricoSetHistorico.getHistoricoSet().remove(historicoSetHistorico);
                    oldUsuarioIdOfHistoricoSetHistorico = em.merge(oldUsuarioIdOfHistoricoSetHistorico);
                }
            }
            for (Reserva reservaSetReserva : usuario.getReservaSet()) {
                Usuario oldUsuarioIdOfReservaSetReserva = reservaSetReserva.getUsuarioId();
                reservaSetReserva.setUsuarioId(usuario);
                reservaSetReserva = em.merge(reservaSetReserva);
                if (oldUsuarioIdOfReservaSetReserva != null) {
                    oldUsuarioIdOfReservaSetReserva.getReservaSet().remove(reservaSetReserva);
                    oldUsuarioIdOfReservaSetReserva = em.merge(oldUsuarioIdOfReservaSetReserva);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Set<Ejemplar> ejemplarSetOld = persistentUsuario.getEjemplarSet();
            Set<Ejemplar> ejemplarSetNew = usuario.getEjemplarSet();
            Set<Multa> multaSetOld = persistentUsuario.getMultaSet();
            Set<Multa> multaSetNew = usuario.getMultaSet();
            Set<Historico> historicoSetOld = persistentUsuario.getHistoricoSet();
            Set<Historico> historicoSetNew = usuario.getHistoricoSet();
            Set<Reserva> reservaSetOld = persistentUsuario.getReservaSet();
            Set<Reserva> reservaSetNew = usuario.getReservaSet();
            List<String> illegalOrphanMessages = null;
            for (Multa multaSetOldMulta : multaSetOld) {
                if (!multaSetNew.contains(multaSetOldMulta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Multa " + multaSetOldMulta + " since its usuarioId field is not nullable.");
                }
            }
            for (Historico historicoSetOldHistorico : historicoSetOld) {
                if (!historicoSetNew.contains(historicoSetOldHistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historico " + historicoSetOldHistorico + " since its usuarioId field is not nullable.");
                }
            }
            for (Reserva reservaSetOldReserva : reservaSetOld) {
                if (!reservaSetNew.contains(reservaSetOldReserva)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Reserva " + reservaSetOldReserva + " since its usuarioId field is not nullable.");
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
            usuario.setEjemplarSet(ejemplarSetNew);
            Set<Multa> attachedMultaSetNew = new HashSet<Multa>();
            for (Multa multaSetNewMultaToAttach : multaSetNew) {
                multaSetNewMultaToAttach = em.getReference(multaSetNewMultaToAttach.getClass(), multaSetNewMultaToAttach.getId());
                attachedMultaSetNew.add(multaSetNewMultaToAttach);
            }
            multaSetNew = attachedMultaSetNew;
            usuario.setMultaSet(multaSetNew);
            Set<Historico> attachedHistoricoSetNew = new HashSet<Historico>();
            for (Historico historicoSetNewHistoricoToAttach : historicoSetNew) {
                historicoSetNewHistoricoToAttach = em.getReference(historicoSetNewHistoricoToAttach.getClass(), historicoSetNewHistoricoToAttach.getId());
                attachedHistoricoSetNew.add(historicoSetNewHistoricoToAttach);
            }
            historicoSetNew = attachedHistoricoSetNew;
            usuario.setHistoricoSet(historicoSetNew);
            Set<Reserva> attachedReservaSetNew = new HashSet<Reserva>();
            for (Reserva reservaSetNewReservaToAttach : reservaSetNew) {
                reservaSetNewReservaToAttach = em.getReference(reservaSetNewReservaToAttach.getClass(), reservaSetNewReservaToAttach.getId());
                attachedReservaSetNew.add(reservaSetNewReservaToAttach);
            }
            reservaSetNew = attachedReservaSetNew;
            usuario.setReservaSet(reservaSetNew);
            usuario = em.merge(usuario);
            for (Ejemplar ejemplarSetOldEjemplar : ejemplarSetOld) {
                if (!ejemplarSetNew.contains(ejemplarSetOldEjemplar)) {
                    ejemplarSetOldEjemplar.setUsuarioId(null);
                    ejemplarSetOldEjemplar = em.merge(ejemplarSetOldEjemplar);
                }
            }
            for (Ejemplar ejemplarSetNewEjemplar : ejemplarSetNew) {
                if (!ejemplarSetOld.contains(ejemplarSetNewEjemplar)) {
                    Usuario oldUsuarioIdOfEjemplarSetNewEjemplar = ejemplarSetNewEjemplar.getUsuarioId();
                    ejemplarSetNewEjemplar.setUsuarioId(usuario);
                    ejemplarSetNewEjemplar = em.merge(ejemplarSetNewEjemplar);
                    if (oldUsuarioIdOfEjemplarSetNewEjemplar != null && !oldUsuarioIdOfEjemplarSetNewEjemplar.equals(usuario)) {
                        oldUsuarioIdOfEjemplarSetNewEjemplar.getEjemplarSet().remove(ejemplarSetNewEjemplar);
                        oldUsuarioIdOfEjemplarSetNewEjemplar = em.merge(oldUsuarioIdOfEjemplarSetNewEjemplar);
                    }
                }
            }
            for (Multa multaSetNewMulta : multaSetNew) {
                if (!multaSetOld.contains(multaSetNewMulta)) {
                    Usuario oldUsuarioIdOfMultaSetNewMulta = multaSetNewMulta.getUsuarioId();
                    multaSetNewMulta.setUsuarioId(usuario);
                    multaSetNewMulta = em.merge(multaSetNewMulta);
                    if (oldUsuarioIdOfMultaSetNewMulta != null && !oldUsuarioIdOfMultaSetNewMulta.equals(usuario)) {
                        oldUsuarioIdOfMultaSetNewMulta.getMultaSet().remove(multaSetNewMulta);
                        oldUsuarioIdOfMultaSetNewMulta = em.merge(oldUsuarioIdOfMultaSetNewMulta);
                    }
                }
            }
            for (Historico historicoSetNewHistorico : historicoSetNew) {
                if (!historicoSetOld.contains(historicoSetNewHistorico)) {
                    Usuario oldUsuarioIdOfHistoricoSetNewHistorico = historicoSetNewHistorico.getUsuarioId();
                    historicoSetNewHistorico.setUsuarioId(usuario);
                    historicoSetNewHistorico = em.merge(historicoSetNewHistorico);
                    if (oldUsuarioIdOfHistoricoSetNewHistorico != null && !oldUsuarioIdOfHistoricoSetNewHistorico.equals(usuario)) {
                        oldUsuarioIdOfHistoricoSetNewHistorico.getHistoricoSet().remove(historicoSetNewHistorico);
                        oldUsuarioIdOfHistoricoSetNewHistorico = em.merge(oldUsuarioIdOfHistoricoSetNewHistorico);
                    }
                }
            }
            for (Reserva reservaSetNewReserva : reservaSetNew) {
                if (!reservaSetOld.contains(reservaSetNewReserva)) {
                    Usuario oldUsuarioIdOfReservaSetNewReserva = reservaSetNewReserva.getUsuarioId();
                    reservaSetNewReserva.setUsuarioId(usuario);
                    reservaSetNewReserva = em.merge(reservaSetNewReserva);
                    if (oldUsuarioIdOfReservaSetNewReserva != null && !oldUsuarioIdOfReservaSetNewReserva.equals(usuario)) {
                        oldUsuarioIdOfReservaSetNewReserva.getReservaSet().remove(reservaSetNewReserva);
                        oldUsuarioIdOfReservaSetNewReserva = em.merge(oldUsuarioIdOfReservaSetNewReserva);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<Multa> multaSetOrphanCheck = usuario.getMultaSet();
            for (Multa multaSetOrphanCheckMulta : multaSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Multa " + multaSetOrphanCheckMulta + " in its multaSet field has a non-nullable usuarioId field.");
            }
            Set<Historico> historicoSetOrphanCheck = usuario.getHistoricoSet();
            for (Historico historicoSetOrphanCheckHistorico : historicoSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Historico " + historicoSetOrphanCheckHistorico + " in its historicoSet field has a non-nullable usuarioId field.");
            }
            Set<Reserva> reservaSetOrphanCheck = usuario.getReservaSet();
            for (Reserva reservaSetOrphanCheckReserva : reservaSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Reserva " + reservaSetOrphanCheckReserva + " in its reservaSet field has a non-nullable usuarioId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Set<Ejemplar> ejemplarSet = usuario.getEjemplarSet();
            for (Ejemplar ejemplarSetEjemplar : ejemplarSet) {
                ejemplarSetEjemplar.setUsuarioId(null);
                ejemplarSetEjemplar = em.merge(ejemplarSetEjemplar);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
