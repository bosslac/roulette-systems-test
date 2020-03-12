package hu.bosslac.roulette;

import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * Strategy: https://www.youtube.com/watch?v=1mfbQ2z9f1I
 * 
 * bet 1 unit on black pairs: 8-11, 10-13, 17-20, 26-29, 28-31
 * bet 9 units on red color
 * 
 * @author bosslac
 *
 */
public class RedAndBlackPairsStrategy extends BaseGame {

	int baseBet = 1;
	int countLoose = 0;
	int maxBetCount = 0;
	int[] random;
	boolean[] isRed;
	
	List<Integer> blackPairList = Arrays.asList(8, 11, 10, 13, 17, 20, 26, 29, 28, 30);

	public RedAndBlackPairsStrategy(int[] random, boolean[] isRed) {
		super();
		this.random = random;
		this.isRed = isRed;
	}
	
	@Override
	public void playTheGame() {
				
		for (int i = 0; i < random.length; i++) {
			
			int bet = baseBet * 14;
			bet(bet);
			
			int spin = random[i];
			
			if (blackPairList.contains(spin) ) {
				win(baseBet * 18);
				System.out.println("WIN " + spin + " bet: " + bet + " balance: " + balance);
				//winCount++;
			} else if (spin != 0 && isRed[i] == true) {
				win(baseBet * 18);
				System.out.println("WIN " + spin + " isRed: " + isRed[i] + " bet: " + bet + " balance: " + balance);
				//winCount++;
			} else {
				System.out.println("LOOSE " + spin +  " isRed: " + isRed[i] + " bet: " + bet + " balance: " + balance);
				countLoose++;
			}
			
		}
		
		System.out.println("END RESULT loosed spins: " + countLoose + " balance: " + balance);
	}

}
