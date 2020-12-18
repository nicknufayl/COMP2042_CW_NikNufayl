package p4_group_8_repo;

import java.io.Serializable;

public class HighScore implements Serializable, Comparable<HighScore> {
	private int score;

    public int getScore() {
        return score;
    }

    public HighScore(int score) {
        this.score = score;
    }
    
    @Override
    public int compareTo(HighScore score1) {              
        return ((Integer)(score1.getScore())).compareTo(getScore());
    }
}