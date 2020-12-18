package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * This class displays the score during the game
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Updates the score display in the game
	 * @param n
	 * @param dim
	 * @param x
	 * @param y
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/resources/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
