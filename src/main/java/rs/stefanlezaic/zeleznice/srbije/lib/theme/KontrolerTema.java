/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.theme;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.SoundEffect;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.constant.SoundConst;

/**
 *
 * @author Stefan
 */
public class KontrolerTema {

    private PanelTema panelTema;
    private final Tema temaEditor = new Tema();
    private final SoundEffect soundEffect = new SoundEffect();

    public KontrolerTema(PanelTema panelTema, JFrame glavnaForma) {
        this.panelTema = panelTema;
        temaEditor.setC(glavnaForma);
        temaEditor.blackTheme();
        ukljuciTamnuTemu();
        postaviPocetneIkonice();
        addListener();
    }

    private void addListener() {
        panelTema.lblTamnaTemaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ukljuciTamnuTemu();
                soundEffect.startAudioKlip(SoundConst.BUP);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                panelTema.getLblDarkMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/sunce1.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelTema.getLblDarkMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/sunce.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        panelTema.lblSvetlaTemaActionListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ukljuciSvetluTemu();
                soundEffect.startAudioKlip(SoundConst.BUP);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.KLIK);
                panelTema.getLblWhiteMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/mesec1.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelTema.getLblWhiteMode().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/mesec.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
    }

    protected void ukljuciTamnuTemu() {
        panelTema.getLblWhiteMode().setVisible(true);
        panelTema.getLblDarkMode().setVisible(false);
        temaEditor.blackTheme();
    }

    protected void ukljuciSvetluTemu() {
        panelTema.getLblWhiteMode().setVisible(false);
        panelTema.getLblDarkMode().setVisible(true);
        temaEditor.whiteTheme();
    }

    private void postaviPocetneIkonice() {
        panelTema.getLblDarkMode().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/sunce.png")));

        panelTema.getLblWhiteMode().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/mesec.png")));
    }

  

}
