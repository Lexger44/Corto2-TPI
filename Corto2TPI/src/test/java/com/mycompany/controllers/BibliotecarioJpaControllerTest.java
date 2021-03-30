/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.entity.Bibliotecario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author carlo
 */
@ExtendWith(MockitoExtension.class)
public class BibliotecarioJpaControllerTest {
    
    static EntityManagerFactory mockEmf;
    static BibliotecarioJpaController registro;
    static Bibliotecario bibliotecarioObject;
    
    public BibliotecarioJpaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {        
        mockEmf = Mockito.mock(EntityManagerFactory.class);        
        registro = new BibliotecarioJpaController(mockEmf);
        bibliotecarioObject = new Bibliotecario(1L);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
        
    /**
     * Test of getEntityManager method, of class BibliotecarioJpaController.
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
     * Test of create method, of class BibliotecarioJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");    
        EntityManager mockEm = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTx);        
        this.registro.create(bibliotecarioObject);
        Mockito.verify(mockEm).persist(this.bibliotecarioObject);        
        Mockito.verify(mockEm).close();        
    }

    /**
     * Test of edit method, of class BibliotecarioJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        EntityManager mockEm = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTx); 
                
        Mockito.when(mockEm.merge(bibliotecarioObject)).thenReturn(bibliotecarioObject);        
        registro.edit(bibliotecarioObject);
        Mockito.verify(mockEm).merge(bibliotecarioObject);
        
        
    }

    /**
     * Test of destroy method, of class BibliotecarioJpaController.
     */
    
    
}
