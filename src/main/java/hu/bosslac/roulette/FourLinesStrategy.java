package hu.bosslac.roulette;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * https://www.youtube.com/watch?v=lVlMLfBU5q4
 * @author bosslac
 *
 */
public class FourLinesStrategy extends BaseGame {

	int baseBet = 1;
	int countLoose = 0;
	int maxBetCount = 0;
	int[] random;

	public FourLinesStrategy(int[] random) {
		super();
		this.random = random;
	}

	@Override
	public void playTheGame() {
		
		final PrimitiveIterator.OfInt rndIterator = Arrays.stream(random).iterator();
		
		while(rndIterator.hasNext()) {
			
			int winCount = 1;
			
			for (int i = 0; i <= winCount && rndIterator.hasNext(); i++) {
				
				int multiplier = winCount;
				if (winCount > 2) {
					multiplier = 2;
				}
				
				int bet = baseBet * multiplier * 4;
				bet(bet);
				
				int spin = rndIterator.nextInt();
				
				if (spin > 0 && spin < 25) {
					win(baseBet * 6);
					System.out.println("WIN " + spin +  " bet: " + bet + " balance: " + balance);
					winCount++;
				} else {
					System.out.println("LOOSE in round: " + i + " spin: " + spin +  " bet: " + bet + " balance: " + balance);
					break;
				}
				
				if (winCount > 3) {
					break;
				}
			}
		}
		
		System.out.println("REAL LOOSE count " + countLoose);
	}
	
	
	
	
}
