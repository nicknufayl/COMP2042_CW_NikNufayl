package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class manages the turtle sprites in the game
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class Turtle extends Actor{
	Image turtle1, turtle2, turtle3;
	private int speed;
	
	/**
	 * Sets the movement speed for the turtles in the game
	 */
	@Override
	public void act(long now) {

		setWhichTurtleNow(now);
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	/**
	 * Sets which animation to be displayed at a current time of the game
	 * @param now
	 */
	private void setWhichTurtleNow(long now) {
		if (now/900000000  % 3 ==0) {
			setImage(turtle2);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtle1);
			
		}
		else if (now/900000000 % 3 == 2) {
			setImage(turtle3);
			
		}
	}
	
	/**
	 * Configures the turtles images in the game
	 * @param xpos
	 * @param ypos
	 * @param s The speed
	 * @param w The width
	 * @param h The height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		setTurtleImage(w, h);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	/**
	 * Sets the turtle images in the game
	 * @param w The width
	 * @param h The height
	 */
	private void setTurtleImage(int w, int h) {
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3.png", w, h, true, true);
	}
}
