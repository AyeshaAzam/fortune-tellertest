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
public class LauncherTest {
    Launcher laucher = new Launcher();
   
    

    /**
     * Test of main method, of class Launcher.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Launcher.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
