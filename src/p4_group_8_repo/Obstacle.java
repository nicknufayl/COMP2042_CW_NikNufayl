package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class manages the obstacle sprites in the game
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class Obstacle extends Actor {
	private int speed;
	
	/**
	 * Sets the movement speed of the obstacles in the game
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/**
	 * Sets the images of the obstacles in the game
	 * @param imageLink
	 * @param xpos
	 * @param ypos
	 * @param s The speed
	 * @param w The width
	 * @param h	The height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w, h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
