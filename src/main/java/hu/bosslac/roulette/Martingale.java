package hu.bosslac.roulette;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class Martingale {
	static int baseBet = 1;
	static int balance = 5000;
	static int countLoose = 0;
	static int maxBetCount = 0;
	
	int[] random;
	int maxBetCeil = 9;
	
	
	public Martingale(int[] random) {
		super();
		this.random = random;
	}
	

	public void playTheGame() {
		
		final PrimitiveIterator.OfInt rndIterator = Arrays.stream(random).iterator();
		
		while(rndIterator.hasNext()) {
			
			boolean win = false;
					
			for (int i = 0; i < maxBetCeil && !win && rndIterator.hasNext(); i++) {
				
				if (i > maxBetCount) {
					maxBetCount = i;
				}
				
				int spin = rndIterator.nextInt(); 
				int bet = (int) Math.pow(baseBet * 2, i);
				bet(bet);
				
				
				if (spin > 18) {
					win(bet * 2);
					System.out.println("WIN " + spin +  " bet: " + bet + " balance: " + balance);
					break;
				}
				System.out.println("LOOSE in round: " + i + " spin: " + spin +  " bet: " + bet + " balance: " + balance);
				
				if (i == maxBetCeil - 1) {
					countLoose++;
				}
			}
		}
		
		System.out.println("REAL LOOSE count " + countLoose);
		System.out.println("MAX BET count " + maxBetCount);
	}

	
	static void bet(int bet) {
		balance = balance - bet;	
	}
	
	static void win(int won) {
		balance = balance + won;	
	}
}
