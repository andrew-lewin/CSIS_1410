package pacman;
/*
 * @authors Andrew Lewin & Joshua Hardesty
 */

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	private Clip clip;

	public Sound(URL url) {
		
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url); // Sets the audio track to in input stream
			clip = AudioSystem.getClip(); // Gets the audio track so that it can be played
			clip.open(audioIn); // Allows access to the audio track

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("You done screwed up. Troubleshoot your code.");
		} 
	}
	
	// loop soundFile FOR..EV..ER
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY); 
	}
	
}
