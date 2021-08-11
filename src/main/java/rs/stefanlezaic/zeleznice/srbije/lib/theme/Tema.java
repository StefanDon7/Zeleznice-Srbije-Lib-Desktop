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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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

    Container c;

    public Tema() {
    }

    public Tema(Container c) {
        this.c = c;
    }

    public void setC(Container c) {
        this.c = c;
    }
    

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

    public void blackTheme() {
        ArrayList<Component> compList = (ArrayList<Component>) getAllComponents(c);
        for (Component component : compList) {
            if (component instanceof JLabel) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.SIVA187);
            } else if (component instanceof JButton) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.CRNA44);
            } else if (component instanceof JPanel) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNA44, ColorConstant.SIVA153);
            } else if (component instanceof JComboBox) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA187, ColorConstant.CRNA44);
            } else if (component instanceof JMenu) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNA44, ColorConstant.SIVA187);
            } else if (component instanceof JMenuBar) {
                urediPozadinuISlovaKomponente(component, ColorConstant.CRNA44, ColorConstant.SIVA187);
            }else if (component instanceof JTable) {
                urediPozadinuISlovaKomponente(component, ColorConstant.BELA225, ColorConstant.CRNA44);
            } else if (component instanceof JTextField) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.CRNA44);
            } else if (component instanceof JScrollPane) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.CRNA44);
            } else if (component instanceof JSpinner) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.CRNA44);
            } else if (component instanceof JScrollBar) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.CRNA44);
            } else if (component instanceof JCheckBox) {
                urediPozadinuISlovaKomponente(component, ColorConstant.SIVA153, ColorConstant.SIVA187);
            }
        }
    }

    public void whiteTheme() {
        ArrayList<Component> compList = (ArrayList<Component>) getAllComponents(c);
        for (Component component : compList) {
//            if (component instanceof JLabel) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JButton) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JPanel) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JComboBox) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JMenu) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JTable) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JTextField) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JScrollPane) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JSpinner) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JScrollBar) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            } else if (component instanceof JCheckBox) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            }else if (component instanceof JMenu) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            }else if (component instanceof JMenuBar) {
//                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
//            }
                urediPozadinuISlovaKomponente(component, ColorConstant.BELA255, ColorConstant.CRNO60_63_65);
        }
    }
    
}
