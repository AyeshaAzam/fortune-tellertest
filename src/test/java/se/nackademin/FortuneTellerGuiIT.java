package se.nackademin;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.nackademin.gui.FortuneTellerGui;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;

public class FortuneTellerGuiIT {
    FortuneTeller fortuneTeller;
    FortuneTellerGui fortuneTellerGui;

    @Test(timeout = 10000)
    public void testGetFortuneUsingGui() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("11000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String output = window.textBox("resultField").text();
        //System.out.println("OutPut = " +output);
       assertEquals("Verify that the fortune is calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }

    @Test(timeout = 10000)
    public void testInvalidIncome() {
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("hej");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String errorMessage = window.optionPane().label("OptionPane.label").text();
        assertThat("error message should contain text 'Invalid income'", errorMessage, containsString("Invalid income"));
        window.optionPane().button().click();
    }
    
    
    @Test(timeout = 10000)
    public void testGetFortuneAcceptance37() {      //Svante/-10000/Malmö/27/0 ger ArrayIndexOutOfBoundsException
        window.textBox("nameField").enterText("Sture Hagfors");
        window.textBox("incomeField").enterText("11000");
        window.textBox("locationField").enterText("Hagfors");
        window.textBox("ageField").enterText("16");
        window.textBox("heightField").enterText("165");
        window.button("calculateButton").click();
        String output = window.textBox("resultField").text();
        //System.out.println("OutPut = " +output);
       assertEquals("Verify that the fortune is calculated correctly", "Din framtid är mjuk. Du borde sluta se. Vi ser att du snart kommer att skaffa en fotboja. Snart kommer du vilja mäta, men då är det viktigt att du är mörk.", output);
    }

    private FrameFixture window;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTellerGui = GuiActionRunner.execute(new GuiQuery<FortuneTellerGui>() {
            protected FortuneTellerGui executeInEDT() {
                return new FortuneTellerGui(fortuneTeller);
            }
        });
        window = new FrameFixture(fortuneTellerGui);
        window.show();
    }

    @After
    public void tearDown() {
        window.cleanUp();
    }
}

