package hu.bosslac.roulette;

public abstract class BaseGame {

	int balance = 5000;
	int[] random;
	
	public BaseGame(int[] random) {
		this.random = random;
	}
	
	void bet(int bet) {
		balance = balance - bet;	
	}
	
	void win(int won) {
		balance = balance + won;	
	}
	
	public abstract void playTheGame();

}
