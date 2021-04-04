/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.util.Date;
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
public class HistoricoTest {

    public HistoricoTest() {

    }

    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of getId method, of class Historico.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Historico instance = new Historico();
        instance.setId(9L);
        Long expResult = 9L;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Historico.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Historico instance = Mockito.mock(Historico.class);
        instance.setId(id);
        Mockito.verify(instance).setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaDevolucion method, of class Historico.
     */
    @Test
    public void testGetFechaDevolucion() {
        System.out.println("getFechaDevolucion");
        Historico instance = new Historico();
        Date hoy = new Date();
        instance.setFechaDevolucion(hoy);
        Date expResult = hoy;
        Date result = instance.getFechaDevolucion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaDevolucion method, of class Historico.
     */
    @Test
    public void testSetFechaDevolucion() {
        System.out.println("setFechaDevolucion");
        Historico instance = Mockito.mock(Historico.class);
        Date fechaDevolucion = new Date();
        //  Mockito.verify(instance).setFechaDevolucion(fechaDevolucion);
        instance.setFechaDevolucion(fechaDevolucion);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaDevolucionReal method, of class Historico.
     */
    @Test
    public void testGetFechaDevolucionReal() {
        System.out.println("getFechaDevolucionReal");
        Historico instance = new Historico();
        Date hoy = new Date();
        instance.setFechaDevolucionReal(hoy);
        Date expResult = hoy;
        Date result = instance.getFechaDevolucionReal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFechaDevolucionReal method, of class Historico.
     */
    @Test
    public void testSetFechaDevolucionReal() {
        System.out.println("setFechaDevolucionReal");
        Historico instance = Mockito.mock(Historico.class);
        Date hoy = new Date();
        instance.setFechaDevolucionReal(hoy);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaPrestamo method, of class Historico.
     */
    @Test
    public void testGetFechaPrestamo() {
        System.out.println("getFechaPrestamo");
        Historico instance = new Historico();
        Date hoy = new Date();
        instance.setFechaPrestamo(hoy);
        Date expResult = hoy;
        Date result = instance.getFechaPrestamo();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFechaPrestamo method, of class Historico.
     */
    @Test
    public void testSetFechaPrestamo() {
        System.out.println("setFechaPrestamo");
        Historico instance = Mockito.mock(Historico.class);
        Date hoy = new Date();
        instance.setFechaPrestamo(hoy);

    }

    /**
     * Test of getEjemplarId method, of class Historico.
     */
    @Test
    public void testGetEjemplarId() {
        System.out.println("getEjemplarId");
        Historico instance = new Historico();
        Ejemplar ejemplar = new Ejemplar(1, "ewfew");
        instance.setEjemplarId(ejemplar);
        
        Ejemplar result = instance.getEjemplarId();
        
        assertEquals(ejemplar, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setEjemplarId method, of class Historico.
     */
    @Test
    public void testSetEjemplarId() { 
        System.out.println("setEjemplarId");
        Ejemplar ejemplarId = Mockito.mock(Ejemplar.class);
        Historico instance = Mockito.mock(Historico.class);
        instance.setEjemplarId(ejemplarId);
        //Mockito.verify(instance).setEjemplarId(ejemplarId);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuarioId method, of class Historico.
     */
    @Test
    public void testGetUsuarioId() {
        System.out.println("getUsuarioId");
        Historico instance = new Historico();
        Usuario expResult = Mockito.mock(Usuario.class);
        instance.setUsuarioId(expResult);
        Usuario result = instance.getUsuarioId();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuarioId method, of class Historico.
     */
    @Test
    public void testSetUsuarioId() {
        System.out.println("setUsuarioId");
        Historico instance = new Historico();
        Usuario expResult = Mockito.mock(Usuario.class);
        instance.setUsuarioId(expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    

}
