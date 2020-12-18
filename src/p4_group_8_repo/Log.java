package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class manages the log sprites in the game
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class Log extends Actor {

	private double speed;
	
	/**
	 * Sets the movement speed of the logs in the game
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/**
	 * Sets the images of the logs in the game
	 * @param imageLink
	 * @param size
	 * @param xpos
	 * @param ypos
	 * @param s
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
