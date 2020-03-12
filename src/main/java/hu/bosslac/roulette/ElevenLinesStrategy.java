package hu.bosslac.roulette;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * https://www.youtube.com/watch?v=lVlMLfBU5q4
 * @author bosslac
 *
 */
public class ElevenLinesStrategy extends BaseGame {

	int baseBet = 1;
	int countLoose = 0;
	int maxBetCount = 0;
	int[] random;

	public ElevenLinesStrategy(int[] random) {
		super();
		this.random = random;
	}

	@Override
	public void playTheGame() {
		
		final PrimitiveIterator.OfInt rndIterator = Arrays.stream(random).iterator();
		
		while(rndIterator.hasNext()) {
			
			int winCount = 1;
			
			for (int i = 0; i <= winCount && rndIterator.hasNext(); i++) {
				
				int bet = baseBet * winCount * 11;
				bet(bet);
				
				int spin = rndIterator.nextInt();
				
				if ((spin >= 4 && spin <= 6) || (spin >= 31 && spin <= 33)) {
					win(baseBet * 6);
					System.out.println("WIN " + spin +  " bet: " + bet + " balance: " + balance);
					//winCount++;
				} else if (spin >= 7 && spin <= 30) {
					win(baseBet * 12);
					System.out.println("WIN " + spin +  " bet: " + bet + " balance: " + balance);
					//winCount++;
				} else {
					System.out.println("LOOSE in round: " + i + " spin: " + spin +  " bet: " + bet + " balance: " + balance);
					break;
				}
			}
		}
		
		System.out.println("REAL LOOSE count " + countLoose);
	}
	
	
	
	
}
