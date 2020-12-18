package p4_group_8_repo;

import java.util.*;
import java.io.*;

/**
 * This class manages the high score system
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class HighScoreManager {
    // An arraylist of the type "score" we will use to work with the scores inside the class
    private ArrayList<HighScore> scores;

    // The name of the file where the highscores will be saved
    private static final String HIGHSCORE_FILE = "scores.dat";

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    /**
     * Initializes the HighScore arraylist
     */
    public HighScoreManager() {
        scores = new ArrayList<HighScore>();
    }
    
    /**
     * Gets scores into the list
     * @return
     */
    public ArrayList<HighScore> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    
    /**
     * Sorts the scores in list
     */
    private void sort() {
        Collections.sort(scores);
    }
    
    /**
     * Adds scores into list
     * @param score
     */
    public void addScore(int score) {
        loadScoreFile();
        scores.add(new HighScore(score));
        updateScoreFile();
    }
    
    /**
     * Loads the Score file
     */
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<HighScore>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }
    
    /**
     * Updates the Score file
     */
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
     /**
      * Prints out the scores
      */
    public String getHighscoreString() {
        String highscoreString = "";
        int max = 10;

        ArrayList<HighScore> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + "\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
}
    
}

