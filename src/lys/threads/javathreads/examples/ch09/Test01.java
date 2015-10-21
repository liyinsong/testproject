package lys.threads.javathreads.examples.ch09;

public class Test01 {

	public int currentScore, totalScore, finalScore;

	public void resetScore(boolean done) {
		totalScore += currentScore;
		if (done) {
			finalScore = totalScore;
			currentScore = 0;
		}
	}

	public int getFinalScore() {
		if (currentScore == 0)
			return finalScore;
		return -1;
	}
}
