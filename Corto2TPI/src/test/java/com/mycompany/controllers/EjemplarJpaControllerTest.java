/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;




import com.mycompany.controllers.exceptions.IllegalOrphanException;
import com.mycompany.controllers.exceptions.NonexistentEntityException;
import com.mycompany.entity.Ejemplar;
import com.mycompany.entity.Usuario;
import java.util.List;
import java.util.Set;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.persistence.Query;

/**
 *
 * @author Chris Oliva
 */

@ExtendWith(MockitoExtension.class)
public class EjemplarJpaControllerTest {
     static EntityManagerFactory mockEmf;
    static EjemplarJpaController registro;
    static Ejemplar ejemplarObject;
    
    public EjemplarJpaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        mockEmf = Mockito.mock(EntityManagerFactory.class);
        registro = new EjemplarJpaController(mockEmf);
        ejemplarObject = new Ejemplar(1);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getEntityManager method, of class EjemplarJpaController.
     */
    @Test
    public void testGetEntityManager() {
       System.out.println("getEntityManager");
       EntityManager mockEm = Mockito.mock(EntityManager.class);
       Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
       EntityManager expResult = mockEm;
       EntityManager result = registro.getEntityManager();
       assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class EjemplarJpaController.
     */
    @Test
    public void testCreate() throws Exception{
        System.out.println("create");
        EntityManager mockEm = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTx);
        this.registro.create(ejemplarObject);
        Mockito.verify(mockEm).persist(this.ejemplarObject);
        Mockito.verify(mockEm).close();
           
    }

    /**
     * Test of edit method, of class EjemplarJpaController.
     */
    @Test
    public void testEdit() throws Exception, NonexistentEntityException {
        System.out.println("edit");
        EntityManager mockEm = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTx);

        Mockito.when(mockEm.merge(ejemplarObject)).thenReturn(ejemplarObject);
        registro.edit(ejemplarObject);
        Mockito.verify(mockEm).merge(ejemplarObject);
        Mockito.verify(mockEm).close();
        RuntimeErrorException mockRx = Mockito.mock(RuntimeErrorException.class);
        
        Mockito.when(mockEm.merge(ejemplarObject)).thenThrow(mockRx);
        Ejemplar mockB = Mockito.mock(Ejemplar.class);        
        try {
            registro.edit(ejemplarObject);
        } catch (Exception e) {
            System.out.println(e);
        }
               
//        Mockito.when(mockRx.getLocalizedMessage()).thenReturn("Excepcion esperada");

        try {
            registro.edit(ejemplarObject);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Test of destroy method, of class EjemplarJpaController.
     */
    @Test
    public void testDestroy() throws NonexistentEntityException, IllegalOrphanException {
        System.out.println("destroy");
        Ejemplar mockEjemplar = Mockito.mock(Ejemplar.class);
        int id = mockEjemplar.getId();
        mockEjemplar.setId(id);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        EjemplarJpaController instance = new EjemplarJpaController(mockEMF);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        Mockito.when(mockEM.getReference(Ejemplar.class, mockEjemplar.getId())).thenReturn(mockEjemplar);
             
        Usuario mockUsuario = Mockito.mock(Usuario.class);
        Mockito.when(mockEjemplar.getUsuarioId()).thenReturn(mockUsuario);
        Set<Ejemplar> mockEjemplarSet = Mockito.mock(Set.class);
        
        
        instance.destroy(id);
    }

    /**
     * Test of EjemplarEntities method, of class EjemplarJpaController.
     */
    @Test
    public void testEjemplarEntities() throws UnsupportedOperationException {
        System.out.println("findEjemplarEntities");
        Ejemplar mockEjemplar = Mockito.mock(Ejemplar.class);
      
       
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        EjemplarJpaController instance = new EjemplarJpaController(mockEMF);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
     
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        
        
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
       
        List<Ejemplar> mockList = Mockito.mock(List.class);
        Query mockQ = Mockito.mock(Query.class);
        
        
    }
    
}
