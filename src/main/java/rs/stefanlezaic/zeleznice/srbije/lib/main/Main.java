/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.main;

import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.JOptionPaneExample;
import rs.stefanlezaic.zeleznice.srbije.lib.view.dialog.PanelAttention;

/**
 *
 * @author Stefan
 */
public class Main {
    public static void main(String[] args) {
        JOptionPaneExample jop=new JOptionPaneExample();
        jop.createAndDisplayGUI(null, new PanelAttention("Pogresno"));
    }
}
