package rs.stefanlezaic.zeleznice.srbije.lib.view.dialog;

import java.awt.Color;
import javax.swing.*;

public class JOptionPaneExample {

    public void createAndDisplayGUI(JFrame jfreme, PanelOptionPaneInterface panel) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("Button.background", new Color(51, 102, 153));
        JOptionPane.showMessageDialog(jfreme, panel, "", JOptionPane.PLAIN_MESSAGE);
    }
     public void createAndDisplayGUI(JDialog jdialog, PanelOptionPaneInterface panel) {
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("Button.background", new Color(51, 102, 153));
        JOptionPane.showMessageDialog(jdialog, panel, "", JOptionPane.PLAIN_MESSAGE);
    }


}
