package hu.bosslac.roulette;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class Roulette63System extends BaseGame {
	
	static int baseBet = 1;
	static int countLoose = 0;
	
	int betCount = 5;
	
	
	public Roulette63System(int[] random, int betCount) {
		super(random);
		this.betCount = betCount;
	}
	

	public void playTheGame() {
		
		final PrimitiveIterator.OfInt rndIterator = Arrays.stream(random).iterator();
		
		while(rndIterator.hasNext()) {
			
			for (int i = 0; i < this.betCount && rndIterator.hasNext(); i++) {
				
				int bet = baseBet * (i + 1) * 2;
				bet(bet);
				
				int spin = rndIterator.nextInt();
				
				if (spin > 0 && spin < 25) {
					win(bet/2 * 3);
					System.out.println("WIN " + spin +  " bet: " + bet + " balance: " + balance);
					break;
				}
				System.out.println("LOOSE in round: " + i + " spin: " + spin +  " bet: " + bet + " balance: " + balance);
				
				if (i == betCount - 1) {
					countLoose++;
				}
			}
		}
		
		System.out.println("REAL LOOSE count " + countLoose);
	}
}
