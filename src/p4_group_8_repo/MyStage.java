package p4_group_8_repo;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class sets the music background for the game
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
	}

	/**
	 * Sets M key to mute music background and N key to unmute it
	 */
	public void muteMusic() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				switch (event.getCode()) {
					case M:
						stopMusic();
						break;
					case N:
						playMusic();
						break;
					default:
						break;
				}
			}	
		});
	}
	
	/**
	 * Sets music file to be played in the game
	 */
	public void playMusic() {
		String musicFile = "src/resources/Frogger Main Song Theme (loop).mp3";   
		String music = new File(musicFile).toURI().toString(); 
		Media sound = new Media(music);
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	    
	}
	
	/**
	 * Sets the stop command for the music
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
