/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.blackjack1;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import java.util.*;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
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
public class HandTest {
     private ObservableList<Node> cardsARR;
    public HandTest() {
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
     * Test of reset method, of class Hand.
     */
    

    @Test
    public void testReset() {
        System.out.println("reset");
         Card c1 = new Card(Card.Suit.CLUBS,Card.Rank.TWO);
         HBox dealerCards = new HBox(10);
         dealerCards.getChildren().add(c1);
        cardsARR.add(c1);
        Hand instance = new Hand(cardsARR);
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCard method, of class Hand.
     */
    @Test
    public void testGetCardGood() {
        System.out.println("getCard");
        Card c1 = new Card(Card.Suit.CLUBS,Card.Rank.TWO);
        Hand instance = new Hand(cardsARR);
        instance.getCard(c1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of valueProperty method, of class Hand.
     */
    @Test
    public void testValueProperty() {
        System.out.println("valueProperty");
         Hand instance = new Hand(cardsARR);
        SimpleIntegerProperty expResult = new SimpleIntegerProperty(0);
        SimpleIntegerProperty result = instance.totalValProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
