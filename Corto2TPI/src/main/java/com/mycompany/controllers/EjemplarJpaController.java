
package com.mycompany.controllers;

import com.mycompany.controllers.exceptions.IllegalOrphanException;
import com.mycompany.controllers.exceptions.NonexistentEntityException;
import com.mycompany.entity.Ejemplar;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.entity.Libro;
import com.mycompany.entity.Usuario;
import com.mycompany.entity.Historico;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cmargueiz
 */
public class EjemplarJpaController implements Serializable {

    public EjemplarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ejemplar ejemplar) {
        if (ejemplar.getHistoricoSet() == null) {
            ejemplar.setHistoricoSet(new HashSet<Historico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
          
            em.persist(ejemplar);
           
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ejemplar ejemplar) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            ejemplar = em.merge(ejemplar);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
           
        
        } 
                finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Ejemplar id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           
            em.remove(id.getId());
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    
    
}
