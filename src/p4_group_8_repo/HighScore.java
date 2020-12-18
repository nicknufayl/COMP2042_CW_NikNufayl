package p4_group_8_repo;

import java.io.Serializable;

/**
 * This class gets the score from the game and compare with previous scores
 * @author Nik Nufayl Daniel Md Nezam, 20063592
 *
 */
public class HighScore implements Serializable, Comparable<HighScore> {
	private int score;
	
	/**
	 * Returns the score
	 * @return 
	 */
    public int getScore() {
        return score;
    }
    
    /**
     * @param score
     */
    public HighScore(int score) {
        this.score = score;
    }
    
    /**
     * Compares scores from past games and current game
     */
    @Override
    public int compareTo(HighScore score1) {              
        return ((Integer)(score1.getScore())).compareTo(getScore());
    }
}