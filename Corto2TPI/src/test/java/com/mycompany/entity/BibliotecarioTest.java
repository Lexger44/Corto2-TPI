/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author carlo
 */
@ExtendWith(MockitoExtension.class)
public class BibliotecarioTest {
    
    static Bibliotecario registro = new Bibliotecario();
    
    public BibliotecarioTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {  
        registro.setId(1L);              
        registro.setEmail("correoprueba@gmail.com");
        registro.setLogin("UsuarioPrueba");
        registro.setNif("123456789");
        registro.setPassword("ClavePrueba");
    }
    
    @AfterAll
    public static void tearDownClass() {
        registro = null;
    }           
    
    /**
     * Test of getId method, of class Bibliotecario.
     */
    @Test
    public void testGetId() {        
        System.out.println("getId");               
        Long expResult = 1L;
        Long result = this.registro.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.        
    }

    /**
     * Test of setId method, of class Bibliotecario.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Bibliotecario instance = Mockito.mock(Bibliotecario.class);        
        instance.setId(id);
        Mockito.verify(instance).setId(id);
    }

    /**
     * Test of getEmail method, of class Bibliotecario.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");        
        String expResult = "correoprueba@gmail.com";
        String result = this.registro.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Bibliotecario.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "correoprueba@gmail.com";
        Bibliotecario instance = Mockito.mock(Bibliotecario.class);
        instance.setEmail(email);
        Mockito.verify(instance).setEmail(email);
    }

    /**
     * Test of getLogin method, of class Bibliotecario.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");        
        String expResult = "UsuarioPrueba";
        String result = this.registro.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLogin method, of class Bibliotecario.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "UsuarioPrueba";
        Bibliotecario instance = Mockito.mock(Bibliotecario.class);
        instance.setLogin(login);
        Mockito.verify(instance).setLogin(login);
    }

    /**
     * Test of getNif method, of class Bibliotecario.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        String expResult = "123456789";
        String result = this.registro.getNif();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNif method, of class Bibliotecario.
     */
    @Test
    public void testSetNif() {
        System.out.println("setNif");
        String nif = "123456789";
        Bibliotecario instance = Mockito.mock(Bibliotecario.class);
        instance.setNif(nif);
        Mockito.verify(instance).setNif(nif);
    }

    /**
     * Test of getPassword method, of class Bibliotecario.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");        
        String expResult = "ClavePrueba";
        String result = this.registro.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Bibliotecario.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "ClavePrueba";
        Bibliotecario instance = Mockito.mock(Bibliotecario.class);
        instance.setPassword(password);
        Mockito.verify(instance).setPassword(password);
    }    
    
    /**
     * Test of toString method, of class Bibliotecario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");        
        String expResult = "com.mycompany.entity.Bibliotecario[ id=" + 1L + " ]";
        String result = this.registro.toString();
        assertEquals(expResult, result);
    }
    
}
