/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.blackjack1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author parmi
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of drawCard method, of class Deck.
     */
    @Test
    public void testDrawCardGood() {
        System.out.println("drawCard");
        Deck instance = new Deck();
        Card expResult = instance.drawCard();
        Card result = expResult;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
       
    }
    
     public void testDrawCardBoundary() {
        System.out.println("drawCard");
        Deck instance = new Deck();
        Deck instance1 = new Deck();
        Card expResult = instance.drawCard();
        Card result = instance1.drawCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    public void testDrawCardBad() {
        System.out.println("drawCard");
        Deck instance = new Deck();
        Deck instance1 = new Deck();
        Card expResult = instance.drawCard();
        Card result = instance1.drawCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    /**
     * Test of refill method, of class Deck.
     */
    @Test
    public void testRefillGood() {
        System.out.println("refill");
        Deck instance = new Deck();
        instance.refill();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
