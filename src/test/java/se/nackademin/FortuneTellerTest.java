package se.nackademin;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FortuneTellerTest {

    @Test
    public void testCalculate() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        when(magicNumbersMock.calculateA()).thenReturn(1);
        when(magicNumbersMock.calculateB()).thenReturn(1);
        when(magicNumbersMock.calculateC()).thenReturn(1);
        when(magicNumbersMock.calculateD()).thenReturn(1);
        when(magicNumbersMock.calculateE()).thenReturn(1);

        Translator translatorMock = mock(Translator.class);
        when(translatorMock.getAdjective(anyInt())).thenReturn("liten");
        when(translatorMock.getVerb(anyInt())).thenReturn("springa");
        when(translatorMock.getNoun(anyInt())).thenReturn("en lönehöjning");
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        assertEquals("Din framtid är liten. Du borde sluta springa. Vi ser att du snart kommer att skaffa en lönehöjning. Snart kommer du vilja springa, men då är det viktigt att du är liten.", fortuneTeller.calculate());
    }

    @Test
    public void testSetAge() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("25");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setAge(25);
    }

    @Test
    public void testSetAgeWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("not an integer");
        assertFalse("should return false for invalid input", result);
    }
    
    //testing Height different scenario:
    
    
    @Test
    public void testSetHeight() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setHeight("160");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setHeight(160);
    }
    
    @Test
    public void testSetHeightWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setHeight("Not a valid number");
        assertFalse("should return false for invalid input", result);
        //verify(magicNumbersMock, times(1)).setHeight(null);
        
    }
    
    // testing Location test scenario
    
    @Test
    public void testSetLocation() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation("Stockholm");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setLocation("Stockholm");
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
    } // do samre for name with Null
    
    @Test
    public void testSetLocationWithEmptyInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation("");
        //assertTrue("should return true for valid input", result);
        //verify(magicNumbersMock, times(1)).setLocation("Stockholm");
        assertEquals (result, false);
    } //do samre for name with empty string
    
    
    // for Testing Name(string)
    @Test
    public void testSetName() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setName("Ayesha");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setName("Ayesha");
    }
    
    
    @Test
    public void testSetNameWithNullInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setName(null);
        //assertTrue("should return true for valid input", result);
        //verify(magicNumbersMock, times(1)).setLocation("Stockholm");
        assertEquals (result, false);
    } 
    
    @Test
    public void testSetNameWithEmptyInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setName("");
        //assertTrue("should return true for valid input", result);
        //verify(magicNumbersMock, times(1)).setLocation("Stockholm");
        assertEquals (result, false);
    } 
    
    // testing Income test scenario
    @Test
    public void testSetIncomeWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("hej");
        assertFalse("should return false for invalid input", result);
    }
    
     @Test
    public void testSetIncomeOutOfLimit() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("20000000");
        assertFalse("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setIncome(20000000);
    }
    
    @Test
    public void testSetIncome() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("10000");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setIncome(10000);
    }
    
}
