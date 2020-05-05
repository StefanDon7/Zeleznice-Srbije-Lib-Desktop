/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.sat;

import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author sleza
 */
public class Sat {

    public void sat(JLabel lblSat) {
        Thread sat = new Thread() {
            public void run() {

                while (true) {
                    Calendar gc = new GregorianCalendar();
                    int godina = gc.get(Calendar.YEAR);
                    int mesec = gc.get(Calendar.MONTH) + 1;
                    int dan = gc.get(Calendar.DAY_OF_MONTH);
                    int sekunde = gc.get(Calendar.SECOND);
                    int minuti = gc.get(Calendar.MINUTE);
                    int sati = gc.get(Calendar.HOUR_OF_DAY);
                    if (minuti / 10 == 0 && sekunde / 10 == 0) {
                        lblSat.setText("Datum: " + dan + "/" + mesec + "/" + godina + "     Vreme: " + sati + ":0" + minuti + ":0" + sekunde);
                    } else if (minuti / 10 == 0 && sekunde / 10 != 0) {
                        lblSat.setText("Datum: " + dan + "/" + mesec + "/" + godina + "     Vreme: " + sati + ":0" + minuti + ":" + sekunde);
                    } else if (minuti / 10 != 0 && sekunde / 10 == 0) {
                        lblSat.setText("Datum: " + dan + "/" + mesec + "/" + godina + "     Vreme: " + sati + ":" + minuti + ":0" + sekunde);
                    } else {
                        lblSat.setText("Datum: " + dan + "/" + mesec + "/" + godina + "     Vreme: " + sati + ":" + minuti + ":" + sekunde);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sat.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        };
        sat.start();
    }
}
