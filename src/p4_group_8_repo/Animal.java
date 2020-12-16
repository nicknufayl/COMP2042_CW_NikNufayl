package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		setMoveImage();
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				setMoveKeysPressed(event);
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				setMoveKeysReleased(event);
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		setCarDeathAnimation(now);
		setWaterDeathAnimation(now);
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		intersectingObjectsConfig();
	}

	/**
	 * 
	 */
	private void intersectingObjectsConfig() {
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
		}
	}

	/**
	 * @param now
	 */
	private void setWaterDeathAnimation(long now) {
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			switch(carD) {
				case 1:
					setImage(new Image("file:src/resources/waterdeath1.png", imgSize,imgSize , true, true));
					break;
				case 2:
					setImage(new Image("file:src/resources/waterdeath2.png", imgSize,imgSize , true, true));
					break;
				case 3:
					setImage(new Image("file:src/resources/waterdeath3.png", imgSize,imgSize , true, true));
					break;
				case 4:
					setImage(new Image("file:src/resources/waterdeath4.png", imgSize,imgSize , true, true));
					break;
				case 5:
					setX(300);
					setY(679.8+movement);
					waterDeath = false;
					carD = 0;
					setImage(new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true));
					noMove = false;
					if (points>50) {
						points-=50;
						changeScore = true;
					}
				default:
					break;
			}
		}
	}

	/**
	 * @param now
	 */
	private void setCarDeathAnimation(long now) {
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			switch (carD) {
				case 1:
					setImage(new Image("file:src/resources/cardeath1.png", imgSize, imgSize, true, true));
					break;
				case 2:
					setImage(new Image("file:src/resources/cardeath2.png", imgSize, imgSize, true, true));
					break;
				case 3:
					setImage(new Image("file:src/resources/cardeath3.png", imgSize, imgSize, true, true));
					break;
				case 4:
					setX(300);
					setY(679.8+movement);
					carDeath = false;
					carD = 0;
					setImage(new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true));
					noMove = false;
					if (points>50) {
						points-=50;
						changeScore = true;
					}
					break;
				default:
					break;
				
			}
			
		}
	}
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	public void setMoveImage() {
		imgW1 = new Image("file:src/resources/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/resources/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/resources/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/resources/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/resources/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/resources/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/resources/froggerRightJump.png", imgSize, imgSize, true, true);
	}

	/**
	 * @param event
	 */
	private void setMoveKeysPressed(KeyEvent event) {
		if (noMove) {
			
		}
		else {
		if (second) {		
			switch (event.getCode()) {
				case W:
					move(0, -movement);
		            changeScore = false;
		            setImage(imgW1);
		            second = false;
		            break;
				case A:
					move(-movementX, 0);
		        	setImage(imgA1);
		        	second = false;
		        	break;
				case S:
					move(0, movement);
		        	setImage(imgS1);
		        	second = false;
		        	break;
				case D:
					move(movementX, 0);
		        	setImage(imgD1);
		        	second = false;
		        	break;
		        default:
		        	break;
					}
		}
		else if (event.getCode() == KeyCode.W) {	            	
		    move(0, -movement);
		    setImage(imgW2);
		    second = true;
			}
		else if (event.getCode() == KeyCode.A) {	            	
			 move(-movementX, 0);
			 setImage(imgA2);
			 second = true;
			}
		else if (event.getCode() == KeyCode.S) {	            	
			 move(0, movement);
			 setImage(imgS2);
			 second = true;
			}
		else if (event.getCode() == KeyCode.D) {	            	
			 move(movementX, 0);
			 setImage(imgD2);
			 second = true;
			}		
		}
	}

	/**
	 * @param event
	 */
	private void setMoveKeysReleased(KeyEvent event) {
		if (noMove) {}
		else {			
			switch (event.getCode()) {
				case W:
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
		            move(0, -movement);
		            setImage(imgW1);
		            second = false;
		            break;
				case A: 
					move(-movementX, 0);
		        	setImage(imgA1);
		        	second = false;
		        	break;
				case S:
					move(0, movement);
		        	setImage(imgS1);
		        	second = false;
		        	break;
				case D:
					move(movementX, 0);
		        	setImage(imgD1);
		        	second = false;
		        	break;
		        default:
		        	break; 
			
			}
		}
	}

}
