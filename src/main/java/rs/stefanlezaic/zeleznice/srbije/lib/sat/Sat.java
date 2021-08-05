/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.sat;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author sleza
 */
public class Sat {

    JLabel lblSat;
    JLabel lblDatum;

    /**
     *
     */
    public Sat(JLabel lblSat, JLabel lblDatum) {
        this.lblSat = lblSat;
        this.lblDatum = lblDatum;
    }

    public void pokreniSat() {
        Thread sat = new Thread() {
            @Override
            public void run() {
                while (true) {
                    Calendar gc = new GregorianCalendar();
                    int godina = gc.get(Calendar.YEAR);
                    int mesec = gc.get(Calendar.MONTH) + 1;
                    int dan = gc.get(Calendar.DAY_OF_MONTH);

                    lblDatum.setText("Datum: " + dan + "/" + mesec + "/" + godina);

                    int sekunde = gc.get(Calendar.SECOND);
                    int minuti = gc.get(Calendar.MINUTE);
                    int sati = gc.get(Calendar.HOUR_OF_DAY);
                    String sekundeString = sekunde + "";
                    String minutiString = minuti + "";
                    String satiString = sati + "";
                    if (sekunde / 10 == 0) {
                        sekundeString = "0" + sekunde;
                    }
                    if (minuti / 10 == 0) {
                        minutiString = "0" + minuti;
                    }
                    if (sati / 10 == 0) {
                        satiString = "0" + sati;
                    }
                    lblSat.setText("Vreme: " + satiString + ":" + minutiString + ":" + sekundeString);

                }
            }
        };
        sat.start();
    }
}
