package edu.ipfw.sumfun;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public enum Sounds {//start Sounds class
	
	BOOP("Boop1.wav"),
	SHUFFLE("Shuffle1.wav"),
	REMOVE("Remove1.wav"),
	BGM1("bgmFun.wav");
	   
	   // Nested class for specifying volume
	   public static enum Volume {//start Volume class
	      MUTE, LOW, MEDIUM, HIGH
	   }//end Volume class
	   
	   public static Volume volume = Volume.MEDIUM;
	   
	   // Each sound effect has its own clip, loaded with its own sound file.
	   private Clip clip;
	   
	   /*
	    * Constructs each element of the enum with its own sound file.
	    * 
	    * @param soundFileName - the name of the sound file
	    */
	  Sounds(String soundFileName) {//start Sounds constructor
	      try {
	         // Use URL (instead of File) to read from disk and JAR.
	         URL url = this.getClass().getClassLoader().getResource(soundFileName);
	         // Set up an audio input stream piped from the sound file.
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	         // Get a clip resource.
	         clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioInputStream);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }//end Sounds constructor
	   
	  /*
	   * Play or Re-play the sound effect from the beginning, by rewinding.
	   */
	   public void play() {//start play method
	      if (volume != Volume.MUTE) {
	         if (clip.isRunning()){
	            clip.stop();   // Stop the player if it is still running
	         }
	         clip.setFramePosition(0); // rewind to the beginning
	         clip.start();     // Start playing
	      }
	   }//end play method
	   
	   /*
	    * Loops the audio clip if volume is not muted.
	    */
	   public void loop(){//start loop method
		   if(volume != Volume.MUTE){
			  
			   clip.loop(Clip.LOOP_CONTINUOUSLY);
		   }
	   }//end loop method
	   
	   /*
	    * Stops the clip from looping
	    */
	   public void stopLoop(){//start stopLoop method
		   if(volume != Volume.MUTE){
			   
			   clip.stop();
		   }
	   }//end stopLoop method

	   /*
	    * Optional static method to pre-load all the sound files.
	    */
	   static void init() {//start init method
	      values(); // calls the constructor for all the elements
	   }//end init method
	   
}//end Sounds class
