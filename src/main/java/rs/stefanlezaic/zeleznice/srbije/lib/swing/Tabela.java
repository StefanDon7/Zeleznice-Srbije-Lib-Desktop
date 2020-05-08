/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import static rs.stefanlezaic.zeleznice.srbije.lib.theme.Tema.getAllComponents;

/**
 *
 * @author sleza
 */
public class Tabela {

    Container c;

    public Tabela() {
    }

    public Tabela(Container c) {
        this.c = c;
        ulepsajSveTabele();
    }

    private void ulepsajTabelu(JTable tabela) {
        tabela.setRowHeight(25);
        tabela.setFocusable(false);
        tabela.setShowVerticalLines(false);
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabela.getTableHeader().setOpaque(false);
        tabela.setRowHeight(25);
    }

    private void ulepsajSveTabele() {
        ArrayList<Component> compList = (ArrayList<Component>) getAllComponents(c);
        for (Component component : compList) {
            if (component instanceof JTable) {
                JTable tabela = (JTable) component;
                ulepsajTabelu(tabela);
            }

        }

    }
}
