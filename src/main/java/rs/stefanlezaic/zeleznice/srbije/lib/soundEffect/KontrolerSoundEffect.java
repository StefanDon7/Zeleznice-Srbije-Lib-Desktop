/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.soundEffect;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import rs.stefanlezaic.zeleznice.srbije.lib.soundEffect.constant.SoundConst;

/**
 *
 * @author Stefan
 */
public class KontrolerSoundEffect {

    private PanelSound panelSound;
    private final SoundEffect soundEffect = new SoundEffect();

    public KontrolerSoundEffect(PanelSound panelSound) {
        this.panelSound = panelSound;
        postaviPocetneIkoniceITekst();
        prebaciNaTemuZaUkljcenZvuk();
        addListener();
    }

    private void addListener() {
        panelSound.getLblSoundAddMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soundEffect.startAudioKlip(SoundConst.BUP);
                prebaciNaTemuZaIskljucenZvuk();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelSound.getLblSound().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/audioOff1.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelSound.getLblSound().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/audioOn.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        panelSound.getLblSoundOffAddMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                prebaciNaTemuZaUkljcenZvuk();
                soundEffect.startAudioKlip(SoundConst.INTERFEJS);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelSound.getLblSoundOff().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/audioOn1.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelSound.getLblSoundOff().
                        setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/audioOff.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
    }

    private void postaviPocetneIkoniceITekst() {
        panelSound.getLblSound().setText("Zvuk");
        panelSound.getLblSound().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/audioOn.png")));
        panelSound.getLblSoundOff().setText("Zvuk");
        panelSound.getLblSoundOff().
                setIcon(new ImageIcon(getClass().getResource("/rs/stefanlezaic/zeleznice/srbije/lib/resources/icons/audioOff.png")));

    }

    private void prebaciNaTemuZaUkljcenZvuk() {
        panelSound.getLblSound().setVisible(true);
        panelSound.getLblSoundOff().setVisible(false);
        SoundEffect.ukljuciZvuk();

    }

    private void prebaciNaTemuZaIskljucenZvuk() {
        panelSound.getLblSound().setVisible(false);
        panelSound.getLblSoundOff().setVisible(true);
        SoundEffect.iskljuciZvuk();
    }
}
