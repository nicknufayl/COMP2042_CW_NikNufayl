package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class manages the wet turtle sprites in the game
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class WetTurtle extends Actor{
	Image turtle1, turtle2, turtle3, turtle4;
	private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	
	/**
	 * Sets the movement speed for the wet turtles in the game
	 */
	@Override
	public void act(long now) {
		
		isTurtleSunk(now);
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	/**
	 * Sets the turtle to sunk underwater or not
	 * @param now
	 */
	private void isTurtleSunk(long now) {
		if (now/900000000  % 4 ==0) {
			setImage(turtle2);
			sunk = false;	
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtle3);
			sunk = false;
		} 
		else if (now/900000000 %4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
	}
	
	/**
	 * Configures the wet turtle images in the game
	 * @param xpos
	 * @param ypos
	 * @param s The speed
	 * @param w The width
	 * @param h The height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		setTurtleImage(w, h);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	/**
	 * Sets the wet turtle images in the game
	 * @param w The width
	 * @param h The height
	 */
	private void setTurtleImage(int w, int h) {
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/resources/TurtleAnimation4Wet.png", w, h, true, true);
	}
	
	/**
	 * Checks if turtle is sunk or not
	 * @return
	 */
	public boolean isSunk() {
		return sunk;
	}
}
