/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.stefanlezaic.zeleznice.srbije.lib.soundEffect;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Stefan
 */
public class SoundEffect {

    private final String putanja = "/rs/stefanlezaic/zeleznice/srbije/lib/resources/sound/effect/";
    private URL url;
    private static float jacina=-20;

    public void startAudioKlip(String soundConst) {
        url = getClass().getResource(putanja+soundConst);
        AudioInputStream audioIn;
        try {
            audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(jacina);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("Greska:" + ex);
        }
    }
    
    public static void iskljuciZvuk(){
        jacina=-1000;
    }
    public static void ukljuciZvuk(){
        jacina=-30;
    }
    
    
}
