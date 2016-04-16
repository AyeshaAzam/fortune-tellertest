package se.nackademin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class FortuneTellerIT {

    @Test
    public void testGetFortune() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("16");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("11000");
        fortuneTeller.setLocation("Hagfors");
        fortuneTeller.setName("Sture Hagfors");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }
    
    // cretaing different test scenario
    
    @Test
    public void testGetFortuneWithString() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("hej");
        fortuneTeller.setHeight("hello");
        fortuneTeller.setIncome("ola");
        fortuneTeller.setLocation("helloha");
        fortuneTeller.setName("hejsan");
        String output = fortuneTeller.calculate();
        assertNotEquals("Fortune should be calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }
    
    @Test
    public void testGetFortuneWithEmptyString() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("");
        fortuneTeller.setHeight("");
        fortuneTeller.setIncome("");
        fortuneTeller.setLocation("");
        fortuneTeller.setName("");
        String output = fortuneTeller.calculate();
        assertNotEquals("Fortune should be calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }
    
    @Test
    public void testGetFortuneInvalidInteger() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("16");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("21000000");
        fortuneTeller.setLocation("Hagfors");
        fortuneTeller.setName("Sture Hagfors");
        String output = fortuneTeller.calculate();
        assertNotEquals("Fortune should be calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }
    
     @Test
    public void testSetNameWithNullInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setName(null);
        //verify(magicNumbersMock, times(1)).setLocation("Stockholm");
        assertEquals (result, false);
    } 
    
    @Test
    public void testSetLocationWithEmptyInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation("");
        //assertTrue("should return true for valid input", result);
        //verify(magicNumbersMock, times(1)).setLocation("Stockholm");
        assertEquals (result, false);
    } 
    
    @Test
    public void testSetLocationWithNullInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation(null);
        //assertTrue("should return true for valid input", result);
        //verify(magicNumbersMock, times(1)).setLocation("Stockholm");
        assertEquals (result, false);
    } 
    
}
