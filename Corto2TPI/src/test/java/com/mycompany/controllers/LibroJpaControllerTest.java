/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.entity.Ejemplar;
import com.mycompany.entity.Libro;
import com.mycompany.entity.Reserva;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import javax.persistence.EntityTransaction;

/**
 *
 * @author larok
 */
@ExtendWith(MockitoExtension.class)
public class LibroJpaControllerTest {

    public LibroJpaControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        Libro prueba = new Libro();
        Set<Ejemplar> ejemplar1 = new HashSet<Ejemplar>();
        prueba.setEjemplarSet(ejemplar1);
        Set<Reserva> reserva1 = new HashSet<Reserva>();
        prueba.setReservaSet(reserva1);
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getEntityManager method, of class LibroJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        LibroJpaController instance = new LibroJpaController(mockEMF);
        EntityManager expResult = Mockito.mock(EntityManager.class);
        Mockito.when(instance.getEntityManager()).thenReturn(expResult);
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);

    }

    /**
     * Test of create method, of class LibroJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        LibroJpaController libro = new LibroJpaController(mockEMF);
        libro.emf=mockEMF;
        Libro nuevo = new Libro();
        nuevo.setAutor("Paco");
        nuevo.setId(1);
        libro.create(nuevo);
        Mockito.verify(mockEM, Mockito.times(1)).persist(Mockito.any());

    }

    /**
     * Test of edit method, of class LibroJpaController.
     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        Libro libro = null;
//        LibroJpaController instance = null;
//        instance.edit(libro);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of destroy method, of class LibroJpaController.
//     */
//    @Test
//    public void testDestroy() throws Exception {
//        System.out.println("destroy");
//        Long id = null;
//        LibroJpaController instance = null;
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

