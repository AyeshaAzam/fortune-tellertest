/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import org.junit.Test;
import se.nackademin.gui.FortuneTellerGui;

/**
 *
 * @author testautomatisering
 */
public class FortuneTellerGuiFirstIT {
 
    //skapar ny testFall
    @Test
    public void testInvalidButton(){
      FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator()); 
      FortuneTellerGui fortuneTellerGui = new FortuneTellerGui(fortuneTeller);
      JButton notCalculateButton = new JButton();
      fortuneTellerGui.actionPerformed(new ActionEvent(notCalculateButton , 0, ""));  
    }   
}
