/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.util.Date;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import java.util.Set;

/**
 *
 * @author Chris Oliva
 */

public class EjemplarTest {
    static Ejemplar registro = new Ejemplar();
    Date FechaAdquirido ;
    Date FechaDevolver ;
    Date FechaPrestar;
    
    
    
    
    public EjemplarTest() {
        FechaAdquirido = new Date(121, 7, 7);
        FechaDevolver = new Date(121, 8, 8);
        FechaPrestar = new Date(121, 7, 20);
    }
    
    @BeforeAll
    public static void setUpClass() {
        registro.setId(1);
        
        Date FechaAdquirido = new Date(121, 7, 7);
        System.out.println(FechaAdquirido);
        registro.setFechaAdquisicion(FechaAdquirido);
        
        Date FechaDevolver = new Date(121, 8, 8);
        System.out.println(FechaDevolver);
        registro.setFechaDevolucion(FechaDevolver);
        
        Date FechaPrestar = new Date(121, 7, 20);
        System.out.println(FechaPrestar);
        registro.setFechaPrestamo(FechaPrestar);
        
        registro.setIdEjemplar("Don Quijote de la Mancha");
        
        registro.setLocalizacion("Colonia El Palmar");
        
        registro.setObservaciones("Se presto un libro nuevo");
        
        registro.setLibroId(new Libro(1));
        
        registro.setUsuarioId(new Usuario(1L));
        
        
        
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        registro = null;
    }

    /**
     * Test of getId method, of class Ejemplar.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Ejemplar instance = new Ejemplar();
        instance.setId(1);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId method, of class Ejemplar.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setId(id);
        Mockito.verify(instance).setId(id);
        

    }

    /**
     * Test of getFechaAdquisicion method, of class Ejemplar.
     */
    @Test
    public void testGetFechaAdquisicion() {
        System.out.println("getFechaAdquisicion");
        
        Date expResult = FechaAdquirido;
        Date result = this.registro.getFechaAdquisicion();
        assertEquals(expResult, result);

    }

    /**
     * Test of setFechaAdquisicion method, of class Ejemplar.
     */
    @Test
    public void testSetFechaAdquisicion() {
        System.out.println("setFechaAdquisicion");
        Date fechaAdquisicion = FechaAdquirido;
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setFechaAdquisicion(fechaAdquisicion);
        Mockito.verify(instance).setFechaAdquisicion(fechaAdquisicion);
        
        
    }

