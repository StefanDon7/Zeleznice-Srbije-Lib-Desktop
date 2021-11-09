/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.test.Domen;

import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rs.stefanlezaic.zeleznice.srbije.lib.domen.Klijent;
import rs.stefanlezaic.zeleznice.srbije.lib.exception.ParametarsException;

/**
 *
 * @author sleza
 */
public class TestKlijent {

    Klijent klijent;
    Klijent klijent2;

    @Before
    public void setUp() {
        klijent = new Klijent();
        klijent2 = new Klijent();
    }
    @After
    public void tearDown() {
        klijent = null;
        klijent2 = null;
    }
    @Test(expected = ParametarsException.class)
    public void testEmailNull() throws ParametarsException {
        klijent.setEmail(null);
    }
    @Test(expected = ParametarsException.class)
    public void testEmailEmpty() throws ParametarsException {
        klijent.setEmail("");
    }
    @Test(expected = ParametarsException.class)
    public void testEmailInvalid() throws ParametarsException {
        klijent.setEmail("invalidEmail");
    }
    @Test
    public void testToStringTrue() throws ParametarsException {
        klijent.setIme("Mika");
        klijent.setPrezime("Mikic");
        String s = klijent.toString();
        assertTrue(s.contains("Mika"));
        assertTrue(s.contains("Mikic"));
    }
    @Test
    public void testToStringFalse() throws ParametarsException {
        klijent.setIme("Mika");
        klijent.setPrezime("Mikic");
        String s = klijent.toString();
        assertFalse(s.contains("Zika"));
        assertFalse(s.contains("Zikic"));
    }

}
