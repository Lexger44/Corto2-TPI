/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.controllers.exceptions.NonexistentEntityException;
import com.mycompany.entity.Bibliotecario;
import com.mycompany.entity.Libro;
import javax.management.RuntimeErrorException;
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

    static EntityManagerFactory mockEMF;
    static LibroJpaController registro;
    static Libro LibroObject;

    public LibroJpaControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        mockEMF = Mockito.mock(EntityManagerFactory.class);
        registro = new LibroJpaController(mockEMF);
        LibroObject = new Libro(1);
    }

    @AfterAll
    public static void tearDownClass() {
    }

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

    @Test
    public void testCreate() {
        System.out.println("create");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEMF.createEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        this.registro.create(LibroObject);
        Mockito.verify(mockEM).persist(this.LibroObject);
        Mockito.verify(mockEM).close();
    }

    @Test
    public void testEdit() throws Exception, NonexistentEntityException {
        System.out.println("edit");
        EntityManager mockEm = Mockito.mock(EntityManager.class);
        EntityTransaction mockTx = Mockito.mock(EntityTransaction.class);
        Mockito.when(mockEMF.createEntityManager()).thenReturn(mockEm);
        Mockito.when(mockEm.getTransaction()).thenReturn(mockTx);

        Mockito.when(mockEm.merge(LibroObject)).thenReturn(LibroObject);
        registro.edit(LibroObject);
        Mockito.verify(mockEm).merge(LibroObject);
        Mockito.verify(mockEm).close();
        RuntimeErrorException mockRx = Mockito.mock(RuntimeErrorException.class);

        Mockito.when(mockEm.merge(LibroObject)).thenThrow(mockRx);
        Bibliotecario mockB = Mockito.mock(Bibliotecario.class);
        try {
            registro.edit(LibroObject);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            registro.edit(LibroObject);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Libro nuevo = Mockito.mock(Libro.class);
        EntityManager mockEM= Mockito.mock(EntityManager.class);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        LibroJpaController libro = new LibroJpaController(mockEMF);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        Mockito.when(libro.getEntityManager()).thenReturn(mockEM);
        libro.destroy(nuevo);
        
    }
}
