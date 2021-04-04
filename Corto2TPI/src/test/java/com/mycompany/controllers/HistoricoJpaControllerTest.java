/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.entity.Ejemplar;
import com.mycompany.entity.Historico;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author cmargueiz
 */
@ExtendWith(MockitoExtension.class)
public class HistoricoJpaControllerTest {

    EntityManager mockEM;
    EntityManagerFactory mockEMF;
    EntityTransaction mockTX;

    public HistoricoJpaControllerTest() {
        mockEM = Mockito.mock(EntityManager.class);
        mockEMF = Mockito.mock(EntityManagerFactory.class);
        mockTX = Mockito.mock(EntityTransaction.class);
    }

    @BeforeEach
    public void setUp() {

    }

    /**
     * Test of getEntityManager method, of class HistoricoJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        HistoricoJpaController instance = new HistoricoJpaController(mockEMF);

        Mockito.when(mockEMF.createEntityManager()).thenReturn(mockEM);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class HistoricoJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Historico historico = Mockito.mock(Historico.class);
        Ejemplar ejemplar = new Ejemplar(1, "bfdisbfdb");
        Usuario usuario = new Usuario(1l, "cosas", "estado");

        HistoricoJpaController instance = new HistoricoJpaController(mockEMF);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        Mockito.when(historico.getEjemplarId()).thenReturn(ejemplar);
        instance.create(historico);

        Mockito.when(historico.getUsuarioId()).thenReturn(usuario);

        instance.create(historico);

        Mockito.when(historico.getEjemplarId()).thenReturn(ejemplar);

        instance.create(historico);
        Mockito.when(historico.getUsuarioId()).thenReturn(usuario);
        instance.create(historico);

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class HistoricoJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Historico historico = Mockito.mock(Historico.class);
        HistoricoJpaController instance = new HistoricoJpaController(mockEMF);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
            
        instance.edit(historico);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class HistoricoJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Historico historico = Mockito.mock(Historico.class);
        HistoricoJpaController instance = new HistoricoJpaController(mockEMF);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
            
        instance.destroy(historico);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


}
