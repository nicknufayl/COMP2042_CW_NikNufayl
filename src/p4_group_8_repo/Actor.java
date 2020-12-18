package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * This class sets the coordinates and positions of the sprites
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */

public abstract class Actor extends ImageView{

	/**
	 * Sets x and y positions
	 * @param dx 
	 * @param dy
	 */
    public void move(double dx, double dy) {
        setX(xPosition(dx));
        setY(yPosition(dy));
    }

	/**
	 * Gets y position coordinates
	 * @param dy
	 * @return x Position
	 */
	private double yPosition(double dy) {
		return getY() + dy;
	}

	/**
	 * Gets x position coordinates
	 * @param dx
	 * @return y Position
	 */
	private double xPosition(double dx) {
		return getX() + dx;
	}

    public World getWorld() {
        return (World) getParent();
    }
    
    /**
     * Gets the width value
     * @return
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    
    /**
     * Gets the height value
     * @return
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long now);

}
