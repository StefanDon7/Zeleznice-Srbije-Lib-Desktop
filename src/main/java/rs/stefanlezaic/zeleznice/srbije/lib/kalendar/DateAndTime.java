/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.kalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;

/**
 *
 * @author Stefan
 */
public class DateAndTime {

    int brojGodina;
    Vreme vreme;
    JComboBox cmbDani;
    JComboBox cmbMeseci;
    JComboBox cmbGodina;

    public DateAndTime(int brojGodina, Vreme vreme, JComboBox cmbDani, JComboBox cmbMeseci, JComboBox cmbGodina) {
        this.brojGodina = brojGodina;
        this.vreme = vreme;
        this.cmbDani = cmbDani;
        this.cmbMeseci = cmbMeseci;
        this.cmbGodina = cmbGodina;
    }

    public void srediDaneMeseceGodinu() throws Exception {
        cmbDani.removeAllItems();
        cmbGodina.removeAllItems();
        GregorianCalendar gc = new GregorianCalendar();
        int godina = gc.get(Calendar.YEAR);
        postaviGodine(godina, brojGodina, vreme);

    }

    private void postaviDaneZaOdredjeniMesecIGodinu(int mesec, int godina) {
        switch (mesec) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                cmbDani.removeAllItems();
                for (int i = 1; i <= 31; i++) {
                    cmbDani.addItem(i);
                }
                break;
            case 3:
            case 5:
            case 8:
            case 10:
                cmbDani.removeAllItems();
                for (int i = 1; i <= 30; i++) {
                    cmbDani.addItem(i);
                }
                break;
            case 1:
                int i;
                cmbDani.removeAllItems();
                for (i = 1; i <= 28; i++) {
                    cmbDani.addItem(i);
                }
                if (godina % 400 == 0) {
                    cmbDani.addItem(i);
                } else if ((godina % 100 != 0) && (godina % 4 == 0)) {
                    cmbDani.addItem(i);
                }
                break;
            default:
                System.out.println("POGRESAN MESEC!");
        }
    }

    public void promena() {
        int index = cmbMeseci.getSelectedIndex();
        int godina = (int) cmbGodina.getSelectedItem();
        postaviDaneZaOdredjeniMesecIGodinu(index, godina);
    }

    private void postaviGodine(int trenutnaGodina, int brojGodina, Vreme vreme1) throws Exception {
        switch (vreme1) {
            case Unapred:
                for (int i = trenutnaGodina; i <= trenutnaGodina + brojGodina; i++) {
                    cmbGodina.addItem(i);
                }
                break;
            case Unazad:
                for (int i = trenutnaGodina - brojGodina; i <= trenutnaGodina; i++) {
                    cmbGodina.addItem(i);
                }
                break;
            case UnazadIUnapred:
                for (int i = trenutnaGodina - brojGodina; i <= trenutnaGodina + brojGodina; i++) {
                    cmbGodina.addItem(i);
                }
                break;
            default:
                throw new Exception();

        }
    }

    public void postaviDanasnjiDatum() {
        GregorianCalendar gc = new GregorianCalendar();
        int godina = gc.get(Calendar.YEAR);
        int mesec = gc.get(Calendar.MONTH);
        int dan = gc.get(Calendar.DAY_OF_MONTH);
        cmbGodina.setSelectedItem(godina);
        cmbMeseci.setSelectedIndex(mesec);
        cmbDani.setSelectedItem(dan);
    }
}
