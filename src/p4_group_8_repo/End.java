package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class sets the objective points in the game
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	/**
	 * Sets the end's positions into the game
	 * @param x 
	 * @param y
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/resources/End.png", 60, 60, true, true));
	}
	
	/**
	 * Set the end images into the game if activated
	 */
	public void setEnd() {
		setImage(new Image("file:src/resources/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	/**
	 * Returns true if player reaches one of the ends
	 * @return
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
