/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

//import static com.mycompany.entity.Bibliotecario_.id;
import java.text.DateFormat;
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
 * @author sofia
 */
@ExtendWith(MockitoExtension.class)
public class ReservaTest {
    static Reserva registro = new Reserva();
    
    public ReservaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {         
        registro.setEstado("activo");
        Date fechaI = new Date(121, 10, 11,16,30,10);
        System.out.println(DateFormat.getDateInstance().format(fechaI));
        registro.setFecha(fechaI);
        registro.setLibroId(new Libro(1));
        registro.setUsuarioId(new Usuario(9L));
             
    }
    
    @AfterAll
    public static void tearDownClass() {
        registro = null;
    }

    /**
     * Test of getId method, of class Reserva.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Reserva instance = new Reserva();
        instance.setId(9L);
        Long expResult = 9L;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Reserva.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setId(id);
    }

    /**
     * Test of getEstado method, of class Reserva.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        String expResult = "activo";
        String result = this.registro.getEstado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class Reserva.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "activo";
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setEstado(estado);
        Mockito.verify(instance).setEstado(estado);
    }

    /**
     * Test of getFecha method, of class Reserva.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Date expResult = (Date) Reserva_.fecha;
        Date result = this.registro.getFecha();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFecha method, of class Reserva.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = (Date) Reserva_.fecha;
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setFecha(fecha);
        Mockito.verify(instance).setFecha(fecha);
    }

    /**
     * Test of getFechaFin method, of class Reserva.
     */
    @Test
    public void testGetFechaFin() {
        System.out.println("getFechaFin");
        Date expResult = (Date) Reserva_.fechaFin;
        Date result = this.registro.getFechaFin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFechaFin method, of class Reserva.
     */
    @Test
    public void testSetFechaFin() {
        System.out.println("setFechaFin");
        Date fechaFin = (Date) Reserva_.fechaFin;
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setFechaFin(fechaFin);
        Mockito.verify(instance).setFechaFin(fechaFin);
    }

    /**
     * Test of getLibroId method, of class Reserva.
     */
    @Test
    public void testGetLibroId() {
        System.out.println("getLibroId");
        Libro expResult = this.registro.getLibroId();
        Libro result = this.registro.getLibroId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLibroId method, of class Reserva.
     */
    @Test
    public void testSetLibroId() {
        System.out.println("setLibroId");
        Libro libroId = new Libro(1);
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setLibroId(libroId);
        Mockito.verify(instance).setLibroId(libroId);
    }

    /**
     * Test of getUsuarioId method, of class Reserva.
     */
    @Test
    public void testGetUsuarioId() {
        System.out.println("getUsuarioId");
        Usuario UsuarioId = new Usuario(9L);
        Usuario expResult = UsuarioId;
        Usuario result = this.registro.getUsuarioId();
        assertEquals(expResult, result);

       
    }

    /**
     * Test of setUsuarioId method, of class Reserva.
     */
    @Test
    public void testSetUsuarioId() {
        System.out.println("setUsuarioId");
        Usuario usuarioId = new Usuario(9L);
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setUsuarioId(usuarioId);
        Mockito.verify(instance).setUsuarioId(usuarioId);
    
    }

    /**
     * Test of toString method, of class Reserva.
     */
    @Test
    public void testToString() {
      System.out.println("toString");    
      Reserva instance = new Reserva(9L);
        String expResult = "com.mycompany.entity.Reserva[ id=" + 9L + " ]";
        String result = this.registro.toString();
        assertEquals(expResult, result);
 
    }
}
