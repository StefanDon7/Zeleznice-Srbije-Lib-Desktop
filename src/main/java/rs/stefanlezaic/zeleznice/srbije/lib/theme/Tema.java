/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.theme;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import rs.stefanlezaic.zeleznice.srbije.lib.color.ColorConstant;

/**
 *
 * @author sleza
 */
public class Tema {

    public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }

        return compList;
    }

    public void urediPozadinuISlovaKomponente(Component component, Color bojaPozadine, Color bojaSlova) {
        component.setBackground(bojaPozadine);
        component.setForeground(bojaSlova);
    }

    public void blackTheme(Container c) {
        ArrayList<Component> compList = (ArrayList<Component>) getAllComponents(c);
        for (Component component : compList) {
            if (component instanceof JLabel) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNO60_63_65, ColorConstant.SIVA187);
            } else if (component instanceof JButton) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.CRNA0);
            } else if (component instanceof JPanel) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNA44, ColorConstant.CRNA0);
            } else if (component instanceof JComboBox) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNO102, ColorConstant.CRNA0);
            } else if (component instanceof JMenu) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA187, ColorConstant.CRNA0);
            } else if (component instanceof JTable) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNO102, ColorConstant.CRNA0);
            } else if (component instanceof JTextField) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNO102, ColorConstant.CRNA0);
            } else if (component instanceof JScrollPane) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNO102, ColorConstant.CRNA0);
            } else if (component instanceof JSpinner) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNO102, ColorConstant.CRNA0);
            } else if (component instanceof JScrollBar) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNO102, ColorConstant.CRNA0);
            }
        }
    }

    public void whiteTheme(Container c) {
        ArrayList<Component> compList = (ArrayList<Component>) getAllComponents(c);
        for (Component component : compList) {
            urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNA0);
        }
    }

}
