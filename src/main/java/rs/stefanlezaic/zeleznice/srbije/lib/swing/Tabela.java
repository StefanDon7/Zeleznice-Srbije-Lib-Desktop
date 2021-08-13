/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.swing;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author sleza
 */
public class Tabela {

    public static void urediTabelu(JTable tabela) {
        tabela.setRowHeight(25);
        tabela.setFocusable(false);
        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.setRowHeight(25);
    }

}
