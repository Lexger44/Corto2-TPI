/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author melvin
 */
@ExtendWith(MockitoExtension.class)
public class MultaTest {
    
    public MultaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Multa.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Multa instance = new Multa();
        Long expResult = 1L;
        instance.setId(1L);
        Long result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId method, of class Multa.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Multa instance = Mockito.mock(Multa.class);
        instance.setId(id);
        Mockito.verify(instance).setId(id);
    }

    /**
     * Test of getEstado method, of class Multa.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Multa instance = new Multa();
        String expResult = "activa";
        instance.setEstado("activa");
        String result = instance.getEstado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class Multa.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        Multa instance = Mockito.mock(Multa.class);
        String estado = "activa";
        instance.setEstado(estado);
        Mockito.verify(instance).setEstado(estado);

    }

    /**
     * Test of getFechaFin method, of class Multa.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        Multa instance = new Multa();
        instance.setFechaFin(new Date(116, 5,3));
        Date expResult = new Date(116, 5,3);
        Date result = instance.getFechaFin();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setFechaFin method, of class Multa.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        Date fechaFin = new Date(116, 5,3);
        Multa instance = Mockito.mock(Multa.class);
        instance.setFechaFin(fechaFin);
        Mockito.verify(instance).setFechaFin(fechaFin);

    }

    /**
     * Test of getFechaInicio method, of class Multa.
     */
    @Test
    public void testGetFechaInicio() {
        System.out.println("getFechaInicio");
        Multa instance = new Multa();
        instance.setFechaInicio(new Date(116, 5,3));
        Date expResult = new Date(116, 5,3);
        Date result = instance.getFechaInicio();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setFechaInicio method, of class Multa.
     */
    @Test
    public void testSetFechaInicio() {
        System.out.println("setFechaInicio");
        Date fechaInicio = new Date(116, 5,3);
        Multa instance = Mockito.mock(Multa.class);
        instance.setFechaInicio(fechaInicio);
        Mockito.verify(instance).setFechaInicio(fechaInicio);

    }

    /**
     * Test of getUsuarioId method, of class Multa.
     */
    @Test
    public void testGetUsuarioId() {
        System.out.println("getUsuarioId");
        Multa instance = new Multa();
        instance.setUsuarioId(new Usuario(1L));
        Usuario expResult = new Usuario(1L);
        Usuario result = instance.getUsuarioId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUsuarioId method, of class Multa.
     */
    @Test
    public void testSetUsuarioId() {
        System.out.println("setUsuarioId");
        Usuario usuarioId = new Usuario(1L);
        Multa instance = Mockito.mock(Multa.class);
        instance.setUsuarioId(usuarioId);
        Mockito.verify(instance).setUsuarioId(usuarioId);

    }

    /**
     * Test of toString method, of class Multa.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Multa instance = new Multa(1L);
        String expResult = "com.mycompany.entity.Multa[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