    /**
     * Test of getFechaDevolucion method, of class Ejemplar.
     */
    @Test
    public void testGetFechaDevolucion() {
        System.out.println("getFechaDevolucion");     
        Date expResult = FechaDevolver;
        Date result = this.registro.getFechaDevolucion();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of setFechaDevolucion method, of class Ejemplar.
     */
    @Test
    public void testSetFechaDevolucion() {
        System.out.println("setFechaDevolucion");
        Date fechaDevolucion = FechaDevolver;
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setFechaDevolucion(fechaDevolucion);
        Mockito.verify(instance).setFechaDevolucion(fechaDevolucion);
     
    }

    /**
     * Test of getFechaPrestamo method, of class Ejemplar.
     */
    @Test
    public void testGetFechaPrestamo() {
        System.out.println("getFechaPrestamo");
        
        Date expResult = FechaPrestar;
        Date result = this.registro.getFechaPrestamo();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of setFechaPrestamo method, of class Ejemplar.
     */
    @Test
    public void testSetFechaPrestamo() {
        System.out.println("setFechaPrestamo");
        Date fechaPrestamo = FechaPrestar;
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setFechaPrestamo(fechaPrestamo);
        Mockito.verify(instance).setFechaPrestamo(fechaPrestamo);

    }

    /**
     * Test of getIdEjemplar method, of class Ejemplar.
     */
    @Test
    public void testGetIdEjemplar() {
        System.out.println("getIdEjemplar");
      
        String expResult = "Don Quijote de la Mancha";
        String result = this.registro.getIdEjemplar();
        assertEquals(expResult, result);

    }

    /**
     * Test of setIdEjemplar method, of class Ejemplar.
     */
    @Test
    public void testSetIdEjemplar() {
        System.out.println("setIdEjemplar");
        String idEjemplar = "Don Quijote de la Mancha";
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setIdEjemplar(idEjemplar);
        Mockito.verify(instance).setIdEjemplar(idEjemplar);

    }

    /**
     * Test of getLocalizacion method, of class Ejemplar.
     */
    @Test
    public void testGetLocalizacion() {
        System.out.println("getLocalizacion");
      
        String expResult = "Colonia El Palmar";
        String result = this.registro.getLocalizacion();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of setLocalizacion method, of class Ejemplar.
     */
    @Test
    public void testSetLocalizacion() {
        System.out.println("setLocalizacion");
        String localizacion = "Colonia El Palmar";
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setLocalizacion(localizacion);
        Mockito.verify(instance).setLocalizacion(localizacion);
    }

    /**
     * Test of getObservaciones method, of class Ejemplar.
     */
    @Test
    public void testGetObservaciones() {
        System.out.println("getObservaciones");
        String expResult = "Se presto un libro nuevo";
        String result = this.registro.getObservaciones();
        assertEquals(expResult, result);

    }

    /**
     * Test of setObservaciones method, of class Ejemplar.
     */
    @Test
    public void testSetObservaciones() {
        System.out.println("setObservaciones");
        String observaciones = "Se presto un libro nuevo";
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setObservaciones(observaciones);
        Mockito.verify(instance).setObservaciones(observaciones);

    }

    /**
     * Test of getLibroId method, of class Ejemplar.
     */
    @Test
    public void testGetLibroId() {
        System.out.println("getLibroId");
       
        Libro expResult = this.registro.getLibroId();
        Libro result = this.registro.getLibroId();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of setLibroId method, of class Ejemplar.
     */
    @Test
    public void testSetLibroId() {
        System.out.println("setLibroId");
        Libro libroId = new Libro(1);
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setLibroId(libroId);
        Mockito.verify(instance).setLibroId(libroId);

    }

    /**
     * Test of getUsuarioId method, of class Ejemplar.
     */
    @Test
    public void testGetUsuarioId() {
        
        System.out.println("getUsuarioId");
        Usuario UsuarioId = new Usuario(1L);
       
        Usuario expResult = UsuarioId;
        Usuario result = this.registro.getUsuarioId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUsuarioId method, of class Ejemplar.
     */
    @Test
    public void testSetUsuarioId() {
        System.out.println("setUsuarioId");
        Usuario usuarioId = new Usuario(1L);
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setUsuarioId(usuarioId);
        Mockito.verify(instance).setUsuarioId(usuarioId);

    }

    /**
     * Test of getHistoricoSet method, of class Ejemplar.
     */
    @Test
    public void testGetHistoricoSet() {
        System.out.println("getHistoricoSet");
        Ejemplar instance = Mockito.mock(Ejemplar.class);
                
        Set<Historico> expResult = Mockito.mock(Set.class);
        Mockito.when(instance.getHistoricoSet()).thenReturn(expResult);
   
  
    }

    /**
     * Test of setHistoricoSet method, of class Ejemplar.
     */
    @Test
    public void testSetHistoricoSet() {
        System.out.println("setHistoricoSet");
        Set<Historico> historicoSet = Mockito.mock(Set.class);;
        Ejemplar instance = Mockito.mock(Ejemplar.class);
        instance.setHistoricoSet(historicoSet);
        Mockito.verify(instance).setHistoricoSet(historicoSet);
      
    }

    /**
     * Test of toString method, of class Ejemplar.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ejemplar instance = new Ejemplar(1);
        String expResult = "com.mycompany.entity.Ejemplar[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
      
    }
    
}
