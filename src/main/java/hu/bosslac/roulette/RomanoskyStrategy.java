package hu.bosslac.roulette;

import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;

public class RomanoskyStrategy extends BaseGame {

	int baseBet = 1;
	int dozenBaseBet = 3;
	int countLoose = 0;
	int maxBetCount = 0;
	
	List<Integer> squaresNumbers = Arrays.asList(1, 2, 4, 5, 8, 9, 11, 12);
	
	public RomanoskyStrategy(int[] random) {
		super(random);
	}

	@Override
	public void playTheGame() {
		
		final PrimitiveIterator.OfInt rndIterator = Arrays.stream(random).iterator();
		
		while(rndIterator.hasNext()) {
			
			int looseCuont = 1;
			
			for (int i = 0; looseCuont < 12 && rndIterator.hasNext(); i++) {
				
				int singleSquareBet = baseBet * (looseCuont + 1);
				int singleDozenBet = dozenBaseBet * (looseCuont + 1);
				int bet = 2 * (singleDozenBet + singleSquareBet);
				bet(bet);
				
				int spin = rndIterator.nextInt();
				
				if (squaresNumbers.contains(spin) ) {
					win(singleSquareBet * 8);
					System.out.println("WIN " + spin +  " bet: " + bet + " balance: " + balance);
					//winCount++;
				} else if (spin >= 13 && spin <= 36) {
					win(singleDozenBet * 3);
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
