/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author testautomatisering
 */
public class TranslatorTest {
    
    Translator translator = new Translator();
    
    
    
   

    /**
     * Test of getNoun method, of class Translator.
     */
    @Test
    public void testGetNoun(){
        
       System.out.println("getNoun");
       assertEquals("en lönehöjning", translator.getNoun(0));
       assertEquals("en lönesänkning",translator.getNoun(1));
       assertEquals("en fotboja", translator.getNoun(2));
       assertEquals("en katt", translator.getNoun(3));
       assertEquals("en hund", translator.getNoun(4));
       assertEquals("ett hus", translator.getNoun(5));
       assertEquals("ett barn",translator.getNoun(6));
       assertEquals("ett elstängsel", translator.getNoun(7));
       assertEquals("en dator", translator.getNoun(8));
       assertEquals("ett golv",translator.getNoun(9));
       
    }

    /**
     * Test of getVerb method, of class Translator.
     */
    @Test
    public void testGetVerb() 
    {
        //System.out.println("getVerb");
        assertEquals("springa",translator.getVerb(0));
        assertEquals("ljuga", translator.getVerb(1));
        assertEquals("flyga", translator.getVerb(2));
        assertEquals("se", translator.getVerb(3));
        assertEquals("vara", translator.getVerb(4));
        assertEquals("äta", translator.getVerb(5));
        assertEquals("mäta", translator.getVerb(6));
        assertEquals("gå", translator.getVerb(7));
        assertEquals("röra", translator.getVerb(8));
        assertEquals("resa", translator.getVerb(9));
        
    }

    /**
     * Test of getAdjective method, of class Translator.
     */
    @Test
    public void testGetAdjective(){
        System.out.println("getAdjective");
        assertEquals("stor", translator.getAdjective(0));
        assertEquals("liten", translator.getAdjective(1));
        assertEquals("stark", translator.getAdjective(2));
        assertEquals("svag", translator.getAdjective(3));
        assertEquals("mjuk", translator.getAdjective(4));
        assertEquals("hård", translator.getAdjective(5));
        assertEquals("snabb", translator.getAdjective(6));
        assertEquals("vacker", translator.getAdjective(7));
        assertEquals("ljus", translator.getAdjective(8));
        assertEquals("mörk", translator.getAdjective(9));
        
    }
    
}
