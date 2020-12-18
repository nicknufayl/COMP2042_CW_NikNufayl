	package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class sets the image dimensions of the game background
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	/**
	 * Sets background image with the dimensions
	 * @param imageLink
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
