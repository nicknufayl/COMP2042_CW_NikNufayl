package p4_group_8_repo;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	public MyStage() {
	}

	/**
	 * 
	 */
	public void setMute() {
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
	
		
	public void playMusic() {
		String musicFile = "src/resources/Frogger Main Song Theme (loop).mp3";   
		String music = new File(musicFile).toURI().toString(); 
		Media sound = new Media(music);
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	    
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	

	

}
