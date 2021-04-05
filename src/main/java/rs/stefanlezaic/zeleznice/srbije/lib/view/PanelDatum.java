/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import rs.stefanlezaic.zeleznice.srbije.lib.kalendar.DateAndTime;
import rs.stefanlezaic.zeleznice.srbije.lib.kalendar.Vreme;


/**
 *
 * @author Stefan
 */
public class PanelDatum extends javax.swing.JPanel implements GetValue {

    /**
     * Creates new form PanelDatum
     */
    DateAndTime dateAndTime;

    public PanelDatum() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbDays = new javax.swing.JComboBox();
        cmbMonths = new javax.swing.JComboBox();
        cmbYears = new javax.swing.JComboBox();

        cmbMonths.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JANUARY", "FEBRUARY", "MART", "APRIL", "MAY", "JUNE", "JULY", "AVGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" }));
        cmbMonths.setToolTipText("");
        cmbMonths.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthsItemStateChanged(evt);
            }
        });

        cmbYears.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbYearsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMonthsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthsItemStateChanged
        dateAndTime.promena();
    }//GEN-LAST:event_cmbMonthsItemStateChanged

    private void cmbYearsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbYearsItemStateChanged
        dateAndTime.promena();
    }//GEN-LAST:event_cmbYearsItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDays;
    private javax.swing.JComboBox cmbMonths;
    private javax.swing.JComboBox cmbYears;
    // End of variables declaration//GEN-END:variables

    /**
     * Dodaje broj godina koji zelimo da se pojavi u nasem kalendaru.
     *
     * @param godina
     * broj godina koji zelimo da se postavi u kalendaru
     * @param vreme 
     * Odredjuje da li ce godine biti dodate za buducnost,proslost ili buducnost i proslost i to:
     * <ul>
     * <li> Unapred - pocece od danasnje godine i dodati jos onoliko godina UNAPRED(Buduce godine) koliko ste stavili.
     * <li> Unazad - pocece od danasnje godine i dodati jos onoliko godina UNAZAD(Prosle godine) koliko ste stavili.
     * <li> UnazadIUnapred-dodace broj godina u buducnost i u proslost.
     * </ul>
     
     *
     * @throws Exception
     * <ul>
     * <li> Greska-Ako unesemo neki drugi ENUM umesto(Unapred,Unazad ili UnapredIlIUnazad)
     * </ul>
     *
     */
    
    public void postavi(int godina, Vreme vreme) {
        dateAndTime = new DateAndTime(godina, vreme, cmbDays, cmbMonths, cmbYears);
        try {
            dateAndTime.srediDaneMeseceGodinu();
        } catch (Exception ex) {
            System.out.println("Pogresno vreme!");
        }
    }

    @Override
    public Object getValue() throws Exception {
        return cmbDays.getSelectedItem() + "." + (cmbMonths.getSelectedIndex() + 1) + "." + cmbYears.getSelectedItem();
    }

    @Override
    public String toString() {
        return "InputDatePanel";
    }

}