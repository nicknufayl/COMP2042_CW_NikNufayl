package p4_group_8_repo;

import java.awt.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {
	AnimationTimer timer;
	MyStage froggerGame, menu, froggerHelp;
	Animal animal;
	BackgroundImage froggerBG, splashScreen, helpScreen;
	Scene game, mainMenu, helpMenu;
	World world;

	
	public static void main(String[] args) {
		launch(args);
	}

	public static enum STATE {
		MENU,
		GAME
	};
		
	public static STATE State = STATE.GAME;
	
	@Override	
	public void start(Stage primaryStage) throws Exception {
		
		displayMenu(primaryStage);

	}

	/**
	 * Set the Main Menu
	 * @param primaryStage
	 */
	private void displayMenu(Stage primaryStage) {
		primaryStage.setTitle("FROGGER");
		Button play = new Button("PLAY");
		Button help = new Button("HOW TO PLAY");
		
		VBox splashScreen = new VBox();
		VBox.setMargin(play, new Insets(10, 10, 30, 10));
		
		splashScreen.setSpacing(20);
		splashScreen.setAlignment(Pos.BOTTOM_CENTER);
		splashScreen.getChildren().addAll(play, help);
		splashScreen.setPadding(new Insets(10, 10, 140, 10));
		
		mainMenu = new Scene(splashScreen, 600, 800);
		mainMenu.getStylesheets().add("file:src/resources/style.css");
		
		primaryStage.setScene(mainMenu);
		primaryStage.show();
		
		
		play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				displayGame(primaryStage);
			}
			
		});
		
		
		/*
		 * To display How to Play screen 
		 */
		
		help.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Button back = displayHelp(primaryStage);
				
				back.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						displayMenu(primaryStage);
					}
					
				});
			}

			/**
			 * Display Help Menu
			 * @param primaryStage
			 * @return
			 */
			private Button displayHelp(Stage primaryStage) {
				Button back = new Button("BACK");
				
				VBox helpScreen = new VBox();
				
				helpScreen.setSpacing(20);
				helpScreen.setAlignment(Pos.TOP_LEFT);
				helpScreen.getChildren().addAll(back);
				helpScreen.setPadding(new Insets(10));
				helpScreen.setStyle("-fx-background-image: url('file:src/resources/FROGGERhelp.jpg');");
				
				helpMenu = new Scene(helpScreen, 600, 800);
				helpMenu.getStylesheets().add("file:src/resources/style.css");
				
				primaryStage.setScene(helpMenu);
				primaryStage.show();
				return back;
			}
			
		});
	}
	

	/**
	 * @param primaryStage
	 */
	private void displayGame(Stage primaryStage) {
		froggerGame = new MyStage();
		animal = new Animal("file:src/resources/froggerUp.png");
		froggerBG = new BackgroundImage("file:src/resources/background.jpg");
		game  = new Scene(froggerGame,600,800);	
		
		froggerGame.add(froggerBG); // add game background	
		addLog(); // spawn logs into game
		addTurtle(); // spawn turtles into game
		addEnd(); // add end spots into game
		addVehicle(); // add vehicles into game
		froggerGame.add(animal);
		froggerGame.add(new Digit(0, 30, 360, 25));		
		froggerGame.start();
		primaryStage.setScene(game);
		primaryStage.show();
		start();
	}
		
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOP:");
            		froggerGame.stopMusic();
            		stop();
            		froggerGame.stop();
            		setAlert();
            	}
            }
        };
    }
	
	
	public void start() {
		//background.playMusic();
		froggerGame.muteMusic(); // set
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  froggerGame.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
    
    public void addLog() {
		froggerGame.add(new Log("file:src/resources/log3.png", 150, 0, 166, 0.75));
		froggerGame.add(new Log("file:src/resources/log3.png", 150, 220, 166, 0.75));
		froggerGame.add(new Log("file:src/resources/log3.png", 150, 440, 166, 0.75));
		
		froggerGame.add(new Log("file:src/resources/logs.png", 300, 0, 276, -2));
		froggerGame.add(new Log("file:src/resources/logs.png", 300, 400, 276, -2));
		
		froggerGame.add(new Log("file:src/resources/log3.png", 150, 50, 329, 0.75));
		froggerGame.add(new Log("file:src/resources/log3.png", 150, 270, 329, 0.75));
		froggerGame.add(new Log("file:src/resources/log3.png", 150, 490, 329, 0.75));
		
	}
	
	public void addTurtle() {
		froggerGame.add(new Turtle(500, 376, -1, 130, 130));
		froggerGame.add(new Turtle(300, 376, -1, 130, 130));
		froggerGame.add(new WetTurtle(700, 376, -1, 130, 130));
		froggerGame.add(new WetTurtle(600, 217, -1, 130, 130));
		froggerGame.add(new WetTurtle(400, 217, -1, 130, 130));
		froggerGame.add(new WetTurtle(200, 217, -1, 130, 130));
	}
	
	public void addEnd() {
		froggerGame.add(new End(13,96));
		froggerGame.add(new End(141,96));
		froggerGame.add(new End(141 + 141-13,96));
		froggerGame.add(new End(141 + 141-13+141-13+1,96));
		froggerGame.add(new End(141 + 141-13+141-13+141-13+3,96));
	}
	

	private void addVehicle() {
		froggerGame.add(new Obstacle("file:src/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
		froggerGame.add(new Obstacle("file:src/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
		froggerGame.add(new Obstacle("file:src/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
		froggerGame.add(new Obstacle("file:src/resources/car1Left.png", 100, 597, -1, 50, 50));
		froggerGame.add(new Obstacle("file:src/resources/car1Left.png", 250, 597, -1, 50, 50));
		froggerGame.add(new Obstacle("file:src/resources/car1Left.png", 400, 597, -1, 50, 50));
		froggerGame.add(new Obstacle("file:src/resources/car1Left.png", 550, 597, -1, 50, 50));
		froggerGame.add(new Obstacle("file:src/resources/truck2Right.png", 0, 540, 1, 200, 200));
		froggerGame.add(new Obstacle("file:src/resources/truck2Right.png", 500, 540, 1, 200, 200));
		froggerGame.add(new Obstacle("file:src/resources/car1Left.png", 500, 490, -5, 50, 50));
	}

	/**
	 * 
	 */
	private void setAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("You Have Won The Game!");
		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
		alert.setContentText("Highest Possible Score: 800");
		alert.show();
	}


}
